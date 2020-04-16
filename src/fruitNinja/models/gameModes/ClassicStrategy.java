package fruitNinja.models.gameModes;

public class ClassicStrategy implements GameStrategy {

    int life = 3;

    @Override
    public void bombBehaviour() {
        life--;
    }
}