package fruitNinja.utils.events;

import fruitNinja.models.gameModes.StrategyType;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Timer {
    private int STARTTIME;
    private Timeline timeline;
    private IntegerProperty timeSeconds;
    private Label label;
    private StrategyType strategyType;
    private boolean over=false;

    public boolean isOver() {
        return over;
    }


    public Timer(StrategyType strategyType, Label label) {
      this.strategyType=strategyType;
        this.label = label;

    }

    public void startTimer() {
        switch (strategyType) {
            case ZEN:
                STARTTIME = 90;
                break;
            case ARCADE:
                STARTTIME = 10;
                break;
        }
        timeSeconds = new SimpleIntegerProperty(STARTTIME);
    }
    private int seconds;

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getSTARTTIME() {
        return STARTTIME;
    }

    private void updateTime() {
        // updates and checks seconds
        //timerLabel.setText(String.valueOf(timeSeconds.get()));
        label.textProperty().bind(timeSeconds.asString());
        seconds = timeSeconds.get();
        timeSeconds.set(seconds - 1);
        if (timeSeconds.get() <= 0) {
            over= true;
            timeline.stop();

        }
    }
    private Timeline timeline2;
    public boolean timerFinished(){
        timeline2 = new Timeline(new KeyFrame(Duration.seconds(10), evt->setOver(true)));
        timeline2.setCycleCount(1);
        timeline2.play();
        return true;
    }
    public void updateTimer(){
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt->updateTime()));
        timeline.setCycleCount(Timeline.INDEFINITE); // repeat over and over again
        timeSeconds.set(STARTTIME);
        timeline.play();

    }
    public boolean timerOver(){
        return isOver();
    }
}