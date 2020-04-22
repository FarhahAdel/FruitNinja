package fruitNinja.models.audios;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.print.attribute.standard.MediaName;
import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

/**
 * Created by dc user on 22/04/2020.
 */
public class Audio {
    FileInputStream fileInputStream;
    AudioStream audioStream;
    AudioPlayer audioPlayer;
    Clip clip;
    public void fruitSlice () throws IOException, LineUnavailableException, UnsupportedAudioFileException {
      music("src/fruitNinja/views/audios/slice.wav");
    }

    public void specialSlice()throws IOException {
       music("src/fruitNinja/views/audios/Fruit Ninja s.wav");
    }

    public void gameStart() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream( new File("src/fruitNinja/views/audios/fruit.wav"));
         clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }

    public void gameOver() throws IOException {
        music("src/fruitNinja/views/audios/Fruit Ninja gameover.wav");
    }

    public void bombSlice() throws IOException {
       music("src/fruitNinja/views/audios/Fruit Ninja bomb.wav");
    }
    public void stop()
    {
        audioPlayer.player.stop(audioStream);
        clip.stop();
    }
    private void music(String fileName) throws IOException {
        fileInputStream=new FileInputStream(new File(fileName));
        audioStream=new AudioStream(fileInputStream);
        audioPlayer.player.start(audioStream);
    }
}
