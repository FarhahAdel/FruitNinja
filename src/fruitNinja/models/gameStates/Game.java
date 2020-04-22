package fruitNinja.models.gameStates;

import fruitNinja.utils.events.Timer;
import fruitNinja.utils.pause.PauseLogic;

public class Game {
    private PauseLogic pauseLogic = new PauseLogic();
    private State state;
    Timer timer;
    public Game(Timer timer){
        this.state = new PlayingState(this);
        this.timer = timer;
    }


    public void changeState(State state){
        this.state = state;
    }


    public void clickPause(){
        state.clickPause();
    }
    public void clickPlay(){
        state.clickPlay();
    }


    public void pausePlaying(){
        pauseLogic.pauseAnimationTimer();
    }
    public void continuePlaying(){
        pauseLogic.resumeAnimationTimer();
    }
}
