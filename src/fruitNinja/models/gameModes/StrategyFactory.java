package fruitNinja.models.gameModes;

public class StrategyFactory {

    public GameStrategy createStrategy(String name)
    {
        if (name == null) throw new NullPointerException();

        switch (name.toLowerCase())
        {
            case "classic": return new ClassicStrategy();
            case "zen": return new ZenStrategy();
            case "arcade": return new ArcadeStrategy();
            default: return null;
        }
    }
}
