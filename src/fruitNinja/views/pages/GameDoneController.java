package fruitNinja.views.pages;

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

    private Navigation navigation = new Navigation();

    @FXML
    private void handlePlayAgainActionButton(ActionEvent actionEvent) {
        navigateToGameWindow();
    }
    @FXML
    public void handleMainMenuActionButton(ActionEvent actionEvent) {
        navigateToMainDashboardWindow();
    }

    private void navigateToMainDashboardWindow(){
        Stage stage;
        stage = (Stage)mainMenuBtn.getScene().getWindow();
       // navigation.showPageWithoutController("../pages/MainDashboard.fxml", "Login", 1200, 700, stage);


    }


    private void navigateToGameWindow(){
        Stage stage;
        stage = (Stage)playAgainBtn.getScene().getWindow();
        //navigation.showPageWithoutController("../pages/GameWindow.fxml", "Login", 1200, 700, stage);

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
