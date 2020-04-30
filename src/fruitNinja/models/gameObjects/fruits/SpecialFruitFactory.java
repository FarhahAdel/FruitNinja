package fruitNinja.models.gameObjects.fruits;

import fruitNinja.models.gameObjects.fruits.special.DoubleScore;
import fruitNinja.models.gameObjects.fruits.special.Freeze;
import fruitNinja.models.gameObjects.fruits.special.Frenzy;

class SpecialFruitFactory {
    public Fruit createFruit(String specialFruitName)
    {
        Fruit fruit;
        switch (specialFruitName.toLowerCase())
        {
            case "frenzy":
                fruit = new Frenzy();
                break;

            case "doublescore":
                fruit = new DoubleScore();
                break;
            case"freeze":
                fruit=new Freeze();
                break;
            default:
                throw new Error("Unknown fruit type");
        }

        fruit.setFruitType(FruitType.SPECIAL);
        return fruit;
    }
}
