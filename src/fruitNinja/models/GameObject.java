package fruitNinja.models;

import java.awt.image.BufferedImage;

public interface GameObject {
    GameObjectType getObjectType();
    double getXlocation();
    double getYlocation();
    int getMaxHeight();
    int getInitialVelocity();
    int getFallingVelocity();
    Boolean isSliced();
    Boolean hasMovedOffScreen();
    void slice();
    void move(double time);
    BufferedImage[] getBufferedImages();
}
