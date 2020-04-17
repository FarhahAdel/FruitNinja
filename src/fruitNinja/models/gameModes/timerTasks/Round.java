package fruitNinja.models.gameModes.timerTasks;

import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameModes.GamePlayService;

import java.util.ArrayList;
import java.util.TimerTask;

public class Round extends TimerTask {

    private GamePlayService gamePlayService;

    public Round()
    {
        gamePlayService = new GamePlayService();
    }

    @Override
    public void run() {
        int wave = gamePlayService.getWave();
        Difficulty difficulty = gamePlayService.getDifficultyByWaveNumber(wave);
        ArrayList<Fruit> fruits = gamePlayService.generateFruitWave(difficulty);
        gamePlayService.throwFruits(fruits, difficulty); // NOT IMPLEMENTED YET
        // TODO: LISTEN FOR MOUSE CLICKS (AND IT'S EFFECTS)
        // TODO: LISTEN FOR THE LAST FRUIT TO DROP


        gamePlayService.incWave();
    }
}
