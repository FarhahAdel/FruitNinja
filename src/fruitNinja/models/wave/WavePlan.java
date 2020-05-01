package fruitNinja.models.wave;

import fruitNinja.models.gameObjects.bombs.Bomb;
import fruitNinja.models.gameObjects.fruits.Fruit;

import java.util.ArrayList;

public interface WavePlan {
    void addFruits(ArrayList<Fruit> fruits);
    void addBombs(ArrayList<Bomb> bombs);
}
