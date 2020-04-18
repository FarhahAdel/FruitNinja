package fruitNinja.models.gameObjects;

import javafx.scene.canvas.GraphicsContext;

public interface GameObject {
    double getXlocation();
    double getYlocation();
    Boolean isSliced();
    Boolean hasMovedOffScreen();
    void slice();
    boolean intersect(double x, double y);
    void render(GraphicsContext gc);
}
