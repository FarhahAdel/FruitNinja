package fruitNinja.models.gameModes;

public class ModeContext {
    GameStrategy gameStrategy;

    public void setGameStrategy(GameStrategy strategy)
    {
        gameStrategy = strategy;
    }

    public void startGame()
    {
        gameStrategy.initGame();
    }
}
