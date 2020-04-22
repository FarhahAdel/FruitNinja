package fruitNinja.models.gameStates;

public abstract class State {
    Game gameState;
    public State(Game gameState){
        this.gameState = gameState;
    }
    public abstract void clickPause();
    public abstract void clickPlay();
}
