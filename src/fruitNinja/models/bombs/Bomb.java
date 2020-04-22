package fruitNinja.models.bombs;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameObjects.Sprite;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class Bomb extends Sprite {
    private BombType bombType;
    private AudioController audioController = new AudioController();
    public void slice()
    {
        try {
            audioController.start("bomb");
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        setSliced(true);

    }
}
