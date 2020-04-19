package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.fruits.ordinary.Apple;
import fruitNinja.utils.timerTasks.Round;
import javafx.scene.canvas.Canvas;

import java.util.Timer;
import java.util.TimerTask;

public class ClassicStrategy implements GameStrategy {

    private int life = 3;
    private Timer timer;
    private TimerTask timerTask;

    public ClassicStrategy()
    {
        timer = new Timer();
    }

    @Override
    public void initGame(Canvas canvas) {

        // THIS WHOLE METHOD TO BE CHANGED

        timerTask = new Round(canvas);
        int x = 4500; // X TO BE CHANGED UPON THE LAST FRUIT IS DOWN
        timer.schedule(timerTask, 500, x);
    }
}