package fruitNinja.controllers;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.data.repositories.ScoreRepository;
import fruitNinja.models.logic.GamePlayActions;
import fruitNinja.models.modes.StrategyType;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.pages.GameDoneView;
import javafx.stage.Stage;

public class GameDoneController extends BaseController {

    private StrategyType strategyType;

    private ScoreRepository scoreRepository = new ScoreRepository();

    private GameDoneView gameDoneView;

    public GameDoneController(GameDoneView gameDoneView, StrategyType strategyType)
    {
        this.gameDoneView = gameDoneView;
        this.strategyType = strategyType;
        init();
    }

    private void playAgain() {
        Stage stage = (Stage)gameDoneView.getPlayAgainBtn().getScene().getWindow();
        navigation.showGameChoosePage(stage);
        GamePlayActions.isPaused=-1;
    }

    private void mainMenu() {
        Stage stage;
        stage = (Stage)gameDoneView.getMainMenuBtn().getScene().getWindow();
        navigation.showMainDashboardPage(stage);
        GamePlayActions.isPaused=-1;
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

    private void updateLevel()
    {
        PlayerRepository playerRepository = new PlayerRepository();
        playerRepository.updateLevel();
    }

    private void init()
    {
        setEventHandlers();
        addScore();
        setScoreValue();
        setHighScoreValue();
        updateLevel();
    }

    private void setEventHandlers()
    {
        gameDoneView.addPlayAgainButtonListener(event -> playAgain());
        gameDoneView.addMainMenuButtonListener(event -> mainMenu());
    }


}
