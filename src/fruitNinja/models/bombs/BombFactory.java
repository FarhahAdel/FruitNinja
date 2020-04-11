package fruitNinja.models.bombs;

public class BombFactory {
    public Bomb createBomb(String BombType){
        Bomb bomb;
        switch(BombType){
            case "fatal":
                bomb = new FatalBomb();
                break;
            case "dangerous":
                bomb = new DangerousBomb();
                break;
            default:
                bomb = null;
        }
        return bomb;
    }
    public Bomb createBomb(BombType BombType){
        Bomb bomb;
        switch(BombType){
            case FATAL:
                bomb = new FatalBomb();
                break;
            case DANGEROUS:
                bomb = new DangerousBomb();
                break;
            default:
                bomb = null;
        }
        return bomb;
    }
}
