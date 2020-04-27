package fruitNinja.data.repositories;

import fruitNinja.data.services.BaseService;
import fruitNinja.data.services.PlayerService;
import fruitNinja.data.services.Service;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Alerts;

import java.io.File;
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
        File file=new File("src/fruitNinja/data/files/players.xml");
        boolean empty = file.length()==0;
        if(!empty){
            players = playerService.readData();

        }
    }


    public Player login(String username, String password)
    {  if(players==null)
        return null;
    for(Player player: players)
        {
            if (player.getUsername().equals(username) && player.getPassword().equals(password))
                return player;
        }

        return null;
    }

    public Player signUp(String fullName, String username, String password)
    {
        for (Player player:players)
        {
            if (player.getUsername().equals(username))
                return null;
        }

        Player player = new Player(fullName, username, password);
        player.setExperience(0);
        player.setLevel(1);
        playerService.writeData(player);
        loadPlayers();
        return login(username, password);
    }


}
