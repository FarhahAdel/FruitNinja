package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.utils.events.CustomTimer;
import fruitNinja.utils.timerTasks.Round;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;

public class ZenStrategy implements GameStrategy {
    private Timer timer;
    private final int time = 90;
    private final StrategyType strategyType = StrategyType.ZEN;

    public ZenStrategy()
    {
        timer = new Timer();
    }

    @Override
    public void initGame(Canvas canvas) {
        //TODO: THIS WHOLE METHOD TO BE CHANGED
        TimerTask timerTask = new Round(canvas, strategyType);
        int x = 4500; // X TO BE CHANGED UPON THE LAST FRUIT IS DOWN
        timer.schedule(timerTask, 500, x);
    }

    @Override
    public void startTimer() {
        CustomTimer customTimer = new CustomTimer(time);
        customTimer.initCustomTimer();
    }
}
