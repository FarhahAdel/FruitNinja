package fruitNinja.models.audios;

import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public class SpecialSlice implements Command {
    Audio audio;

    public SpecialSlice(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void execute() throws IOException {
        audio.specialSlice();
    }

    @Override
    public void unexecute() {
        audio.stop();
    }
}
