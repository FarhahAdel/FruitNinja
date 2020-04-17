package fruitNinja.models.fruits.ordinary;

import fruitNinja.models.fruits.ordinary.OrdinaryFruit;

public class Pineapple extends OrdinaryFruit {
    //alternative till finding a way to connect pictures using modleImages class
    public Pineapple() {
        setImage("views/images/Pineapple.png");
        setImageAfterSlicing("views/images/PineappleSliced.png");
    }
}
