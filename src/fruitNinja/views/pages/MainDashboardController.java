package fruitNinja.views.pages;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dc user on 12/04/2020.
 */
public class MainDashboardController implements Initializable {

    @FXML
    private Button arcadeButton;

    @FXML
    private Button zenButton;

    @FXML
    private Button classicButton;

    @FXML
    private Button exitButton;

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

    private Player player;
    private Navigation navigation;
    private Utils utils;

    public MainDashboardController(Player player)
    {
        this.player = player;
        this.navigation = new Navigation();
        this.utils = new Utils();
    }

    @FXML
    void back(ActionEvent event) {

    }

    @FXML
    void arcadeMode(ActionEvent event) {
        navigateToGame(StrategyType.ARCADE);

    }

    @FXML
    void classicMode(ActionEvent event) {
        navigateToGame(StrategyType.CLASSIC);
    }


    @FXML
    void zenMode(ActionEvent event) {
        navigateToGame(StrategyType.ZEN);
    }

    @FXML
    void leaderBoard(ActionEvent event) {

    }

    @FXML
    void newGame(ActionEvent event) {
        zenButton.setVisible(true);
        classicButton.setVisible(true);
        arcadeButton.setVisible(true);
        exitButton.setVisible(true);
        leaderBoardButton.setVisible(false);
        newGameButton.setVisible(false);
        backButton.setVisible(false);
    }

    @FXML
    void exit(ActionEvent event) {
        zenButton.setVisible(false);
        classicButton.setVisible(false);
        arcadeButton.setVisible(false);
        exitButton.setVisible(false);
        leaderBoardButton.setVisible(true);
        newGameButton.setVisible(true);
        backButton.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLevel();
    }

    private void setLevel()
    {
        int levelMaxPoints = utils.calculateExperiencePoints(player.getLevel());
        double percentage = player.getExperience() * 1.0 / levelMaxPoints;
        levelBar.setProgress(percentage);
        level.setText(String.valueOf(player.getLevel()));
        playerName.setText("Player: "+player.getFullName());
    }

    private void navigateToGame(StrategyType strategyType)
    {
        Stage stage = (Stage)classicButton.getScene().getWindow();
        navigation.showGamePage(stage, strategyType);
    }
}
