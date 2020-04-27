package fruitNinja.views.pages;

import fruitNinja.data.repositories.ScoreRepository;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.models.users.Score;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameDoneController implements Initializable {
    public Label scoreValue;
    public Label highScoreValue;
    public Button playAgainBtn;
    public Button mainMenuBtn;
    private Player player;
    private StrategyType strategyType;


    public GameDoneController(StrategyType strategyType) {
        this.strategyType = strategyType;
    }


    private Navigation navigation = new Navigation();
    Score score;
    ScoreRepository scoreRepository=new ScoreRepository();
    public GameDoneController() {
        this.player = PlayerSingleton.getInstance();
       // scoreValue.setText();

    }


    @FXML
    public void handlePlayAgainActionButton(ActionEvent actionEvent) {
        Stage stage=(Stage)playAgainBtn.getScene().getWindow();
        navigation.showGameChoosePage(stage);
        //navigation.showGamePage(stage,strategyType);
        //navigateToGameWindow();
        GamePlayActions.isPaused=false;
    }

    public void handleMainMenuActionButton(ActionEvent actionEvent) {
        Stage stage;
        stage = (Stage)mainMenuBtn.getScene().getWindow();
        navigation.showMainDashboardPage(stage);
        GamePlayActions.isPaused=false;
        //navigation.setLoggedInPlayer(player);
        //System.out.println(player.getUsername());
       // navigation.setLoggedInPlayer(player);
        //navigation.showMainDashboardPage(stage);
    }

//    private void navigateToMainDashboardWindow(){
//        Stage stage;
//        stage = (Stage)mainMenuBtn.getScene().getWindow();
//        navigation.showMainDashboardPage(stage,player);
//
//
//    }


    private void navigateToGameWindow(){
        Stage stage;
        stage = (Stage)playAgainBtn.getScene().getWindow();
       // navigation.showMainDashboardPage(stage);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setScoreValue();
        setHighScoreValue();
    }
    private void setScoreValue(){
        scoreValue.setText(String.valueOf(PlayerSingleton.getInstance().getCurrentScore()));
    }
    private void setHighScoreValue()
    {
        highScoreValue.setText(scoreRepository.getHighScore(strategyType,PlayerSingleton.getInstance().getUsername()));
    }



}
