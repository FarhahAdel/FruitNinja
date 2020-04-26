package fruitNinja.utils.events;

import fruitNinja.guiUpdate.ControlsUpdater;
import fruitNinja.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.models.gameModes.StrategyType;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public class CustomTimer {
    private int startingTime;
    private Timeline timeline;
    private IntegerProperty timeSeconds;
    private ControlsUpdater controlsUpdater;
    private boolean over = false;

    public CustomTimer(int startingTime)
    {
        this.startingTime = startingTime;
        this.controlsUpdater = ControlsUpdaterSingleton.getInstance();
    }

    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }

    public void initCustomTimer()
    {
        startTimer();
        updateTimer();
    }


    private void startTimer() {
        timeSeconds = new SimpleIntegerProperty(startingTime);
        controlsUpdater.updateTimer(String.valueOf(startingTime));
    }

    private void updateTime() {
        controlsUpdater.updateTimer(String.valueOf(timeSeconds.getValue()));
        int seconds = timeSeconds.get();
        timeSeconds.set(seconds - 1);
        if (timeSeconds.get() <= 0) {
            over= true;
            timeline.stop();
        }
    }

    private void updateTimer(){
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt->updateTime()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeSeconds.set(startingTime);
        timeline.play();
    }
}