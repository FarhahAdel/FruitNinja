package fruitNinja.controllers;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.data.repositories.ScoreRepository;
import fruitNinja.models.gameLogic.GamePlayActions;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.GameDoneView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameDoneController {

    private StrategyType strategyType;

    private Navigation navigation = new Navigation();
    private ScoreRepository scoreRepository = new ScoreRepository();
    private PlayerRepository playerRepository = new PlayerRepository();

    private GameDoneView gameDoneView;

    public GameDoneController(GameDoneView gameDoneView, StrategyType strategyType)
    {
        this.gameDoneView = gameDoneView;
        this.strategyType = strategyType;
        setEventHandlers();
        addScore();
        setScoreValue();
        setHighScoreValue();
        playerRepository.updateLevel();
    }

    public void playAgain() {
        Stage stage=(Stage)gameDoneView.getPlayAgainBtn().getScene().getWindow();
        navigation.showGameChoosePage(stage);
        GamePlayActions.isPaused=false;
    }

    public void mainMenu() {
        Stage stage;
        stage = (Stage)gameDoneView.getMainMenuBtn().getScene().getWindow();
        navigation.showMainDashboardPage(stage);
        GamePlayActions.isPaused=false;
    }

    private void addScore()
    {
        scoreRepository.addScore(String.valueOf(PlayerSingleton.getInstance().getCurrentScore()),
                PlayerSingleton.getInstance().getUsername(),strategyType);
    }

    private void setScoreValue() {
        gameDoneView.getScoreValue().setText(String.valueOf(PlayerSingleton.getInstance().getCurrentScore()));
    }

    private void setHighScoreValue()
    {
        ScoreRepository scoreRepository = new ScoreRepository();
        gameDoneView.getHighScoreValue().setText(scoreRepository.getHighScore(strategyType,PlayerSingleton.getInstance().getUsername()));
    }

    public void setEventHandlers()
    {
        gameDoneView.addPlayAgainButtonListener(event -> playAgain());
        gameDoneView.addMainMenuButtonListener(event -> mainMenu());
    }

}
