package fruitNinja.models.gameModes.Stratgies;

import fruitNinja.models.gameModes.StrategyType;
import javafx.scene.canvas.Canvas;

public interface GameStrategy {
    void initGame(Canvas canvas);
    StrategyType getStrategyType();
}
