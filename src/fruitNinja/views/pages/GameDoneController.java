package fruitNinja.views.pages;

import fruitNinja.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.guiUpdate.UpdateScoreListener;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
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


    private Navigation navigation = new Navigation();

    public GameDoneController() {
        this.player = PlayerSingleton.getInstance();
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
        scoreValue.setText("you are doing well");
    }
    private void setHighScoreValue()
    {
        highScoreValue.setText("holaa");
    }



}
