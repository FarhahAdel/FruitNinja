package fruitNinja.data.repositories;

import fruitNinja.data.services.PlayerService;
import fruitNinja.data.services.Service;
import fruitNinja.models.users.Player;

import java.util.ArrayList;

public class PlayerRepository {
    private Service<Player> playerService;
    private ArrayList<Player> players;

    public PlayerRepository()
    {
        playerService = new PlayerService();
        loadPlayers();
    }

    private void loadPlayers()
    {
        players = playerService.readData();
    }

    public Player login(String username, String password)
    {
        for(Player player: players)
        {
            if (player.getUsername().equals(username) && player.getPassword().equals(password))
                return player;
        }

        return null;
    }

    public Player signUp(String fullName, String username, String password)
    {
        Player player = new Player(fullName, username, password);
        playerService.writeData(player);
        loadPlayers();
        return login(username, password);
    }


}
