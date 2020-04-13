package fruitNinja.data.services;

import fruitNinja.data.wrappers.Players;
import fruitNinja.models.users.Player;

import javax.xml.bind.*;
import java.io.File;
import java.util.ArrayList;

public class PlayerService extends BaseService<Player> {

    public PlayerService()
    {
        super();
    }

    @Override
    public ArrayList<Player> readData() {
        JAXBContext jaxbContext= null;
        ArrayList<Player> _players = null;
        try {
            jaxbContext = JAXBContext.newInstance(Players.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Players players = (Players) unmarshaller.unmarshal(getPlayersFile());
            _players = players.getPlayers();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return _players;
    }

    @Override
    public void writeData(Player data) {

        Players players = new Players();
        ArrayList<Player> _playersList = readData();
        _playersList.add(data);
        players.setPlayers(_playersList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Players.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(players, getPlayersFile());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
