package fruitNinja.controllers;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.MainDashboardView;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MainDashboardController {
    private Player player = PlayerSingleton.getInstance();
    private Navigation navigation = new Navigation();
    private Utils utils = new Utils();
    private AudioController audioController= new AudioController();

    private MainDashboardView mainDashboardView;

    public MainDashboardController(MainDashboardView mainDashboardView)
    {
        this.mainDashboardView = mainDashboardView;
        setEventHandlers();
        setLevel();
        setAudio();
    }


    private void back() {
        audioController.stop();
        Stage stage = (Stage) mainDashboardView.getBackButton().getScene().getWindow();
        navigation.showLoginPage(stage);
    }

    private void leaderBoard() {
        audioController.stop();
        Stage stage = (Stage) mainDashboardView.getBackButton().getScene().getWindow();
        navigation.showLeaderboardPage(stage);
    }

    private void newGame() {
        audioController.stop();
        Stage stage = (Stage) mainDashboardView.getBackButton().getScene().getWindow();
        navigation.showGameChoosePage(stage);
    }

    private void setLevel()
    {
        int levelMaxPoints = utils.calculateExperiencePoints(player.getLevel());
        double percentage = player.getExperience() * 1.0 / levelMaxPoints;
        mainDashboardView.getLevelBar().setProgress(percentage);
        mainDashboardView.getLevel().setText(String.valueOf(player.getLevel()));
        mainDashboardView.getPlayerName().setText("Player: " + player.getFullName());
    }

    private void setAudio() {
        audioController = new AudioController();
        audioController.start("start");
    }

    private void setEventHandlers()
    {
        this.mainDashboardView.addNewGameButtonListener(actionEvent -> newGame());
        this.mainDashboardView.addLeaderBoardButtonListener(actionEvent -> leaderBoard());
        this.mainDashboardView.addBackButtonListener(actionEvent -> back());
    }
}
