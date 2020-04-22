package fruitNinja.utils.pause;

import fruitNinja.animations.ProjectileShooter;
import fruitNinja.models.gameLogic.GamePlayActions;
import javafx.animation.AnimationTimer;

public class PauseLogic {

    public void pauseAnimationTimer(){
        GamePlayActions.animationTimer.stop();
    }
    public void resumeAnimationTimer(){
        GamePlayActions.animationTimer.start();
    }
}
