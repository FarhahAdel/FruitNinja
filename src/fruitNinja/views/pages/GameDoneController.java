package fruitNinja.views.pages;

import fruitNinja.models.users.Player;
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

    private Navigation navigation = new Navigation();

    public GameDoneController(Player player){
        this.player=player;
//        navigation.setLoggedInPlayer(player);
//        System.out.println(player.getUsername()+"in gamekhaea");
    }

    @FXML
    public void handlePlayAgainActionButton(ActionEvent actionEvent) {
        navigateToGameWindow();
    }

    public void handleMainMenuActionButton(ActionEvent actionEvent) {
        Stage stage;
        stage = (Stage)mainMenuBtn.getScene().getWindow();
        //navigation.setLoggedInPlayer(player);
        //System.out.println(player.getUsername());
       // navigation.setLoggedInPlayer(player);
        navigation.showMainDashboardPage(stage);
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
