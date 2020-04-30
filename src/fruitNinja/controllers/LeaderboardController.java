package fruitNinja.controllers;

import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.LeaderboardView;
import javafx.stage.Stage;


public class LeaderboardController {
    private Navigation navigation = new Navigation();

    private LeaderboardView leaderboardView;
    public LeaderboardController(LeaderboardView leaderboardView) {
        this.leaderboardView=leaderboardView;
        setEventHandlers();
    }

    private void arcadeScores() {
        System.out.println("boom");
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
