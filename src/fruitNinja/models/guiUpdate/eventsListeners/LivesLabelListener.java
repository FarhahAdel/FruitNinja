package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.guiUpdate.EventListener;
import fruitNinja.views.guiUtils.Navigation;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import static fruitNinja.models.gameLogic.GamePlayActions.animationTimer;
import static fruitNinja.models.gameLogic.GamePlayActions.isPaused;

public class LivesLabelListener implements EventListener {

    private Label label;
    private final Stage stage;

    public LivesLabelListener(Stage stage,Label label)
    {
        this.label = label;
        this.stage=stage;
    }

    Navigation navigation = new Navigation();

    @Override
    public void update(String eventType, String data) {

       if(label.getText().contains("X")||label.getText().isEmpty()){
            if (!label.getText().equals("XX")){
            label.setText(label.getText() + "X");
//            System.out.println(label.getText());
            }
            else {
                label.setText(label.getText() + "X");
                isPaused=true;
                navigation.showGameOverPage(stage, StrategyType.CLASSIC);

            }
        }
    }
}
