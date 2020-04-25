package fruitNinja.models.bombs;

public class DangerousBomb extends Bomb{
    private final int scoreMinimizing = 10;
    private final int timeMinimizing = 10;
    private final int lifeMinimizing = 1;
    public DangerousBomb() {
        super(BombType.DANGEROUS);
        setImage("/fruitNinja/views/images/DangerousBomb.png");
    }

}
