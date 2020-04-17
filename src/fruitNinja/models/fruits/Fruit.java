package fruitNinja.models.fruits;

import fruitNinja.models.Sprite;

public abstract class Fruit extends Sprite {
    private String imageAfterSlicing;
    private FruitType fruitType;

    public String getImageAfterSlicing() {
        return imageAfterSlicing;
    }

    public void setImageAfterSlicing(String imageAfterSlicing) {
        this.imageAfterSlicing = imageAfterSlicing;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }
}
