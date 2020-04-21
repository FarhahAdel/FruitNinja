package fruitNinja.views.pages;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class GameChooseController {
    public Button classicButton;

    private Navigation navigation = new Navigation();

    public void arcadeMode(ActionEvent actionEvent) {
        navigateToGame(StrategyType.ARCADE);
    }

    public void zenMode(ActionEvent actionEvent) {
        navigateToGame(StrategyType.CLASSIC);
    }

    public void classicMode(ActionEvent actionEvent) {
        navigateToGame(StrategyType.ZEN);
    }

    public void exit(ActionEvent actionEvent) {
        navigation.showMainDashboardPage((Stage) classicButton.getScene().getWindow());
    }
    private void navigateToGame(StrategyType strategyType)
    {
        Stage stage = (Stage)classicButton.getScene().getWindow();
        navigation.showGamePage(stage, strategyType);
    }
}
