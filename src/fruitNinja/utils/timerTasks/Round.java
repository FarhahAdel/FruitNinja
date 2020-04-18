package fruitNinja.utils.timerTasks;

import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameLogic.GamePlayService;
import fruitNinja.models.gameLogic.GameState;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.TimerTask;

public class Round extends TimerTask {

    private GamePlayService gamePlayService;
    private ProjectileShooter projectileShooter;
    private GameState gameState;

    public Round(Canvas canvas)
    {
        // THESE SHOULD BE INJECTED VIA DEPENDENCIES

        gamePlayService = new GamePlayService();
        gameState = new GameState();
        projectileShooter = new ProjectileShooter(canvas);
    }

    @Override
    public void run() {
        int wave = gameState.getWave();
        Difficulty difficulty = gamePlayService.getDifficultyByWaveNumber(wave);
        ArrayList<Fruit> fruits = gamePlayService.generateFruitWave(difficulty);
        projectileShooter.throwFruits(fruits); // DIFFICULTY TO BE PASSED TO THROW FRUITS
        // TODO: LISTEN FOR MOUSE CLICKS (AND IT'S EFFECTS)
        gameState.incWave();
    }

}
