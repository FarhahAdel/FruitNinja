package fruitNinja.models.gameModes.timerTasks;

import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameModes.GamePlayService;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.TimerTask;

public class Round extends TimerTask {

    private GamePlayService gamePlayService;
    private ProjectileShooter projectileShooter;

    public Round(Canvas canvas)
    {
        gamePlayService = new GamePlayService();
        projectileShooter = new ProjectileShooter(canvas);
    }

    @Override
    public void run() {
        int wave = gamePlayService.getWave();
        Difficulty difficulty = gamePlayService.getDifficultyByWaveNumber(wave);
        ArrayList<Fruit> fruits = gamePlayService.generateFruitWave(difficulty);
        projectileShooter.throwFruits(fruits); // DIFFICULTY TO BE PASSED TO THROW FRUITS
        // TODO: LISTEN FOR MOUSE CLICKS (AND IT'S EFFECTS)
        gamePlayService.incWave();
    }

}
