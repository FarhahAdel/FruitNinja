package fruitNinja.models.gameObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Sprite implements GameObject {
    private Image image;
    private double XLocation;
    private double YLocation;
    private double angleRad = Math.toRadians(70); // DEFAULT VALUE
    private boolean isSliced;
    private boolean hasFallenOff;
    private double width;
    private double height;

    public Sprite()
    {

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
    public Boolean isSliced() {
        return isSliced;
    }
    public void setSliced(boolean isSliced) {
        this.isSliced = isSliced;
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
    public Boolean hasMovedOffScreen() {
        return hasFallenOff;
    }
    public void setHasFallenOff(boolean hasFallenOff) {
        this.hasFallenOff = hasFallenOff;
    }

    public double getAngleRad() {
        return angleRad;
    }

    public void setAngleRad(double angleRad) {
        this.angleRad = angleRad;
    }

    @Override
    public void slice() {
        this.isSliced = true;
    }

    @Override
    public boolean intersect(double x, double y) {
        return (x >= getXlocation() && x <= getXlocation() + width)
                && (y >= getYlocation() && y <= getYlocation() + height);
    }

    @Override
    public void render(GraphicsContext gc)
    {
        gc.drawImage(image,getXlocation(),getYlocation());
    }

}
