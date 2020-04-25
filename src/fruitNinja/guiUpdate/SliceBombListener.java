package fruitNinja.guiUpdate;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.views.guiUtils.Navigation;
import javafx.stage.Stage;

public class SliceBombListener implements EventListener{
    private final Stage stage;
    private final StrategyType strategyType;

    public SliceBombListener(Stage stage, StrategyType strategyType){
        this.stage = stage;
        this.strategyType = strategyType;
    }

    @Override
    public void update(String eventType, String data) {
        Navigation navigation = new Navigation();
        navigation.showGameDonePage(stage,strategyType);
    }


}
