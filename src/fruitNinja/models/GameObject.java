package fruitNinja.models;

import java.awt.image.BufferedImage;

public interface GameObject {
    GameObjectType getObjectType();
    int getXlocation();
    int getYlocation();
    int getMaxHeight();
    int getInitialVelocity();
    int getFallingVelocity();
    Boolean isSliced();
    Boolean hasMovedOffScreen();
    void slice();
    void move(double time);
    BufferedImage[] getBufferedImages();
}
