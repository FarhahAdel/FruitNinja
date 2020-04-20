package fruitNinja.utils.timerTasks;

import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameLogic.GameLogic;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameLogic.GamePlayService;
import fruitNinja.models.gameLogic.GameState;
import fruitNinja.models.gameModes.StrategyType;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.TimerTask;

public class Round extends TimerTask {

    private GamePlayActions gamePlayActions;
    private GameLogic gameLogic;
    private GameState gameState;

    public Round(Canvas canvas, StrategyType strategyType)
    {
        // THESE SHOULD BE INJECTED VIA DEPENDENCIES
        gamePlayActions = new GamePlayActions();
        gamePlayActions.setCanvas(canvas);
        gameLogic = new GameLogic(strategyType);
        gameState = new GameState();
    }

    @Override
    public void run() {
        gameLogic.startRound(gameState, gamePlayActions);
    }

}
