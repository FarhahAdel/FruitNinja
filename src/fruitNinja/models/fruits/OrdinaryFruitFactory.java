package fruitNinja.models.fruits;

import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.fruits.FruitType;
import fruitNinja.models.fruits.ordinary.Apple;
import fruitNinja.models.fruits.ordinary.Banana;
import fruitNinja.models.fruits.ordinary.Pineapple;

class OrdinaryFruitFactory {

    public OrdinaryFruitFactory()
    {
    }

    public Fruit createFruit(String ordinaryFruitName)
    {
        Fruit fruit;
        switch (ordinaryFruitName.toLowerCase())
        {
            case "banana":
                fruit = new Banana();
                break;

            case "apple":
                fruit = new Apple();
                break;

            case "pineapple":
                fruit = new Pineapple();
                break;
            default:
                throw new Error("Unknown fruit type");
        }

        fruit.setFruitType(FruitType.ORDINARY);
        return fruit;
    }
}
