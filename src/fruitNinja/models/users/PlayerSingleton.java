package fruitNinja.models.users;

public class PlayerSingleton {

    private volatile static Player playerSingleton;

    private PlayerSingleton()
    {

    }

    public static Player getInstance() {
        if (playerSingleton == null) {
            synchronized (PlayerSingleton.class) {
                if (playerSingleton == null)
                    playerSingleton = new Player();
            }
        }

        return playerSingleton;
    }

    public static void setPlayerSingleton(Player player)
    {
        playerSingleton = player;
    }

}
