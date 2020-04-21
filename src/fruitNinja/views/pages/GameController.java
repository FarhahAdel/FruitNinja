package fruitNinja.views.pages;

import fruitNinja.models.gameModes.*;
import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.views.guiUtils.Navigation;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    public Button pauseButton;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label timerLabel;
    @FXML
    private Label livesLabel;



    @FXML
    private Canvas canvas;

    private Navigation navigation;
    private static  int STARTTIME ;
    private Timeline timeline;
    private  IntegerProperty timeSeconds;
    private StrategyFactory strategyFactory = new StrategyFactory();
    private Player player;
    private StrategyType strategyType;
    public void startTimer(){
        switch (strategyType){
        case CLASSIC:
            STARTTIME=60;
            timeSeconds = new SimpleIntegerProperty(STARTTIME);
            break;
        }

    }
    private void updateTime() {
        // updates and checks seconds
        int seconds = timeSeconds.get();
        timeSeconds.set(seconds-1);
        if (timeSeconds.get()<=0) {
            timeline.stop();
//            Stage stage=(Stage) scoreLabel.getScene().getWindow();
//            navigation.showGameDonePage(stage,player);


        }


    }


    public void updateTimer(){
        livesLabel.setVisible(false);
        //button.setDisable(true); // prevent starting multiple times
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), evt -> updateTime()));
        timeline.setCycleCount(Animation.INDEFINITE); // repeat over and over again
        timeSeconds.set(STARTTIME);
        timeline.play();
    }

    public GameController(StrategyType strategyType, Player player)
    {
        this.strategyType = strategyType;
        this.player=player;
    }


    public void pauseButtonClicked(ActionEvent actionEvent) throws IOException {
        PauseDialogController pauseDialog = new PauseDialogController(player);
        pauseDialog.show(scoreLabel.getScene().getWindow());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startGame(strategyType);
        startTimer();
        updateTimer();
        timerLabel.textProperty().bind(timeSeconds.asString());
    }

    private void startGame(StrategyType strategyType)
    {
        GameStrategy strategy = strategyFactory.createStrategy(strategyType);
        ModeContext modeContext = new ModeContext();
        modeContext.setGameStrategy(strategy);

        modeContext.startGame(canvas);
    }
}
