package fruitNinja.models.guiUpdate;

import javafx.scene.control.Label;

public class DangerousBombListener implements EventListener{
    private Label label;
    public DangerousBombListener(Label label){
        this.label = label;
    }

    @Override
    public void update(String eventType, String data) {
        int scoreUpdate = Integer.parseInt(data);
        String newText = String.valueOf(Integer.parseInt(label.getText()) - scoreUpdate);
        label.setText(newText);
    }
}
