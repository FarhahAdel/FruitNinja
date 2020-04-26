package fruitNinja.views.pages;

import fruitNinja.models.guiUpdate.*;
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
import javafx.stage.Stage;

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
    private Label comboLabel;

    @FXML
    private Canvas canvas;
    private Stage stage ;

    private Navigation navigation;

    private StrategyFactory strategyFactory = new StrategyFactory();
    private StrategyType strategyType;
    private Game gameState = new Game();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

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
        PlayerSingleton.getInstance().setCurrentScore(Integer.parseInt(scoreLabel.getText()));


        PauseDialogController pauseDialog;

        pauseDialog = new PauseDialogController(gameState,strategyType);
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
        controlsUpdater.eventManager.subscribe("sliceFatal", new SliceBombListener(this.stage,this.strategyType));
        controlsUpdater.eventManager.subscribe("sliceDangerous", new DangerousBombListener(scoreLabel));
        controlsUpdater.eventManager.subscribe("sliceCombo", new ComboLabelListener(comboLabel));
        ControlsUpdaterSingleton.setSingleton(controlsUpdater);
    }
}
