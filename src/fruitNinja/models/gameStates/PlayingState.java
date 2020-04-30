package fruitNinja.models.gameStates;

public class PlayingState extends State{
    public PlayingState(GameState gameState) {
        super(gameState);
    }

    @Override
    public void clickPause() {
        gameState.pausePlaying();
        gameState.changeState(new PauseState(gameState));
    }

    @Override
    public void clickPlay() {

    }

}
