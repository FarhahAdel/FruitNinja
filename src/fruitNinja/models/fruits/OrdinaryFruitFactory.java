package fruitNinja.models.fruits;

public class OrdinaryFruitFactory {

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

            case "Pineapple":
                fruit = new Pineapple();
                break;
            default:
                throw new Error("Unknown fruit type");
        }

        fruit.setFruitType(FruitType.ORDINARY);
        return fruit;
    }
}
