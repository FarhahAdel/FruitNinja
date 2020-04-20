package fruitNinja.animations;

import fruitNinja.models.Difficulty;
import javafx.geometry.Point2D;

public class ProjectileUtilities {
    public int setVelocityBasedOnDifficulty(Difficulty difficulty){
        switch (difficulty){
            case EASY -> { return 500; }
            case MEDIUM -> { return 590; }
            case HARD -> { return 610; }
            default -> { return 0; }
        }
    }
    public int setAccelerationBasedOnDifficulty(Difficulty difficulty){
        switch (difficulty){
            case EASY -> { return 200; }
            case MEDIUM -> { return 250;}
            case HARD -> { return 250; }
            default -> {return 0;}
        }
    }
}
