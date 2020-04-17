package fruitNinja.Mouse;

import javafx.scene.image.Image;
import javafx.scene.layout.Region;

import java.awt.image.BufferedImage;

public interface GameObject {
    double getXlocation();
    double getYlocation();
    double getMaxHeight();
    int getInitialVelocity();
    int getFallingVelocity();
    Boolean isSliced();
    Boolean hasMovedOffScreen();
    void slice(Image image);
    void move(double time);
}
