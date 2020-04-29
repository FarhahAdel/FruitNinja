package fruitNinja.views.pages;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

/**
 * Created by dc user on 12/04/2020.
 */
public class MainDashboardView {

    @FXML
    private ProgressBar levelBar;

    @FXML
    private Label levelNum;

    @FXML
    private Label level;

    @FXML
    private Button newGameButton;

    @FXML
    private Button leaderBoardButton;

    @FXML
    private Button backButton;

    @FXML
    private Label playerName;

    public void addBackButtonListener(EventHandler<ActionEvent> event)
    {
        backButton.setOnAction(event);
    }

    public void addNewGameButtonListener(EventHandler<ActionEvent> event)
    {
        newGameButton.setOnAction(event);
    }

    public void addLeaderBoardButtonListener(EventHandler<ActionEvent> event)
    {
        leaderBoardButton.setOnAction(event);
    }


    public ProgressBar getLevelBar() {
        return levelBar;
    }

    public void setLevelBar(ProgressBar levelBar) {
        this.levelBar = levelBar;
    }

    public Label getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Label levelNum) {
        this.levelNum = levelNum;
    }

    public Label getLevel() {
        return level;
    }

    public void setLevel(Label level) {
        this.level = level;
    }

    public Button getNewGameButton() {
        return newGameButton;
    }

    public void setNewGameButton(Button newGameButton) {
        this.newGameButton = newGameButton;
    }

    public Button getLeaderBoardButton() {
        return leaderBoardButton;
    }

    public void setLeaderBoardButton(Button leaderBoardButton) {
        this.leaderBoardButton = leaderBoardButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Label getPlayerName() {
        return playerName;
    }

    public void setPlayerName(Label playerName) {
        this.playerName = playerName;
    }
}
