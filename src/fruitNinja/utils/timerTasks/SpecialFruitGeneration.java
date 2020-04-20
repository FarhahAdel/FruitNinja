package fruitNinja.utils.timerTasks;

import fruitNinja.models.fruits.Fruit;
import fruitNinja.models.gameLogic.GamePlayService;

import java.util.TimerTask;

public class SpecialFruitGeneration extends TimerTask {


    private GamePlayService gamePlayService;

    public SpecialFruitGeneration()
    {
        gamePlayService = new GamePlayService();
    }

    @Override
    public void run() {
        //Fruit fruit = gamePlayService.generateRandomSpecialFruit();
        //gamePlayService.throwSpecialFruit(fruit);
    }
}
