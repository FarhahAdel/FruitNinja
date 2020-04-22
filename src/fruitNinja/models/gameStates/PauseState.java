package fruitNinja.models.gameStates;

public class PauseState extends State{
    public PauseState(Game gameState) {
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
