package fruitNinja.models.gameLogic;

import fruitNinja.models.Difficulty;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.gameObjects.Sprite;
import fruitNinja.utils.Utils;

import java.util.ArrayList;

public class GameLogic {

    private StrategyType strategyType;

    private GamePlayService gamePlayService = new GamePlayService();
    private Utils utils = new Utils();

    public GameLogic(StrategyType strategyType)
    {
        this.strategyType = strategyType;
    }

    public void startRound(GameState gameState, GamePlayActions gamePlayActions)
    {
        if(GamePlayActions.isPaused) return;
        int wave = gameState.getWave();
        Difficulty difficulty = utils.getDifficultyByWaveNumber(wave);
        ArrayList<Sprite> sprites = gamePlayService.generateWave(strategyType ,difficulty);
        gamePlayActions.throwFruits(sprites, difficulty);
        // TODO: LISTEN FOR MOUSE CLICKS (AND IT'S EFFECTS)
        gameState.incWave();
    }
}
