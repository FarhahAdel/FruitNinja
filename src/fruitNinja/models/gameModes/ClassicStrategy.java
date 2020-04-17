package fruitNinja.models.gameModes;

import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.fruits.FruitFactory;
import fruitNinja.models.fruits.FruitType;
import fruitNinja.models.fruits.ordinary.Banana;
import fruitNinja.models.gameModes.timerTasks.Round;
import javafx.scene.canvas.Canvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ClassicStrategy implements GameStrategy {

    private int life = 3;
    private Timer timer;
    private TimerTask timerTask;
    private boolean deadlyBombDenoted = false;
    private FruitFactory fruitFactory = new FruitFactory();

    private GamePlayService gamePlayService;

    public ClassicStrategy()
    {
        gamePlayService = new GamePlayService();
        timer = new Timer();
    }

    @Override
    public void initGame(Canvas canvas) {
        timerTask = new Round(canvas);
        int x = 4500; // X TO BE CHANGED UPON THE LAST FRUIT IS DOWN
        timer.schedule(timerTask, 500, x);
    }

    @Override
    public void bombBehaviour() {
        life--;
    }

    @Override
    public boolean gameEndCondition() {
        return life != 0 && !deadlyBombDenoted;
    }
}