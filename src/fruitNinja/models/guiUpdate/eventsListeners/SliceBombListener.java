package fruitNinja.models.guiUpdate.eventsListeners;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.guiUpdate.EventListener;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.GameOverContoller;
import javafx.animation.PauseTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SliceBombListener implements EventListener {
    private final Stage stage;
    private final StrategyType strategyType;

    public SliceBombListener(Stage stage, StrategyType strategyType){
        this.stage = stage;
        this.strategyType = strategyType;
    }

    @Override
    public void update(String eventType, String data) {
        Navigation navigation = new Navigation();
        navigation.showGameOverPage(stage,strategyType);
    }
}
