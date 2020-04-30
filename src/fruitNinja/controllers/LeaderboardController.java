package fruitNinja.controllers;

import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.LeaderboardView;
import javafx.stage.Stage;

/**
 * Created by dc user on 30/04/2020.
 */
public class LeaderboardController {
    LeaderboardView leaderboardView;
    Navigation navigation = new Navigation();
    public LeaderboardController(LeaderboardView leaderboardView) {
        this.leaderboardView=leaderboardView;
        setEventHandlers();
    }
    private void arcadeScores(){

    }
    private void classicScores(){

    }
    private void zenScores(){

    }
    private void back(){
        System.out.println("hii");
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
