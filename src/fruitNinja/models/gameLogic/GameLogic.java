package fruitNinja.models.gameLogic;

import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameObjects.Sprite;

import java.util.ArrayList;

public class GameLogic {

    private GamePlayService gamePlayService = new GamePlayService();

    public void startRound(GameState gameState, GamePlayActions gamePlayActions)
    {
        int wave = gameState.getWave();
        Difficulty difficulty = gamePlayService.getDifficultyByWaveNumber(wave);
        ArrayList<Sprite> sprites = gamePlayService.generateWave(difficulty);
        //ArrayList<Sprite> sprites = new ArrayList<>(fruits);
        gamePlayActions.throwFruits(sprites); // DIFFICULTY TO BE PASSED TO THROW FRUITS
        // TODO: LISTEN FOR MOUSE CLICKS (AND IT'S EFFECTS)
        gameState.incWave();
    }
}
