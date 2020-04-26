package fruitNinja.data.repositories;

import fruitNinja.data.services.ScoreService;
import fruitNinja.data.services.Service;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Score;

import java.util.ArrayList;

public class ScoreRepository {
    private Service<Score> scoreService;
    private ArrayList<Score> scores;

    public ScoreRepository() {
        scoreService = new ScoreService();
        loadScores();
    }

    private void loadScores() {
        scores = scoreService.readData();
    }

    public Score playerData(String username) {
        for(Score score:scores){
            if(score.getUsername().equals(username))
                return score;
        }
        return null;
}

    public void addScore(String score, String username, StrategyType strategyType){
        for(Score score1:scores){
            if((score1.getUsername().equals(username))&& Integer.parseInt(score)>Integer.parseInt(score1.getScore())){
                Score score2=new Score(strategyType,score);
                scoreService.writeData(score2);

            }
        }
    }
}
