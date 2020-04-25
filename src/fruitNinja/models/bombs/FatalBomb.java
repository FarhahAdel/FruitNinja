package fruitNinja.models.bombs;

public class FatalBomb extends Bomb{
    public FatalBomb() {
        super(BombType.FATAL);
        setImage("/fruitNinja/views/images/FatalBomb.png");
    }
}
