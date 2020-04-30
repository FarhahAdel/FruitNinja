package fruitNinja.controllers;

import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Leaderboard;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.LeaderboardView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dc user on 30/04/2020.
 */
public class LeaderboardController {
    LeaderboardView leaderboardView;
    Leaderboard leaderboard;
    List<Leaderboard> scores = new ArrayList<>();
    Navigation navigation = new Navigation();
    public LeaderboardController(LeaderboardView leaderboardView) {
        this.leaderboardView=leaderboardView;
        setEventHandlers();
    }
    private void settingLabel(StrategyType strategyType){
        leaderboardView.getNames().setText("");
        leaderboardView.getScores().setText("");
        leaderboard = new Leaderboard(strategyType);
        scores=leaderboard.Sort();
        for(Leaderboard leaderboard:scores)
        {
            leaderboardView.getNames().setText(leaderboardView.getNames().getText()+"\n"+leaderboard.getUserName());
            leaderboardView.getScores().setText(leaderboardView.getScores().getText()+"\n"+leaderboard.getScore());
        }
    }
    private void arcadeScores(){
      settingLabel(StrategyType.ARCADE);
    }
    private void classicScores(){
       settingLabel(StrategyType.CLASSIC);
    }
    private void zenScores(){
        settingLabel(StrategyType.ZEN);
    }
    private void back(){
        navigation.showMainDashboardPage((Stage) leaderboardView.getClassicButton().getScene().getWindow());
    }

    private void setEventHandlers()
    {
        leaderboardView.addArcadeButtonListener(event -> arcadeScores());
        leaderboardView.addClassicButtonListener(event -> classicScores());
        leaderboardView.addZenButtonListener(event -> zenScores());
        leaderboardView.addBackButtonListener(event -> back());
    }
}
