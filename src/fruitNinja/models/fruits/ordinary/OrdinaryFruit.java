package fruitNinja.models.fruits.ordinary;

import fruitNinja.models.fruits.Fruit;

public class OrdinaryFruit extends Fruit {
    private final int points = 1;
    private final int lifeMinimizing = 1;

    @Override
    public void slice()
    {
        setImage(getImageAfterSlicing());
        setSliced(true);
    }
}
