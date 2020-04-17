package fruitNinja.animations;

import javafx.geometry.Point2D;

public class Projectile {
    private final double ACCELERATION = 200;

    private final Point2D initialPosition;
    private final Point2D initialVelocity;
    private final double angleRad;

    public Projectile(Point2D initialPosition,Point2D initialVelocity, double angleRad){
        this.initialPosition = initialPosition;
        this.initialVelocity = initialVelocity;
        this.angleRad = angleRad;
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

//    public double calculateTime(){
//        return 2*initialVelocityMag*Math.sin(angleRad)/ACCELERATION;
//    }
//    public double getHorizontalRange(){
//        return Math.pow(initialVelocityMag,2)*Math.sin(2* angleRad)/ACCELERATION;
//    }
//    public String getEquation(){
//        return "y = " + -1*ACCELERATION/(2*Math.pow(initialVelocity.getX(),2)) + "x^2 + " + Math.tan(angleRad) + "x";
//    }
}
