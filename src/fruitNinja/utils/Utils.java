package fruitNinja.utils;

import fruitNinja.models.Difficulty;

import java.util.Random;

public class Utils {

    public int generateRandomIntBasedOnDifficulty(Difficulty difficulty)
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
}
