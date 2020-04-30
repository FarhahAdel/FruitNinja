package fruitNinja.models.gameLogic;

import fruitNinja.models.Difficulty;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.gameObjects.Sprite;
import fruitNinja.models.wave.WaveBuilder;
import fruitNinja.models.wave.WaveBuilderFactory;
import fruitNinja.models.wave.WaveDirector;
import fruitNinja.utils.RandomObjectGenerator;
import fruitNinja.utils.Utils;


import java.util.ArrayList;


public class GamePlayService {

    private Utils utils;

    public GamePlayService()
    {
        utils = new Utils();

    }

    public ArrayList<Sprite> generateWave(StrategyType strategyType, Difficulty difficulty) {
        WaveBuilderFactory waveBuilderFactory =  new WaveBuilderFactory();
        WaveBuilder waveBuilder = waveBuilderFactory.createWaveBuilder(strategyType);
        WaveDirector waveDirector = new WaveDirector(waveBuilder, difficulty);
        waveDirector.constructWave();
        return waveDirector.getWave().getWaveObjects();
    }
}
