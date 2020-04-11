package fruitNinja.models.bombs;

public class BombFactory {
    public Bomb createBomb(String bombType){
        Bomb bomb;
        switch(bombType){
            case "fatal":
            case "FATAL":
                bomb = new FatalBomb();
                break;
            case "dangerous":
            case "DANGEROUS":
                bomb = new DangerousBomb();
                break;
            default:
                bomb = null;
        }
        return bomb;
    }
    public Bomb createBomb(BombType BombType){
        Bomb bomb;
        return createBomb(BombType.toString());
    }
}
