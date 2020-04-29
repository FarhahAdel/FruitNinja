package fruitNinja.views.guiUtils;

import fruitNinja.controllers.*;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.views.pages.*;
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

//    private void showAnchorPageWithoutController(String fileName, String title, Stage stage){
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
//            AnchorPane anchor = loader.load();
//            stage.setTitle(title);
//            Scene sc = new Scene(anchor, width, height);
//            stage.setScene(sc);
//            stage.show();
//        } catch (IOException ex) {
//            alerts.showErrorAlert("Data Error", "Something wrong happened!");
//        }
//    }

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
        MainDashboardView mainDashboardView = new MainDashboardView();
        showPageAnchorWithCustomController("../pages/MainDashboard.fxml", "Dashboard", stage, mainDashboardView);
        MainDashboardController mainDashboardController = new MainDashboardController(mainDashboardView);
    }

    public void showStartPage(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../pages/LoginPage.fxml"));
        LoginView loginView = new LoginView();
        loader.setController(loginView);
        GridPane grid = loader.load();
        LoginController loginController = new LoginController(loginView);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(grid, 1280, 720));
        primaryStage.show();
    }

    public void showRegisterPage(Stage stage)
    {
        RegisterView registerView = new RegisterView();
        showPageGridWithCustomController("../pages/RegisterPage.fxml", "Register", stage, registerView);
        RegisterController registerController = new RegisterController(registerView);
    }

    public void showGamePage(Stage stage, StrategyType strategyType)
    {
        GameView gameView = new GameView();
        showPageGridWithCustomController("../pages/GamePage.fxml", "Game", stage, gameView);
        GameController gameController = new GameController(gameView, strategyType);
    }
    public void showGameDonePage(Stage stage,StrategyType strategyType)
    {
        GameDoneController gameDoneController = new GameDoneController(strategyType);
        showPageGridWithCustomController("../pages/GameDone.fxml", "Game done", stage,gameDoneController);
    }

    public void showLoginPage(Stage stage)
    {
        LoginView loginView = new LoginView();
        showPageGridWithCustomController("../pages/LoginPage.fxml", "Login",  stage, loginView);
        LoginController loginController = new LoginController(loginView);
    }

    public void showGameChoosePage(Stage stage){
        GameChooseView gameChooseView = new GameChooseView();
        showPageAnchorWithCustomController("../pages/GameChoose.fxml", "Choose Game", stage, gameChooseView);
        GameChooseController gameChooseController = new GameChooseController(gameChooseView);
    }
}
