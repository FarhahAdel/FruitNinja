package fruitNinja.models.guiUpdate;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.views.guiUtils.Navigation;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LivesLabelListener implements EventListener {

    private Label label;
    private Navigation navigation=new Navigation();
    private final Stage stage;

    public LivesLabelListener(Stage stage,Label label)
    {
        this.label = label;
        this.stage=stage;
    }

    @Override
    public void update(String eventType, String data) {
        if(!label.getText().equals("XXX"))
            label.setText(label.getText() + "X");
        else navigation.showGameDonePage(stage,StrategyType.CLASSIC);
    }
}
