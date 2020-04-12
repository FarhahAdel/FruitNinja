package fruitNinja.views.guiUtils;

import fruitNinja.models.users.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {


    private final int width = 1280;
    private final int height = 720;

    private Player loggedInPlayer;
    private Alerts alerts;

    public Navigation()
    {
        alerts = new Alerts();
    }

    private void showPageWithoutController(String fileName, String title, Stage stage){
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

    private void showPageWithCustomController(String fileName, String title, Stage stage, Class controllerClass)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
            loader.setController(controllerClass);
            GridPane grid = loader.load();
            stage.setTitle(title);
            Scene sc = new Scene(grid, width, height);
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            alerts.showErrorAlert("Data Error", "Something wrong happened!");
        }
    }

    public void showMainDashboardPage(Stage stage)
    {
        // MainDashBoard controller = new MainDashBoardController(loggedInPlayer);
        //showPageWithCustomController("../pages/MainPage.fxml", "Dashboard", stage, controller);
    }

    public void showRegisterPage(Stage stage)
    {
        showPageWithoutController("../pages/RegisterPage.fxml", "Register", stage);
    }

    public void showLoginPage(Stage stage)
    {
        showPageWithoutController("../pages/LoginPage.fxml", "Login",  stage);
    }

}
