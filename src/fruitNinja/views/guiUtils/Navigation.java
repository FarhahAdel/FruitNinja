package fruitNinja.views.guiUtils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    private Alerts alerts;

    public Navigation()
    {
        alerts = new Alerts();
    }

    private void showPageWithoutController(String fileName , String title, Stage stage){

        int width = 1280;
        int height = 720;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
            GridPane grid = loader.load();
            stage.setTitle(title);
            Scene sc = new Scene(grid, width, height);
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            alerts.showErrorAlert("Data Error", "Something wrong happened!");
        }
    }

    public void showRegisterPage(Stage stage)
    {
        showPageWithoutController("../pages/RegisterPage.fxml", "Register", stage);
    }

    public void showLoginPage(Stage stage)
    {
        showPageWithoutController("../pages/LoginPage.fxml", "Login", stage);
    }

}
