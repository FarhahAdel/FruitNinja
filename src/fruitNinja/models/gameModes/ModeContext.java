package fruitNinja.models.gameModes;

import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import javafx.scene.canvas.Canvas;

public class ModeContext {
    private GameStrategy gameStrategy;

    public ModeContext(GameStrategy gameStrategy)
    {
        this.gameStrategy = gameStrategy;
    }

    public void startGame(Canvas canvas)
    {
        gameStrategy.initGame(canvas);
        gameStrategy.startTimer();
    }
}
