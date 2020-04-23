package fruitNinja.views.pages;

import fruitNinja.models.audios.AudioController;
import fruitNinja.models.gameModes.StrategyType;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.utils.Utils;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dc user on 12/04/2020.
 */
public class MainDashboardController implements Initializable {

    @FXML
    private ProgressBar levelBar;

    @FXML
    private Label levelNum;

    @FXML
    private Label level;

    @FXML
    private Button newGameButton;

    @FXML
    private Button leaderBoardButton;

    @FXML
    private Button backButton;

    @FXML
    private Label playerName;

    private Player player = PlayerSingleton.getInstance();
    private Navigation navigation = new Navigation();
    private Utils utils = new Utils();
    private AudioController audioController= new AudioController();
    @FXML
    void back(ActionEvent event) {
     audioController.stop();
    }

    @FXML
    void leaderBoard(ActionEvent event) {
        audioController.stop();
    }

    @FXML
    void newGame(ActionEvent event) {
        audioController.stop();
        navigation.showGameChoosePage((Stage) backButton.getScene().getWindow());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLevel();
        try {
            settAudio();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void setLevel()
    {
        int levelMaxPoints = utils.calculateExperiencePoints(player.getLevel());
        double percentage = player.getExperience() * 1.0 / levelMaxPoints;
        levelBar.setProgress(percentage);
        level.setText(String.valueOf(player.getLevel()));
        playerName.setText("Player: "+player.getFullName());
    }
    public void settAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioController = new AudioController();
        audioController.start("start");
    }
}
