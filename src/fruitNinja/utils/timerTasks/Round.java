package fruitNinja.utils.timerTasks;

import fruitNinja.models.gameLogic.GameLogic;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameLogic.GameProperties;
import fruitNinja.models.gameModes.StrategyType;
import javafx.scene.canvas.Canvas;

import java.util.TimerTask;

public class Round extends TimerTask {

    private GamePlayActions gamePlayActions;
    private GameLogic gameLogic;
    private GameProperties gameProperties;
    private Boolean wasPaused = false;

    private Canvas canvas;
    private StrategyType strategyType;

    public Round(Canvas canvas, StrategyType strategyType )
    {
        gamePlayActions = new GamePlayActions();
        gamePlayActions.setCanvas(canvas);
        gameLogic = new GameLogic(strategyType);
        gameProperties = new GameProperties();
        this.canvas = canvas;
        this.strategyType = strategyType;
    }

    @Override
    public void run() {
        gameLogic.startRound(gameProperties, gamePlayActions);
    }

}
