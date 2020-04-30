package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.utils.timerTasks.Round;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;

public class BaseStrategy implements GameStrategy{
    final StrategyType strategyType;
    private Timer timer;
    public BaseStrategy(StrategyType strategyType){
        this.strategyType = strategyType;
        timer = new Timer();

    }
    @Override
    public void initGame(Canvas canvas) {
        TimerTask timerTask = new Round(canvas,strategyType,timer);
        int x = 4500;
        timer.schedule(timerTask,500,x);
    }

    @Override
    public StrategyType getStrategyType() {
        return this.strategyType;
    }
}
