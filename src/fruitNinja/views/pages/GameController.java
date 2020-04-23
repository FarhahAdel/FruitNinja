package fruitNinja.views.pages;

import fruitNinja.guiUpdate.ControlsUpdater;
import fruitNinja.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.guiUpdate.UpdateScoreListener;
import fruitNinja.guiUpdate.UpdateTimerListener;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameStates.Game;
import fruitNinja.models.gameModes.*;
import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    private StrategyFactory strategyFactory = new StrategyFactory();
    private StrategyType strategyType;
    private Game gameState = new Game();


    public GameController(StrategyType strategyType)
    {
        this.strategyType = strategyType;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSubscribers();
        startGame(strategyType);
    }

    @FXML
    private void pauseButtonClicked(ActionEvent actionEvent) throws IOException {
        gameState.clickPause();
        GamePlayActions.isPaused = true;


        PauseDialogController pauseDialog;

        pauseDialog = new PauseDialogController(gameState);
        pauseDialog.show(scoreLabel.getScene().getWindow());
    }

    private void startGame(StrategyType strategyType)
    {
        GameStrategy strategy = strategyFactory.createStrategy(strategyType);
        ModeContext modeContext = new ModeContext(strategy);
        modeContext.startGame(canvas);
    }

    private void setSubscribers()
    {
        ControlsUpdater controlsUpdater = new ControlsUpdater();
        controlsUpdater.eventManager.subscribe("sliceOrdinary", new UpdateScoreListener(scoreLabel));
        controlsUpdater.eventManager.subscribe("updateTimer", new UpdateTimerListener(timerLabel));
        ControlsUpdaterSingleton.setSingleton(controlsUpdater);
    }
}
