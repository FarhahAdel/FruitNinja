package fruitNinja.models.audios;

import javax.sound.sampled.*;
import java.io.*;


/**
 * Created by dc user on 22/04/2020.
 */
public class Audio {
    AudioInputStream audioInputStream;
    Clip clip;
    public void fruitSlice () throws IOException, LineUnavailableException, UnsupportedAudioFileException {
      music("src/fruitNinja/views/audios/slice.wav");
    }

    public void specialSlice() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
       music("src/fruitNinja/views/audios/Fruit Ninja s.wav");
    }

    public void gameStart() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        music("src/fruitNinja/views/audios/fruit.wav");
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void gameOver() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        music("src/fruitNinja/views/audios/Fruit Ninja gameover.wav");
    }

    public void bombSlice() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
       music("src/fruitNinja/views/audios/Fruit Ninja bomb.wav");
    }
    public void stop()
    {
        clip.stop();
    }
    private void music(String fileName) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream( new File(fileName));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
}
