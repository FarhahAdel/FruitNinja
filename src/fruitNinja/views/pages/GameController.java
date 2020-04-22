package fruitNinja.views.pages;

import fruitNinja.guiUpdate.ControlsUpdater;
import fruitNinja.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.guiUpdate.UpdateScoreListener;
import fruitNinja.models.gameModes.*;
import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
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


    public GameController(StrategyType strategyType)
    {
        this.strategyType = strategyType;
        this.player= PlayerSingleton.getInstance();
    }

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
            Stage stage=(Stage) scoreLabel.getScene().getWindow();
            navigation.showGameDonePage(stage);
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

    public void pauseButtonClicked(ActionEvent actionEvent) throws IOException {
        PauseDialogController pauseDialog = new PauseDialogController();
        pauseDialog.show(scoreLabel.getScene().getWindow());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startGame(strategyType);
        startTimer();
        updateTimer();
        timerLabel.textProperty().bind(timeSeconds.asString());

        setSubscribers();
    }

    private void startGame(StrategyType strategyType)
    {
        GameStrategy strategy = strategyFactory.createStrategy(strategyType);
        ModeContext modeContext = new ModeContext();
        modeContext.setGameStrategy(strategy);

        modeContext.startGame(canvas);
    }

    private void setSubscribers()
    {
        ControlsUpdater controlsUpdater = new ControlsUpdater();
        controlsUpdater.eventManager.subscribe("sliceOrdinary", new UpdateScoreListener(scoreLabel));
        ControlsUpdaterSingleton.setSingleton(controlsUpdater);
    }
}
