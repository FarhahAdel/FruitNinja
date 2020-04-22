package fruitNinja.models.audios;

import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public class GameOver implements Command {
    Audio audio;

    public GameOver(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() throws IOException {
        audio.gameOver();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
