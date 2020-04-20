package fruitNinja.models.wave;

import fruitNinja.models.Difficulty;
import fruitNinja.models.bombs.Bomb;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameObjects.Sprite;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Wave implements WavePlan {
    private ArrayList<Sprite> waveObjects;
    private Difficulty difficulty;

    public ArrayList<Sprite> getWaveObjects() {
        return waveObjects;
    }

    public void setWaveObjects(ArrayList<Sprite> waveObjects) {
        this.waveObjects = waveObjects;
    }

    public Wave()
    {
    }

    public void addFruits(ArrayList<Fruit> fruits)
    {
        waveObjects.addAll(fruits);
    }

    public void addBombs(ArrayList<Bomb> bombs)
    {
        waveObjects.addAll(bombs);
    }

    public void addSpecialFruits(ArrayList<Fruit> specialFruits) {
        waveObjects.addAll(specialFruits);
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
