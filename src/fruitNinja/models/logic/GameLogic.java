package fruitNinja.models.logic;

import fruitNinja.models.Difficulty;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.entities.Sprite;
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

    public void startRound(GameProperties gameProperties, GamePlayActions gamePlayActions)
    {
        if( GamePlayActions.isPaused !=0)  return;
        int wave = gameProperties.getWave();
        Difficulty difficulty = utils.getDifficultyByWaveNumber(wave);
        ArrayList<Sprite> sprites = gamePlayService.generateWave(strategyType ,difficulty);
        gamePlayActions.throwFruits(sprites, difficulty);
        gameProperties.incWave();
    }
}
