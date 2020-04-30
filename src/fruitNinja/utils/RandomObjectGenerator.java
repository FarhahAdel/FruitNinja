package fruitNinja.utils;

import fruitNinja.models.gameObjects.bombs.Bomb;
import fruitNinja.models.gameObjects.bombs.BombFactory;
import fruitNinja.models.gameObjects.bombs.BombType;
import fruitNinja.models.gameObjects.fruits.Fruit;
import fruitNinja.models.gameObjects.fruits.FruitFactory;
import fruitNinja.models.gameObjects.fruits.FruitType;
import fruitNinja.models.gameObjects.fruits.ordinary.OrdinaryFruitType;
import fruitNinja.models.gameObjects.fruits.special.SpecialFruitType;

public class RandomObjectGenerator {

    private FruitFactory fruitFactory = new FruitFactory();
    private BombFactory bombFactory = new BombFactory();
    private Utils utils = new Utils();


    public Fruit generateRandomFruit()
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
