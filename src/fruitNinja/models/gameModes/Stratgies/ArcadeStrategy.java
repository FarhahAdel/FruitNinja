package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.utils.Utils;
import fruitNinja.utils.events.CustomTimer;
import fruitNinja.utils.timerTasks.Round;
import fruitNinja.views.guiUtils.Navigation;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class ArcadeStrategy implements GameStrategy {
    private Timer timer;
    private final int time = 60;
    private Stage stage;
    private final StrategyType strategyType = StrategyType.ARCADE;

    public ArcadeStrategy()
    {
        timer = new Timer();
    }

    @Override
    public void initGame(Canvas canvas) {
        setStage(canvas);
        TimerTask timerTask = new Round(canvas, strategyType);
        int x = 4500;
        timer.schedule(timerTask, 500, x);
    }

    @Override
    public void startTimer() {
        CustomTimer customTimer = new CustomTimer(time);
        customTimer.initCustomTimer();
    }

    @Override
    public void gameEndingCondition() {
        Utils utils = new Utils();
        utils.showGameOverAfterTime(time, stage, strategyType);
    }

    private void setStage(Canvas canvas)
    {
        this.stage = (Stage)canvas.getScene().getWindow();
    }
}
