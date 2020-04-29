package fruitNinja.models.guiUpdate;

import javafx.scene.control.Label;

public class LivesLabelListener implements EventListener {

    private Label label;

    public LivesLabelListener(Label label)
    {
        this.label = label;
    }

    @Override
    public void update(String eventType, String data) {
        if(!label.getText().equals("XXX"))
            label.setText(label.getText() + "X");
    }
}
