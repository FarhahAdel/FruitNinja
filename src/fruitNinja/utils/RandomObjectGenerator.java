package fruitNinja.utils;

import fruitNinja.models.bombs.Bomb;
import fruitNinja.models.bombs.BombFactory;
import fruitNinja.models.bombs.BombType;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.fruits.FruitFactory;
import fruitNinja.models.fruits.FruitType;
import fruitNinja.models.fruits.ordinary.OrdinaryFruitType;
import fruitNinja.models.fruits.special.SpecialFruitType;

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
