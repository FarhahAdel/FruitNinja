package fruitNinja.models.gameModes;

import fruitNinja.models.Difficulty;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameModes.timerTasks.Round;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ClassicStrategy implements GameStrategy {

    private int life = 3;
    private Timer timer;
    private TimerTask timerTask;
    private boolean deadlyBombDenoted = false;

    private GamePlayService gamePlayService;

    public ClassicStrategy()
    {
        gamePlayService = new GamePlayService();
        timer = new Timer();
        timerTask = new Round();
    }

    @Override
    public void initGame() {
        int x = 3000; // X TO BE CHANGED UPON THE LAST FRUIT THROWN
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