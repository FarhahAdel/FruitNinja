package fruitNinja.models.gameObjects.fruits.special;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameObjects.fruits.Fruit;
import fruitNinja.models.guiUpdate.ControlsUpdater;
import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;

public class SpecialFruit extends Fruit {
    private AudioController audioController = new AudioController();

    @Override
    public void slice()
    {
        setImage(getImageAfterSlicing());
        audioController.start("special");
        functionality();
        setSliced(true);
    }
    private void functionality (){
        if(this instanceof Frenzy) {
            final int specialFruitsPoints = 3;
            ControlsUpdaterSingleton.getInstance().sliceOrdinaryFruit(specialFruitsPoints);
        }
    }

}
