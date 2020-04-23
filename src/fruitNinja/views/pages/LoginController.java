package fruitNinja.views.pages;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.audios.AudioController;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LoginController {
    public TextField usernameTextField;
    public PasswordField passwordTextField;
    public Button signInBtn;
    public Button signUpBtn;

    private Navigation navigation;
    private Alerts alerts;
    private PlayerRepository playerRepository;
    private AudioController audioController;
    public LoginController()
    {
        try {
            settAudio();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        navigation = new Navigation();
        alerts = new Alerts();
        playerRepository = new PlayerRepository();
    }

    public void handleSubmitActionButton(ActionEvent actionEvent) {
        // TODO: Validations to be made

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        Player player = playerRepository.login(username, password);

        if (player == null) {
            alerts.showErrorAlert("Invalid Credentials", "Wrong username or password");
            return;
        }

        PlayerSingleton.setPlayerSingleton(player);

        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        audioController.stop();
        navigation.showMainDashboardPage(stage);

    }

    public void handleSignUpActionButton(ActionEvent actionEvent) {
        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        audioController.stop();
        navigation.showRegisterPage(stage);
    }
    public void settAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioController = new AudioController();
        audioController.start("start");
    }
}
