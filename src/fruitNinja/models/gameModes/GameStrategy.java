package fruitNinja.models.gameModes;

public interface GameStrategy {
    void initGame();


    // THESE TWO FUNCTIONS TO BE MOVED TO ANOTHER INTERFACE
    void bombBehaviour();
    boolean gameEndCondition();
}
