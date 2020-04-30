package fruitNinja.animations;

import fruitNinja.models.Difficulty;
import javafx.geometry.Point2D;

public class Projectile {
    private final double acceleration;

    private final Point2D initialPosition;
    private final Point2D initialVelocity;

    public Projectile(Point2D initialPosition, Difficulty difficulty, double angleRad){
        this.initialPosition = initialPosition;

        ProjectileUtilities projectileUtilities = new ProjectileUtilities();
        double velocity = projectileUtilities.setVelocityBasedOnDifficulty(difficulty);

        initialVelocity = new Point2D(velocity*Math.cos(angleRad) , velocity*Math.sin(angleRad));
        acceleration = projectileUtilities.setAccelerationBasedOnDifficulty(difficulty);
    }

    // Returns the current velocity of the projectile

    public Point2D getCurrentVelocity(double time){
        double Vx = initialVelocity.getX();
        double Vy = initialVelocity.getY() - acceleration *time;

        return new Point2D(Vx,Vy);
    }

    // Returns the current position of the projectile

    public Point2D getCurrentPosition(Point2D velocityAtPoint, double time){
        double x = initialPosition.getX() + velocityAtPoint.getX() * time;
        double y = initialPosition.getY() - (time * initialVelocity.getY() - 0.5 * acceleration *time*time);

        return new Point2D(x,y);
    }
}
