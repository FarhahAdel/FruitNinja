package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.utils.timerTasks.Round;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class BaseStrategy implements GameStrategy{
    final StrategyType strategyType;
    private Timer timer;
    public BaseStrategy(StrategyType strategyType){
        this.strategyType = strategyType;
        timer = new Timer();

    }
    @Override
    public void initGame(Canvas canvas) {
        int x = 4500;
        timer.schedule(new Round(canvas,strategyType),500,x);

        Timer pauseTimer = new Timer();

        final Boolean[] wasPaused = {false};

        pauseTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(GamePlayActions.isPaused){
                    wasPaused[0] = true;
                    timer.cancel();
                }
                else if(wasPaused[0]){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    wasPaused[0] = false;
                    timer = new Timer();
                    timer.schedule(new Round(canvas,strategyType),500,x);
                }
            }
        },500,500);
    }


    @Override
    public StrategyType getStrategyType() {
        return this.strategyType;
    }

}
