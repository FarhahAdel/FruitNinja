package fruitNinja.views.pages;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.data.repositories.ScoreRepository;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.models.users.Score;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameDoneView {
    @FXML
    private Label scoreValue;
    @FXML
    private Label highScoreValue;
    @FXML
    private Button playAgainBtn;
    @FXML
    private Button mainMenuBtn;

    public void addPlayAgainButtonListener(EventHandler<ActionEvent> event)
    {
        playAgainBtn.setOnAction(event);
    }

    public void addMainMenuButtonListener(EventHandler<ActionEvent> event)
    {
        mainMenuBtn.setOnAction(event);
    }

    public Label getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(Label scoreValue) {
        this.scoreValue = scoreValue;
    }

    public Label getHighScoreValue() {
        return highScoreValue;
    }

    public void setHighScoreValue(Label highScoreValue) {
        this.highScoreValue = highScoreValue;
    }

    public Button getPlayAgainBtn() {
        return playAgainBtn;
    }

    public void setPlayAgainBtn(Button playAgainBtn) {
        this.playAgainBtn = playAgainBtn;
    }

    public Button getMainMenuBtn() {
        return mainMenuBtn;
    }

    public void setMainMenuBtn(Button mainMenuBtn) {
        this.mainMenuBtn = mainMenuBtn;
    }
}
