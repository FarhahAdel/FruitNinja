package fruitNinja.models.gameLogic;

import fruitNinja.models.users.Player;

public class PlayerPlayUpdates {
    private Player player;
    private int score;
    private int level;

    public int getScore() {
        return score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

//   // public PlayerPlayUpdates(Player player) {
//        this.player = player;
//    }
}
