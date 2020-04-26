package fruitNinja.utils.events;

import fruitNinja.animations.Projectile;
import fruitNinja.models.gameObjects.Sprite;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MouseDraggedEvent implements EventHandler<MouseEvent> {

    private HashMap<Sprite, Projectile> spritesMap;
    public MouseDraggedEvent(HashMap<Sprite, Projectile> spritesMap)
    {
        this.spritesMap = spritesMap;
    }

    private int comboCount = 0;

    @Override
    public void handle(MouseEvent mouseEvent) {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        spritesMap.forEach((k,v) -> {
            if (k.intersect(mouseX, mouseY) && !k.isSliced()) {
                k.slice();
                incComboCount();
            }
        });
    }


    public int getComboCount()
    {
        return comboCount;
    }

    public void setComboCount(int comboCount)
    {
        this.comboCount = comboCount;
    }

    public void incComboCount()
    {
        comboCount++;
    }


}
