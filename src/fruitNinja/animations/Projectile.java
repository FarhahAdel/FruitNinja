package fruitNinja.animations;

import javafx.geometry.Point2D;

public class Projectile {
    private final double ACCELERATION = 200;

    private final Point2D initialPosition;
    private final Point2D initialVelocity;

    public Projectile(Point2D initialPosition,Point2D initialVelocity, double angleRad){
        this.initialPosition = initialPosition;
        this.initialVelocity = initialVelocity;
    }

    public Point2D changeVelocity(double time){
        double Vx = initialVelocity.getX();
        double Vy = initialVelocity.getY() - ACCELERATION*time;

        return new Point2D(Vx,Vy);
    }


    public Point2D changePosition(Point2D velocityAtPoint, double time){
        double x = initialPosition.getX() + velocityAtPoint.getX()*time;
        double y = initialPosition.getY() - (time*initialVelocity.getY() - 0.5*ACCELERATION*time*time);

        return new Point2D(x,y);
    }

}
