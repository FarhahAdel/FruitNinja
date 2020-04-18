package fruitNinja.models.gameModes;

import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import javafx.scene.canvas.Canvas;

public class ModeContext {
    GameStrategy gameStrategy;

    public void setGameStrategy(GameStrategy strategy)
    {
        gameStrategy = strategy;
    }

    public void startGame(Canvas canvas)
    {
        gameStrategy.initGame(canvas);
    }
}
