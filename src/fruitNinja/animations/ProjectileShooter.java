package fruitNinja.animations;

import fruitNinja.models.fruits.Fruit;
import fruitNinja.utils.events.MouseEvents;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.*;

public class ProjectileShooter {

    private double currentTime = 0;
    private final Canvas canvas;

    public ProjectileShooter(Canvas canvas){
        this.canvas = canvas;
    }

    private void setStartingPoint(Fruit fruit){
        Random random = new Random();

        // MAX RANGE RULE TO BE USED TO LIMIT FALLING OFF SIDES

        fruit.setXLocation(random.nextInt(1280));
        fruit.setYLocation(750);

        if(fruit.getXlocation() < (float) 1280/2){
            fruit.setAngleRad(Math.toRadians(random.nextInt(90 - 45) + 45));
        }
        else if (fruit.getXlocation() > (float) 1280/2){
            fruit.setAngleRad(Math.toRadians(random.nextInt(135 - 90) + 90));
        }
        else{
            fruit.setAngleRad(Math.toRadians(180));
        }
    }

    public void throwFruits(ArrayList<Fruit> fruits)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        HashMap<Fruit, Projectile> fruitProjectileHashMap = new HashMap<>();
        for (Fruit fruit:fruits)
        {
            setStartingPoint(fruit);

            Projectile projectile = new Projectile(new Point2D(fruit.getXlocation(),fruit.getYlocation()),
                    new Point2D(575*Math.cos(fruit.getAngleRad()),575*Math.sin(fruit.getAngleRad())),fruit.getAngleRad());

            fruitProjectileHashMap.put(fruit, projectile);
        }

        MouseEvents mouseEvents = new MouseEvents(fruitProjectileHashMap);
        canvas.setOnMouseDragged(mouseEvents);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gc.clearRect(0, 0 , 1280, 720);
                fruitProjectileHashMap.forEach((k,v) -> {
                    moveProjectile(k, v);
                });

                fruitProjectileHashMap.entrySet().removeIf(entry -> entry.getKey().hasMovedOffScreen());

                fruitProjectileHashMap.forEach((k,v) -> {
                    if (!k.hasMovedOffScreen()) k.render(gc);
                });

                if (fruitProjectileHashMap.isEmpty()) {
                    currentTime = 0;
                    this.stop();
                }

            }
        };

        animationTimer.start();


    }


    private void moveProjectile(Fruit fruit, Projectile projectile)
    {
        currentTime += 0.016;
        Point2D currentVelocity = projectile.getCurrentVelocity(currentTime);
        Point2D currentPosition = projectile.getCurrentPosition(currentVelocity,currentTime);
        fruit.setXLocation(currentPosition.getX());
        fruit.setYLocation(currentPosition.getY());

        if(fruit.getYlocation() > 760){
            fruit.setHasFallenOff(true);
        }
    }
}
