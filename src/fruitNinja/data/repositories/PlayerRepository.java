package fruitNinja.data.repositories;

import fruitNinja.data.services.BaseService;
import fruitNinja.data.services.PlayerService;
import fruitNinja.data.services.Service;
import fruitNinja.data.wrappers.Players;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Alerts;

import java.io.File;
import java.util.ArrayList;

public class PlayerRepository {
    private Service<Player> playerService;
    private ArrayList<Player> players;
    private Utils utils=new Utils();
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

    public void updateLevel(){
        int levelMaxPoints = utils.calculateExperiencePoints(PlayerSingleton.getInstance().getLevel());
        int level=PlayerSingleton.getInstance().getLevel();
        int experience=PlayerSingleton.getInstance().getExperience();
        experience=experience+PlayerSingleton.getInstance().getCurrentScore();
        if(experience>=levelMaxPoints){
            PlayerSingleton.getInstance().setLevel(level+1);
            PlayerSingleton.getInstance().setExperience(experience-levelMaxPoints);
        }
        else
            PlayerSingleton.getInstance().setExperience(experience);
        updateFile();
    }

    private void updateFile(){
        for(Player player:players){
            if(player.getUsername().equals(PlayerSingleton.getInstance().getUsername()))
            {
                player.setExperience(PlayerSingleton.getInstance().getExperience());
                player.setLevel(PlayerSingleton.getInstance().getLevel());
            }
        }
        playerService.updateData(players);
    }


}
