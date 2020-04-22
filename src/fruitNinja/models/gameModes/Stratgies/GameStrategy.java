package fruitNinja.models.gameModes.Stratgies;

import javafx.scene.canvas.Canvas;

public interface GameStrategy {
    void initGame(Canvas canvas);
    void startTimer();
}
