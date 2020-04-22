package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.utils.timerTasks.Round;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;

public class ArcadeStrategy implements GameStrategy {
    private Timer timer;
    private TimerTask timerTask;
    private final int time=60;
    private StrategyType strategyType = StrategyType.ARCADE;

    public ArcadeStrategy()
    {
        timer = new Timer();
    }
    public int getTime() {
        return time;
    }


    @Override
    public void initGame(Canvas canvas) {

        // THIS WHOLE METHOD TO BE CHANGED

        timerTask = new Round(canvas, strategyType);
        int x = 4500; // X TO BE CHANGED UPON THE LAST FRUIT IS DOWN
        timer.schedule(timerTask, 500, x);
    }
}
