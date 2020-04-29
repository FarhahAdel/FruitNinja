package fruitNinja.models.fruits.special;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.fruits.Fruit;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SpecialFruit extends Fruit {
    private AudioController audioController = new AudioController();

    @Override
    public void slice()
    {
        setImage(getImageAfterSlicing());
        audioController.start("special");
        setSliced(true);
    }

}
