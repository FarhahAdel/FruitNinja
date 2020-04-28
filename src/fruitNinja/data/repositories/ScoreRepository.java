package fruitNinja.data.repositories;

import fruitNinja.data.services.ScoreService;
import fruitNinja.data.services.Service;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Score;

import java.io.File;
import java.util.ArrayList;

public class ScoreRepository {
    private ScoreService scoreService;

    private ArrayList<Score> scores=null;

    public ScoreRepository() {
        scoreService = new ScoreService();
        loadScores();
    }

    private void loadScores() {
        File file=new File("src/fruitNinja/data/files/scores.xml");
        boolean empty = file.length() == 0;
        if(!empty){
            scores = scoreService.readData();
        }
       // else scores=null;

    }

    public Score playerData(String username,StrategyType strategyType) {
        if (scores == null)
            return null;
            for (Score score : scores) {
                if (score.getUsername().equals(username))
                    return score;
            }
            return null;
        }

    public void addScore(String score, String username, StrategyType strategyType){
        boolean flag =false;
        if(scores!=null){
        for(Score score1:scores) {

            if (username.equals(score1.getUsername())) {
                flag = true;
                if (score1.scoreStrategy(strategyType) == null||Integer.parseInt(score) > Integer.parseInt(score1.scoreStrategy(strategyType))) {
                    score1.scoreUponStrategy(score, strategyType);
                    scoreService.updateData(scores);
                }

            }
        }
        if(!flag){
            scores.add(new Score(strategyType,score));
            scoreService.updateData(scores);
        }}
        else {
            Score newScore = new Score(strategyType,score);
            ArrayList<Score> scoresInit=new ArrayList<>();
            scoresInit.add(newScore);
            scoreService.updateData(scoresInit);
        }
    }
    public String getHighScore(StrategyType strategyType,String username){
        String highScore=null;
        for(Score score:scores){
            if(score.getUsername().equals(username))
               highScore= score.scoreStrategy(strategyType);

        }
    return highScore;
    }
}
