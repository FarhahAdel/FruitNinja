package fruitNinja.views.guiUtils;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.views.pages.GameController;
import fruitNinja.views.pages.GameDoneController;
import fruitNinja.views.pages.MainDashboardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {


    private final int width = 1280;
    private final int height = 720;

    private Alerts alerts;

    public Navigation()
    {
        alerts = new Alerts();
    }

    private void showGridPageWithoutController(String fileName, String title, Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
            GridPane grid = loader.load();
            stage.setTitle(title);
            Scene sc = new Scene(grid, width, height);
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            alerts.showErrorAlert("Data Error", "Something wrong happened!");
            ex.printStackTrace();
        }
    }

    private void showAnchorPageWithoutController(String fileName, String title, Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
            AnchorPane anchor = loader.load();
            stage.setTitle(title);
            Scene sc = new Scene(anchor, width, height);
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            alerts.showErrorAlert("Data Error", "Something wrong happened!");
            ex.printStackTrace();
        }
    }

    private void showPageGridWithCustomController(String fileName, String title, Stage stage, Object controllerClass)
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
            ex.printStackTrace();
        }
    }

    private void showPageAnchorWithCustomController(String fileName, String title, Stage stage, Object controllerClass)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
            loader.setController(controllerClass);
            AnchorPane anchor = loader.load();
            stage.setTitle(title);
            Scene sc = new Scene(anchor, width, height);
            stage.setScene(sc);
            stage.show();
        } catch (IOException ex) {
            alerts.showErrorAlert("Data Error", "Something wrong happened!");
            ex.printStackTrace();
        }
    }

    public void showMainDashboardPage(Stage stage)
    {
        //MainDashboardController controller = new MainDashboardController(player);
        //showPageAnchorWithCustomController("../pages/MainDashboard.fxml", "Dashboard", stage, controller);

        showAnchorPageWithoutController("../pages/MainDashboard.fxml", "Dashboard", stage);

    }

    public void showRegisterPage(Stage stage)
    {
        showGridPageWithoutController("../pages/RegisterPage.fxml", "Register", stage);
    }

    public void showGamePage(Stage stage, StrategyType strategyType)
    {
        GameController gameController = new GameController(strategyType);

        showPageGridWithCustomController("../pages/GamePage.fxml", "Game", stage, gameController);
        //showPageAnchorWithCustomController("../pages/GamePage2.fxml", "Game", stage, gameController);

    }
    public void showGameDonePage(Stage stage)
    {
        //GameDoneController gameDoneController = new GameDoneController(currentPlayer);
        //setLoggedInPlayer(currentPlayer);
        showGridPageWithoutController("../pages/GameDone.fxml", "Game done", stage);
    }

    public void showLoginPage(Stage stage)
    {
        showGridPageWithoutController("../pages/LoginPage.fxml", "Login",  stage);
    }

}
