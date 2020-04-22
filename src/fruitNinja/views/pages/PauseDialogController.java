package fruitNinja.views.pages;

import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameStates.Game;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.pause.PauseLogic;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class PauseDialogController {
    public  Button quitBtn;
    private Player player;
    private Game gameState;

    Navigation navigation=new Navigation();

    public PauseDialogController(Game gameState) {
        this.player = PlayerSingleton.getInstance();
        this.gameState = gameState;
    }

    Stage stage = new Stage();



    public void show(Window window) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseDialog.fxml"));
        loader.setController(this);
        GridPane grid = loader.load();
        Scene scene = new Scene(grid,700,600);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(window);
        stage.setScene(scene);
        stage.show();

        }


    public void quitBtnClicked(ActionEvent actionEvent) {
            Stage stage = (Stage)quitBtn.getScene().getWindow();
            stage.close();
            navigation.showGameDonePage(stage);
    }

    public void restartBtnClicked(ActionEvent actionEvent){
    }

    public void resumeBtnClicked(ActionEvent actionEvent) {
        GamePlayActions.isPaused = false;
        Stage stage1 =(Stage)quitBtn.getScene().getWindow();
        stage1.close();
        gameState.clickPlay();
    }

}
