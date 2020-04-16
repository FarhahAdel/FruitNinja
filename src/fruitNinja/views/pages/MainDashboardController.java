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

import java.io.NotActiveException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dc user on 12/04/2020.
 */
public class MainDashboardController implements Initializable {

    @FXML
    private Button ArcadeButton;

    @FXML
    private Button ZenButton;

    @FXML
    private Button ClassicButton;

    @FXML
    private Button ExitButton;

    @FXML
    private ProgressBar LevelBar;

    @FXML
    private Label LevelNum;

    @FXML
    private Label Level;

    @FXML
    private Button NewGameButton;

    @FXML
    private Button LeaderBoardButton;

    @FXML
    private Button BackButton;

    @FXML
    private Label PlayerName;

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
    void Back(ActionEvent event) {

    }

    @FXML
    void ArcadeMode(ActionEvent event) {
        navigateToGame(StrategyType.ARCADE);

    }

    @FXML
    void ClassicMode(ActionEvent event) {
        navigateToGame(StrategyType.CLASSIC);
    }


    @FXML
    void ZenMode(ActionEvent event) {
        navigateToGame(StrategyType.ZEN);
    }

    @FXML
    void LeaderBoard(ActionEvent event) {

    }

    @FXML
    void NewGame(ActionEvent event) {
        ZenButton.setVisible(true);
        ClassicButton.setVisible(true);
        ArcadeButton.setVisible(true);
        ExitButton.setVisible(true);
        LeaderBoardButton.setVisible(false);
        NewGameButton.setVisible(false);
        BackButton.setVisible(false);
    }

    @FXML
    void Exit(ActionEvent event) {
        ZenButton.setVisible(false);
        ClassicButton.setVisible(false);
        ArcadeButton.setVisible(false);
        ExitButton.setVisible(false);
        LeaderBoardButton.setVisible(true);
        NewGameButton.setVisible(true);
        BackButton.setVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLevel();
    }

    private void setLevel()
    {
        int levelMaxPoints = utils.calculateExperiencePoints(player.getLevel());
        double percentage = player.getExperience() * 1.0 / levelMaxPoints;
        LevelBar.setProgress(percentage);
        Level.setText(String.valueOf(player.getLevel()));
    }

    private void navigateToGame(StrategyType strategyType)
    {
        Stage stage = (Stage)ClassicButton.getScene().getWindow();
        navigation.showGamePage(stage, strategyType);
    }
}
