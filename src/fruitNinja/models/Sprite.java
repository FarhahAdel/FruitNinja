package fruitNinja.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public abstract class Sprite implements GameObject {
    private Image image;
    private double XLocation;
    private double YLocation;
    private double angleRad = Math.toRadians(70);
    private int initialVelocity;
    private boolean isSliced;
    private boolean hasFallenOff;
    private double width;
    private double height;

    public Sprite()
    {

    }

    public Sprite(int XLocation, int YLocation, Image image, int velocity)
    {
        this.XLocation = XLocation;
        this.YLocation = YLocation;
        this.image = image;
        this.initialVelocity = velocity;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(String imageURL) {

        this.image = new Image(imageURL);
        setWidth(image.getWidth());
        setHeight(image.getHeight());
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public GameObjectType getObjectType() {
        return null;
    }

    @Override
    public double getXlocation() {
        return XLocation;
    }
    public void setXLocation (double XLocation) {
        this.XLocation = XLocation;
    }

    @Override
    public double getYlocation() {
        return YLocation;
    }
    public void setYLocation (double YLocation) {
        this.YLocation = YLocation;
    }

    @Override
    public int getMaxHeight() {
        return 0;
    }

    @Override
    public int getInitialVelocity() {
        return initialVelocity;
    }

    @Override
    public int getFallingVelocity() {
        return 0;
    }

    @Override
    public Boolean isSliced() {
        return isSliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return hasFallenOff;
    }

    @Override
    public void slice() {

        //TODO: LOGIC TO BE IMPLEMENTED
        this.isSliced = true;
    }

    @Override
    public void move(double time) {

    }

    @Override
    public BufferedImage[] getBufferedImages() {
        return new BufferedImage[0];
    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage(image,getXlocation(),getYlocation());
    }

    public double getAngleRad() {
        return angleRad;
    }

    public void setAngleRad(double angleRad) {
        this.angleRad = angleRad;
    }

    public void setHasFallenOff(boolean hasFallenOff) {
        this.hasFallenOff = hasFallenOff;
    }
}
