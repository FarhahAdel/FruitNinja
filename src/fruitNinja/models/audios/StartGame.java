package fruitNinja.models.audios;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public class StartGame implements Command {
    Audio audio;

    public StartGame(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        audio.gameStart();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
