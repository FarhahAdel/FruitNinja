package fruitNinja.models.audios;

import fruitNinja.models.gameModes.StrategyFactory;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Created by dc user on 22/04/2020.
 */
public class AudioController {
    private String type;
    Audio audio=new Audio();
    Invoker invoker=new Invoker();
    Command command;

    public AudioController() {
    }

    public Command start(String type) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        switch (type.toLowerCase()) {
            case "bomb" :
                command = new BombSlice(audio);
                break;
            case "fruit" :
                command = new FruitSlice(audio);
                break;
            case "special" :
                command = new SpecialSlice(audio);
                break;
            case "start" :
                command = new StartGame(audio);
                break;
            case "gameover" :
                command = new GameOver(audio);
                break;
        }
        invoker.setCommand(command);
        invoker.play();
        return command;
    }

    public void stop(){
        invoker.stop();
    }
}
