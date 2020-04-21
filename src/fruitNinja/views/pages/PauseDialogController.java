package fruitNinja.views.pages;

import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.events.Timer;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class PauseDialogController {
    private Timer timer;
    public  Button quitBtn;
    private Player player;

    Navigation navigation=new Navigation();

    public PauseDialogController() {
        this.player = PlayerSingleton.getInstance();

    }
//    public PauseDialogController( Timer timer){
//        this.timer = timer;
//
//    }
    Stage stage = new Stage();



    public void show(Window window) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PauseDialog.fxml"));
        Scene scene = new Scene(root,700,600);

        stage.initModality(Modality.APPLICATION_MODAL);
        //stage.initStyle(StageStyle.UNDECORATED);
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
        Stage stage1 =(Stage)quitBtn.getScene().getWindow();
        stage1.close();

       // System.out.println(timer.getSTARTTIME());
        //timer.resumeTimer();
        System.out.println("in resume 3la dma3'na");
    }

}
