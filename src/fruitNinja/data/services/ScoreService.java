package fruitNinja.data.services;

import fruitNinja.data.wrappers.Players;
import fruitNinja.data.wrappers.Scores;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.Score;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;

public class ScoreService extends BaseService<Score> {
    @Override
    public ArrayList<Score> readData() {
        JAXBContext jaxbContext= null;
        ArrayList<Score> _scores = null;
        try {
            jaxbContext = JAXBContext.newInstance(Scores.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Scores scores= (Scores) unmarshaller.unmarshal(getPlayersFile());
            _scores = scores.getScores();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return _scores;
    }


    @Override
    public void writeData(Score data) {
       Scores scores = new Scores();
       ArrayList<Score> scoresList = readData();
       scoresList.add(data);
       scores.setScores(scoresList);

       try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Scores.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(scores, getPlayersFile());
       } catch (JAXBException e) {
            e.printStackTrace();
       }
    }


}
