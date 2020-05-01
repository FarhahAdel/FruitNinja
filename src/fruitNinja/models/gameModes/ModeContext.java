package fruitNinja.models.gameModes;

import fruitNinja.models.gameModes.Stratgies.GameStrategy;
import fruitNinja.models.gameModes.Stratgies.TimerStrategy;
import javafx.scene.canvas.Canvas;

public class ModeContext {
    private GameStrategy gameStrategy;

    public ModeContext(GameStrategy gameStrategy)
    {
        this.gameStrategy = gameStrategy;
    }

    public void startGame(Canvas canvas) {
        gameStrategy.initGame(canvas);
        if(!gameStrategy.getStrategyType().equals(StrategyType.CLASSIC)){
            TimerStrategy timerStrategy = (TimerStrategy) gameStrategy;
            timerStrategy.startCustomTimer();
        }
    }
}
