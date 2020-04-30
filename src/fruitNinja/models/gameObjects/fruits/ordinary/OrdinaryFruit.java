package fruitNinja.models.gameObjects.fruits.ordinary;

import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameObjects.fruits.Fruit;

public class OrdinaryFruit extends Fruit {
    private final int points = 1;
    private final int lifeMinimizing = 1;
    private AudioController audioController = new AudioController();

    @Override
    public void slice()
    {
        setImage(getImageAfterSlicing());
        audioController.start("fruit");
        setSliced(true);
        ControlsUpdaterSingleton.getInstance().sliceOrdinaryFruit(points);
    }

    @Override
    public void fellOff()
    {
        setHasFallenOff(true);
        if (!isSliced())
            ControlsUpdaterSingleton.getInstance().fruitFell(lifeMinimizing);
    }
}
