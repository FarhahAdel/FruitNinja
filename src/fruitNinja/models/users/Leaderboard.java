package fruitNinja.models.users;

import fruitNinja.data.services.ScoreService;
import fruitNinja.models.gameModes.StrategyType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dc user on 30/04/2020.
 */
public class Leaderboard implements Comparable<Leaderboard> {
    private String score;
    private String userName;
    private StrategyType strategyType;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Leaderboard(String score, String userName) {
        this.score = score;
        this.userName = userName;
    }

    public Leaderboard(StrategyType strategyType) {
        this.strategyType=strategyType;
    }

    @Override
    public int compareTo(Leaderboard leaderboard) {
        int compare = Integer.compare(Integer.parseInt(leaderboard.score),Integer.parseInt(score));
        if (compare==0)
            compare = Integer.compare(Integer.parseInt(leaderboard.userName),Integer.parseInt(userName));
        return compare;
    }
   public List<Leaderboard> Sort(){
       ScoreService scoreService= new ScoreService();
       List<Score> scores=scoreService.readData();
       List<Leaderboard> leaderboards=new ArrayList<>();
       for(Score score : scores)
           leaderboards.add(new Leaderboard(score.scoreStrategy(strategyType), score.getUsername()));
       Collections.sort(leaderboards);
       for (Leaderboard leaderboard:leaderboards)
           System.out.println(leaderboard.getScore()+" "+leaderboard.getUserName());
       return leaderboards;
   }
}
