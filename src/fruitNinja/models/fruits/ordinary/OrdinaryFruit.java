package fruitNinja.models.fruits.ordinary;

import fruitNinja.guiUpdate.ControlsUpdaterSingleton;
import fruitNinja.models.audios.AudioController;
import fruitNinja.models.fruits.Fruit;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class OrdinaryFruit extends Fruit {
    private final int points = 1;
    private final int lifeMinimizing = 1;
    private AudioController audioController = new AudioController();
    @Override
    public void slice()
    {
        setImage(getImageAfterSlicing());
        try {
            audioController.start("fruit");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        setSliced(true);
        ControlsUpdaterSingleton.getInstance().sliceOrdinaryFruit(points);
    }
}
