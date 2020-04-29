package fruitNinja.models.fruits.special;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.guiUpdate.ControlsUpdater;
import fruitNinja.models.guiUpdate.ControlsUpdaterSingleton;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

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
