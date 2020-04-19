package fruitNinja.models.gameLogic;

import fruitNinja.animations.Projectile;
import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameObjects.Sprite;
import fruitNinja.utils.events.MouseEvents;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.HashMap;

public class GamePlayActions {

    private Canvas canvas;
    private ProjectileShooter projectileShooter;

    public GamePlayActions(Canvas canvas)
    {
        this.canvas = canvas;
        this.projectileShooter = new ProjectileShooter();
    }

    public void throwFruits(ArrayList<Sprite> sprites)
    {
        HashMap<Sprite, Projectile> spriteProjectileHashMap = associateProjectiles(sprites);

        MouseEvents mouseEvents = new MouseEvents(spriteProjectileHashMap);
        canvas.setOnMouseDragged(mouseEvents);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean done = updateSpritesMovement(spriteProjectileHashMap);
                if (!done) this.stop();
            }
        };

        animationTimer.start();
    }

    private HashMap<Sprite, Projectile> associateProjectiles(ArrayList<Sprite> sprites)
    {
        HashMap<Sprite, Projectile> projectileHashMap = new HashMap<>();

        for (Sprite sprite:sprites)
        {
            projectileShooter.setStartingPoint(sprite);

            Projectile projectile = new Projectile(new Point2D(sprite.getXlocation(),sprite.getYlocation()),
                    new Point2D(575*Math.cos(sprite.getAngleRad()),575*Math.sin(sprite.getAngleRad())),sprite.getAngleRad());

            projectileHashMap.put(sprite, projectile);
        }

        return projectileHashMap;
    }

    private boolean updateSpritesMovement(HashMap<Sprite, Projectile> spriteProjectileHashMap)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0 , 1280, 720);
        spriteProjectileHashMap.forEach((k,v) -> {
            projectileShooter.moveProjectile(k, v);
        });

        spriteProjectileHashMap.entrySet().removeIf(entry -> entry.getKey().hasMovedOffScreen());

        spriteProjectileHashMap.forEach((k,v) -> {
            if (!k.hasMovedOffScreen()) k.render(gc);
        });

        if (spriteProjectileHashMap.isEmpty()) {
            projectileShooter.setCurrentTime(0);
            return false;
        }

        return true;
    }
}
