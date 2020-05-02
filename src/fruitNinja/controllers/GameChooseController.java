package fruitNinja.controllers;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.GameChooseView;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameChooseController extends BaseController {

    private GameChooseView gameChooseView;

    public GameChooseController(GameChooseView gameChooseView)
    {
        this.gameChooseView = gameChooseView;
        setEventHandlers();
        settAudio();
    }

    public void zenMode() {
        audioController.stop();
        navigateToGame(StrategyType.ZEN);
    }

    public void classicMode() {
        audioController.stop();
        navigateToGame(StrategyType.CLASSIC);
    }

    private void arcadeMode() {
        audioController.stop();
        navigateToGame(StrategyType.ARCADE);
    }

    private void exit() {
        audioController.stop();
        navigation.showMainDashboardPage((Stage) gameChooseView.getClassicButton().getScene().getWindow());
    }

    private void navigateToGame(StrategyType strategyType)
    {
        audioController.stop();
        Stage stage = (Stage)gameChooseView.getClassicButton().getScene().getWindow();
        navigation.showGamePage(stage, strategyType);
    }

    private void settAudio() {
        audioController = new AudioController();
        audioController.start("start");
    }

    private void setEventHandlers()
    {
        gameChooseView.addArcadeButtonListener(event -> arcadeMode());
        gameChooseView.addClassicButtonListener(event -> classicMode());
        gameChooseView.addZenButtonListener(event -> zenMode());
        gameChooseView.addExitButtonListener(event -> exit());
    }
}
