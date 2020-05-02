package fruitNinja.models.states;

public class PauseState extends State{
    public PauseState(GameState gameState) {
        super(gameState);
    }

    @Override
    public void clickPause() {

    }

    @Override
    public void clickPlay() {
        gameState.continuePlaying();
        gameState.changeState(new PlayingState(gameState));
    }
}
