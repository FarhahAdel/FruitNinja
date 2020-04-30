package fruitNinja.models.gameObjects.fruits.special;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameObjects.fruits.Fruit;
import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;

public class SpecialFruit extends Fruit {
    private AudioController audioController = new AudioController();
    private final int specialFruitsPoints = 3;

    @Override
    public void slice()
    {
        setImage(getImageAfterSlicing());
        audioController.start("special");
        ControlsUpdaterSingleton.getInstance().sliceOrdinaryFruit(specialFruitsPoints);
        setSliced(true);
    }

}
