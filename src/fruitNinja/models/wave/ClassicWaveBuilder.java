package fruitNinja.models.wave;

import fruitNinja.models.Difficulty;
import fruitNinja.models.bombs.Bomb;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameObjects.Sprite;
import fruitNinja.utils.RandomObjectGenerator;
import fruitNinja.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;

public class ClassicWaveBuilder implements WaveBuilder {

    private Wave wave;
    private RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();
    private Utils utils = new Utils();

    public ClassicWaveBuilder()
    {
        wave = new Wave();
        wave.setWaveObjects(new ArrayList<>());
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        wave.setDifficulty(difficulty);
    }

    @Override
    public void buildFruits() {
        int n = utils.generateRandomFruitNumBasedOnDifficulty(wave.getDifficulty());
        ArrayList<Fruit> fruits = new ArrayList<>();

        for (int i = 0; i < n; i++)
            fruits.add(randomObjectGenerator.generateRandomFruit());

        wave.addFruits(fruits);
    }

    @Override
    public void buildSpecialFruits() {
    }

    @Override
    public void buildBombs() {
        int n = utils.generateRandomBombNumBasedOnDifficulty(wave.getDifficulty());
        ArrayList<Bomb> bombs = new ArrayList<>();

        //TODO: CHANGE THIS TO BE ONLY FATAL BOMBS
        for (int i = 0; i < n; i++)
            bombs.add(randomObjectGenerator.generateRandomBomb());

        wave.addBombs(bombs);
    }

    @Override
    public void shuffleWave() {
        ArrayList<Sprite> waveObjects = wave.getWaveObjects();
        Collections.shuffle(waveObjects);
        wave.setWaveObjects(waveObjects);
    }

    @Override
    public Wave getWave() {
        return wave;
    }
}
