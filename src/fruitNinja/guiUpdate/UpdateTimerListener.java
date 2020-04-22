package fruitNinja.guiUpdate;

import javafx.scene.control.Label;

public class UpdateTimerListener implements EventListener {

    private Label label;

    public UpdateTimerListener(Label label)
    {
        this.label = label;
    }

    @Override
    public void update(String eventType, String data) {
        label.setText(data);
    }
}
