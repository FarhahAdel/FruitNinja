package fruitNinja.utils.timerTasks;

import fruitNinja.models.gameLogic.GameLogic;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameLogic.GameProperties;
import fruitNinja.models.gameModes.StrategyType;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;

public class Round extends TimerTask {

    private GamePlayActions gamePlayActions;
    private GameLogic gameLogic;
    private GameProperties gameProperties;
    private Timer timer;

    public Round(Canvas canvas, StrategyType strategyType, Timer timer)
    {
        gamePlayActions = new GamePlayActions();
        gamePlayActions.setCanvas(canvas);
        gameLogic = new GameLogic(strategyType);
        gameProperties = new GameProperties();
        this.timer = timer;
    }

    @Override
    public void run() {
        if(GamePlayActions.isPaused) {timer.cancel(); timer.purge();}
        gameLogic.startRound(gameProperties, gamePlayActions);
    }

}
