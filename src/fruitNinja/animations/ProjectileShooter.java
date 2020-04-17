package fruitNinja.animations;

import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Path;

import java.util.Random;

public class ProjectileShooter {
    private double angleRad = Math.toRadians(70);
    private Projectile projectile;
    private double currentTime = 0;

    private void setStartingPoint(ImageView imageView){
        Random random = new Random();

        imageView.setTranslateX(random.nextInt(1280));
        imageView.setTranslateY(750);

        if(imageView.getTranslateX() < (float) 1280/2){
            angleRad = Math.toRadians(random.nextInt(90 - 45) + 45);
        }
        else if (imageView.getTranslateX() > (float) 1280/2){
            angleRad = Math.toRadians(random.nextInt(135 - 90) + 90);
        }
        else{
            angleRad = Math.toRadians(180);
        }
    }

    public void throwFruit(ImageView imageView){
        setStartingPoint(imageView);

        projectile = new Projectile(new Point2D(imageView.getTranslateX(),imageView.getTranslateY()), new Point2D(575*Math.cos(angleRad),575*Math.sin(angleRad)),angleRad);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean done = doHandle(imageView);
                if(done) this.stop();
            }
        };
        animationTimer.start();
    }


    private boolean doHandle(ImageView imageView){
        currentTime += 0.016;
        Point2D currentVelocity = projectile.changeVelocity(currentTime);
        Point2D currentPosition = projectile.changePosition(currentVelocity,currentTime);
        imageView.setTranslateX(currentPosition.getX());
        imageView.setTranslateY(currentPosition.getY());

        if(imageView.getTranslateY()>760){
            currentTime=0;
            return true;
        }
        return false;
    }
}
