package fruitNinja.models.wave;

import fruitNinja.models.bombs.Bomb;
import fruitNinja.models.fruits.Fruit;

import java.util.ArrayList;

public interface WavePlan {
    void addFruits(ArrayList<Fruit> fruits);
    void addSpecialFruits(ArrayList<Fruit> specialFruits);
    void addBombs(ArrayList<Bomb> bombs);
}
