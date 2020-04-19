package fruitNinja.models.gameLogic;

import fruitNinja.models.Difficulty;
import fruitNinja.models.bombs.Bomb;
import fruitNinja.models.bombs.BombFactory;
import fruitNinja.models.bombs.BombType;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.fruits.FruitFactory;
import fruitNinja.models.fruits.FruitType;
import fruitNinja.models.fruits.ordinary.OrdinaryFruitType;
import fruitNinja.models.fruits.special.SpecialFruitType;
import fruitNinja.models.gameObjects.GameObjectType;
import fruitNinja.models.gameObjects.Sprite;
import fruitNinja.utils.Utils;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class GamePlayService {

    private Utils utils;
    private FruitFactory fruitFactory;
    private BombFactory bombFactory;
    public GamePlayService()
    {
        utils = new Utils();
        fruitFactory = new FruitFactory();
        bombFactory = new BombFactory();
    }

    public Difficulty getDifficultyByWaveNumber(int wave)
    {
        if (wave > 10) return Difficulty.HARD;
        else if (wave > 5) return Difficulty.MEDIUM;
        else return Difficulty.EASY;
    }
    public ArrayList<Sprite> generateWave(Difficulty difficulty)
        {
        int nFruits = utils.generateRandomFruitNumBasedOnDifficulty(difficulty);
        int nBombs=utils.generateRandomBombNumBasedOnDifficulty(difficulty);
        ArrayList<Sprite> sprites = new ArrayList<>();
        for (int i = 0; i < nFruits; i++)
            sprites.add(generateRandomFruit());
        for(int i=0;i<nBombs;i++)
            sprites.add(generateRandomBomb());
        Collections.shuffle(sprites);
        return sprites;
    }


    private Fruit generateRandomFruit()
    {
        String randomFruitName = utils.randomValueFromEnum(OrdinaryFruitType.class).toString();
        return fruitFactory.createFruit(randomFruitName, FruitType.ORDINARY);
    }

    public Fruit generateRandomSpecialFruit()
    {
        String randomFruitName =  utils.randomValueFromEnum(SpecialFruitType.class).toString();
        return fruitFactory.createFruit(randomFruitName, FruitType.SPECIAL);
    }
    public Bomb generateRandomBomb(){
        String randomBombName = utils.randomValueFromEnum(BombType.class).toString();
        return bombFactory.createBomb(randomBombName);
    }

}
