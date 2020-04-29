package fruitNinja.models.bombs;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameObjects.Sprite;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class Bomb extends Sprite {
    private BombType bombType;
    private final AudioController audioController = new AudioController();
    public Bomb(BombType bombType){
        this.bombType = bombType;
    }

    @Override
    public void slice()
    {
        try {
            audioController.start("bomb");
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        setSliced(true);
    }
}
