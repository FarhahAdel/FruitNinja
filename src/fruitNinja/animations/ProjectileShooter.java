package fruitNinja.animations;

import fruitNinja.models.gameObjects.Sprite;
import javafx.geometry.Point2D;

import java.util.*;

public class ProjectileShooter {

    private double currentTime = 0;

    public ProjectileShooter(){

    }

    public void setStartingPoint(Sprite sprite){
        Random random = new Random();

        // MAX RANGE RULE TO BE USED TO LIMIT FALLING OFF SIDES

        sprite.setXLocation(random.nextInt(1280));
        sprite.setYLocation(750);

        setAngle(sprite);

    }

    public void moveProjectile(Sprite sprite, Projectile projectile)
    {
        currentTime += 0.016;
        Point2D currentVelocity = projectile.getCurrentVelocity(currentTime);
        Point2D currentPosition = projectile.getCurrentPosition(currentVelocity,currentTime);
        sprite.setXLocation(currentPosition.getX());
        sprite.setYLocation(currentPosition.getY());

        if(sprite.getYlocation() > 760){
            sprite.fellOff();
        }
    }

    public double getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }

    private void setAngle(Sprite sprite){
        Random random = new Random();

        if(sprite.getXlocation() < (float) 1280/2){

            if(sprite.getXlocation() < (float) 1280/4){
                sprite.setAngleRad(Math.toRadians(random.nextInt(90 - 70) + 70));
            }
            else{
                sprite.setAngleRad(Math.toRadians(random.nextInt(90-85)+85));
            }

        }
        else{
            if(sprite.getXlocation() < (float) 1280/2 + (float) 1280/4){
                sprite.setAngleRad(Math.toRadians(random.nextInt(95 - 90) + 90));
            }
            else{
                sprite.setAngleRad(Math.toRadians(random.nextInt(110 - 90) + 90));
            }
        }


    }
}
