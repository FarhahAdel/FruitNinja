package fruitNinja.models.modes.Stratgies;

import fruitNinja.models.logic.GamePlayActions;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.logic.Round;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public abstract class BaseStrategy implements GameStrategy{
    private final StrategyType strategyType;
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
                if(GamePlayActions.isPaused == -1){
                    wasPaused[0] = false;
                    timer.cancel();
                    timer.purge();
                    pauseTimer.cancel();
                    pauseTimer.purge();
                }
                if(GamePlayActions.isPaused == 1){
                    wasPaused[0] = true;
                    timer.cancel();
                }
                else if(wasPaused[0]){
                    wasPaused[0] = false;
                    try{
                        TimeUnit.SECONDS.sleep(2);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
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
