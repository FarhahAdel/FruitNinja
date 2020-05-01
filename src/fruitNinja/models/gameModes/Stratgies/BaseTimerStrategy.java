package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
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
        CustomTimer customTimer = new CustomTimer(time,stage,super.strategyType);
        customTimer.initCustomTimer();
    }

    private void setStage(Canvas canvas) {
        this.stage = (Stage) canvas.getScene().getWindow();
    }
}
