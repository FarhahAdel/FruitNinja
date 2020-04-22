package fruitNinja.models.audios;

import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public class BombSlice implements Command {
    Audio audio;

    public BombSlice(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() throws IOException {
        audio.bombSlice();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
