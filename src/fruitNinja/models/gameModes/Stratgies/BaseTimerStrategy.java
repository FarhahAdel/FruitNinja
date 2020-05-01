package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.utils.Utils;
import fruitNinja.utils.events.CustomTimer;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class BaseTimerStrategy extends BaseStrategy implements TimerStrategy {
    private final int time = 60;
    private Stage stage;
    public BaseTimerStrategy(StrategyType strategyType){
        super(strategyType);
    }
    @Override
    public void initGame(Canvas canvas){
        setStage(canvas);
        super.initGame(canvas);
    }

    @Override
    public void startCustomTimer() {
        CustomTimer customTimer = new CustomTimer(time);
        customTimer.initCustomTimer();
    }

    @Override
    public void gameEndingCondition() {
        Utils utils = new Utils();
        utils.showGameOverAfterTime(time, stage, super.strategyType);
    }

    private void setStage(Canvas canvas) {
        this.stage = (Stage) canvas.getScene().getWindow();
    }
}
