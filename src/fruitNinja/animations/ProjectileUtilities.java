package fruitNinja.animations;

import fruitNinja.models.Difficulty;
import javafx.geometry.Point2D;

public class ProjectileUtilities {
    public int setVelocityBasedOnDifficulty(Difficulty difficulty){

        switch (difficulty){
            case EASY : { return 500; }
            case MEDIUM: { return 550; }
            case HARD: { return 580; }
            default: { return 0; }
        }
    }

    public double setTimeBasedOnDifficulty(Difficulty difficulty) {
        switch (difficulty) {
            case EASY: return 0.032;
            case MEDIUM: return 0.042;
            case HARD: return 0.048;
            default: return 0;
        }
    }
}
