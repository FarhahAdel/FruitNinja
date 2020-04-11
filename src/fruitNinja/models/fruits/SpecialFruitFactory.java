package fruitNinja.models.fruits;

public class SpecialFruitFactory {
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
            default:
                throw new Error("Unknown fruit type");
        }

        fruit.setFruitType(FruitType.SPECIAL);
        return fruit;
    }
}
