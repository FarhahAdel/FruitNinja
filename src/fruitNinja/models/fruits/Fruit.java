package fruitNinja.models.fruits;

import fruitNinja.models.GameItem;

public abstract class Fruit extends GameItem {
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
