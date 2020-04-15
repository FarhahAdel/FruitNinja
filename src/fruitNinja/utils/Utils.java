package fruitNinja.utils;

import fruitNinja.models.Difficulty;

import java.util.Random;

public class Utils {

    public int generateRandomIntBasedOnDifficulty(Difficulty difficulty)
    {
        int max;
        switch (difficulty){
            case EASY: max = 2; break;
            case MEDIUM: max = 4; break;
            case HARD: max = 5; break;
            default: max = 3; break;
        }

        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    public <T extends Enum<?>> T randomValueFromEnum(Class<T> en)
    {
        Random random = new Random();
        int n = random.nextInt(en.getEnumConstants().length);
        return en.getEnumConstants()[n];
    }
}
