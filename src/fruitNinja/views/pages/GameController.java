package fruitNinja.views.pages;

import fruitNinja.models.gameModes.*;
import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import fruitNinja.models.gameModes.StrategyType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    /*
    @FXML
    private Button pauseButton;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label timerLabel;
    @FXML
    private Label livesLabel;

     */
    @FXML
    private Canvas canvas;


    private StrategyFactory strategyFactory = new StrategyFactory();
    private StrategyType strategyType;

    public GameController(StrategyType strategyType)
    {
        this.strategyType = strategyType;
    }


    public void pauseButtonClicked(ActionEvent actionEvent) throws IOException {
        PauseDialogController pauseDialog = new PauseDialogController();
        //pauseDialog.show(scoreLabel.getScene().getWindow());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startGame(strategyType);
    }

    private void startGame(StrategyType strategyType)
    {
        GameStrategy strategy = strategyFactory.createStrategy(strategyType);
        ModeContext modeContext = new ModeContext();
        modeContext.setGameStrategy(strategy);

        modeContext.startGame(canvas);
    }
}
