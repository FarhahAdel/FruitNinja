package fruitNinja.models.users;

import fruitNinja.models.gameModes.StrategyType;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="score")
@XmlAccessorType(XmlAccessType.FIELD)
public class Score {
    @XmlElement(name="strategy")
    StrategyType strategyType;
    @XmlElement(name="username")
    private String username;
    @XmlTransient
    private String score;
    @XmlElement(name="zen Score")
    private String zenScore;
    @XmlElement(name = "classic Score")
    private String classicScore;
    @XmlElement(name = "arcade Score")
    private String arcadeScore;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        this.username=PlayerSingleton.getInstance().getUsername();
        chooseStrategy(strategyType,score);
    }
    public void chooseStrategy(StrategyType strategyType,String score){
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

