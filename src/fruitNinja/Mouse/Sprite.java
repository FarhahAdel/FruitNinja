package fruitNinja.Mouse;


import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.util.Duration;

import java.awt.image.BufferedImage;

/**
 * Created by dc user on 16/04/2020.
 */
public class Sprite implements GameObject {
    double XLocation;
    double YLocation;
    int MaxHight=0;
    int initialVel;
    boolean Sliced=false;
    boolean isOut=false;
    double sign =-1.0;
    Image image ;
    public Sprite(double XLocation,double YLocation,Image image,int vel) {
        this.XLocation=XLocation;
        this.YLocation=YLocation;
        this.image=image;
        this.initialVel=vel;
    }

    @Override
    public double getXlocation() {
        return XLocation;
    }

    @Override
    public double getYlocation() {
        return YLocation;
    }

    @Override
    public double getMaxHeight() {
        return MaxHight;
    }

    @Override
    public int getInitialVelocity() {
        return initialVel;
    }

    @Override
    public int getFallingVelocity() {
        return 0;
    }

    @Override
    public Boolean isSliced() {
        return Sliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return isOut;
    }
    @Override
    public void slice(Image image) {
        //no need to take parameter as it's already in fruit class
        Sliced=true;
     this.image=image;
    }

    @Override
    public void move(double time) {
            if (YLocation<=MaxHight){
                sign=+1.0;
            }
         YLocation +=(sign*initialVel);

        if (YLocation>1000)
            isOut=true;
    }

//reset object to readd in the list we already have generate fruit
    public void resetObject(double initialXPosition,double initialYPosition){
        this.Sliced=false;
        this.XLocation= initialXPosition;
        this.initialVel=6;
        this.sign=-1.0;
        this.isOut=false;
    }

//drawing in canvas
    public void render(GraphicsContext gc)
    {
        gc.drawImage(image,getXlocation(),getYlocation());
    }
}
