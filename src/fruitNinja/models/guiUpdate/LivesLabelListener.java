package fruitNinja.models.guiUpdate;

import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
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
   boolean flag=true;
    Navigation navigation=new Navigation();
    @Override
    public void update(String eventType, String data) {
       if(label.getText().contains("X")||label.getText().isEmpty()){
            if (!label.getText().equals("XXX")){
            label.setText(label.getText() + "X");
            System.out.println(label.getText());
            }
            else {
               isPaused=true;
//               GamePlayActions.animationTimer.stop();
//                this.stage.close();
                label.setText("Game over");
                navigation.showGameDonePage(stage, StrategyType.CLASSIC);
                ay7aga();

            }
        }
    }
    private void ay7aga(){
        Navigation navigation=new Navigation();
        if(flag){

            navigation.showGameOverPage(stage);
            PauseTransition delaySecond = new PauseTransition(Duration.seconds(3));
            delaySecond.setOnFinished(event -> navigation.showGameDonePage(stage,StrategyType.CLASSIC));
           // delaySecond.setCycleCount(1);
            delaySecond.play();

        }
    }
}
