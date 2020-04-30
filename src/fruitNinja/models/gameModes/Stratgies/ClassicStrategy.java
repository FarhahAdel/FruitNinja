package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.utils.timerTasks.Round;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;

public class ClassicStrategy implements GameStrategy {

    private Timer timer;

    private final StrategyType strategyType = StrategyType.CLASSIC;

    public ClassicStrategy()
    {
        timer = new Timer();
    }

    @Override
    public void initGame(Canvas canvas) {
        TimerTask timerTask = new Round(canvas, strategyType);
        int x = 4500;
        timer.schedule(timerTask, 500, x);
    }

    @Override
    public void startTimer() {

    }

    @Override
    public void gameEndingCondition() {

    }


}