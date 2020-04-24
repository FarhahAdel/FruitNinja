package fruitNinja.models.users;

import fruitNinja.models.gameModes.StrategyType;

import static fruitNinja.models.gameModes.StrategyType.ZEN;

public class Score {
    StrategyType strategyType;
    String userName=PlayerSingleton.getInstance().getUsername();
    private String score;
    private String zenScore;
    private String classicScore;
    private String arcadeScore;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getZenScore() {
        return zenScore;
    }

    public void setZenScore(String zenScore) {
        this.zenScore = zenScore;
    }

    public String getClassicScore() {
        return classicScore;
    }

    public void setClassicScore(String classicScore) {
        this.classicScore = classicScore;
    }

    public String getArcadeScore() {
        return arcadeScore;
    }

    public void setArcadeScore(String arcadeScore) {
        this.arcadeScore = arcadeScore;
    }

    public Score(StrategyType strategyType, String score) {
        this.strategyType = strategyType;
        this.score=score;
        chooseclass(strategyType,score);
    }
    public void chooseclass(StrategyType strategyType,String score){
        switch (strategyType){
            case ZEN:
                zenScore=score;
                break;
            case ARCADE:
                arcadeScore=score;
                break;
            case CLASSIC:
                classicScore=score;
                break;

        }
    }
}

