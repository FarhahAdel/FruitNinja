package fruitNinja.utils;

import fruitNinja.models.Difficulty;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.views.guiUtils.Navigation;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Utils {

    public int generateRandomFruitNumBasedOnDifficulty(Difficulty difficulty)
    {
        Random random = new Random();
        int min = 3;
        switch (difficulty)
        {
            case MEDIUM: min += random.nextInt(1) + 1;  break; // 4 OR 5
            case HARD: min += random.nextInt(1) + 2; break; // 5 OR 6
        }
        return min;
    }

    public int generateRandomBombNumBasedOnDifficulty(Difficulty difficulty)
    {
        int min = 0;
        switch (difficulty)
        {
            case EASY: min = (int)((Math.random()*(1-0+1))); break; // 0 OR 1
            case MEDIUM: min = (int)((Math.random()*(2-1+1))+1);  break; // 1 OR 2
            case HARD: min = (int)((Math.random()*(2-1+1))+1); break; // 1 OR 2
        }

        return min;
    }

    public boolean generateSpecialFruit()
    {
        int n = (int)((Math.random()*(6-1+1))+1); //random num from 1 to 6
        if (n==1)
            return true;
        return false;
    }

    public Difficulty getDifficultyByWaveNumber(int wave)
    {
        if (wave > 10) return Difficulty.HARD;
        else if (wave > 5) return Difficulty.MEDIUM;
        else return Difficulty.EASY;
    }

    public <T extends Enum<?>> T randomValueFromEnum(Class<T> en)
    {
        Random random = new Random();
        int n = random.nextInt(en.getEnumConstants().length);
        return en.getEnumConstants()[n];
    }

    public int calculateExperiencePoints(int level)
    {
        return (int) Math.pow(2, level + 7);
    }

    public void showLabelForCertainTime(Label label, long time)
    {
        label.setVisible(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                label.setVisible(false);
                timer.cancel();
                timer.purge();
            }
        }, time);
    }

    int counter = 0;

    public void showGameOverAfterTime(int time, Stage stage, StrategyType strategyType) {


        final Boolean[] wasPaused = {false};

        final Timer[] currentTimer = {startTimer(stage, strategyType,time,null)};

        Timer pauseChecker = new Timer();
        pauseChecker.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (GamePlayActions.isPaused){
                    wasPaused[0] = true;
                    currentTimer[0].cancel();
                }
                else if(wasPaused[0]){
                    wasPaused[0] = false;
                    currentTimer[0] = startTimer( stage, strategyType,time,pauseChecker);
                }
            }
        },500L,500L);
    }



    private Timer startTimer( Stage stage, StrategyType strategyType,int time,Timer pauseTimer){
        Navigation navigation = new Navigation();
        final Timer[] timer = {new Timer()};

        timer[0].scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(counter == time) {
                    Platform.runLater(() -> {
                        navigation.showGameOverPage(stage, strategyType);
                    });

                    if(pauseTimer !=null){
                        pauseTimer.cancel();
                        pauseTimer.purge();
                    }

                    timer[0].cancel();
                    timer[0].purge();
                }
                counter++;
            }
        }, 1000L, 1000L);

        return timer[0];
    }
}
