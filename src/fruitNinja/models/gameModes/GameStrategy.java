package fruitNinja.models.gameModes;

import javafx.scene.canvas.Canvas;

public interface GameStrategy {
    void initGame(Canvas canvas);


    // THESE TWO FUNCTIONS TO BE MOVED TO ANOTHER INTERFACE
    void bombBehaviour();
    boolean gameEndCondition();
}
