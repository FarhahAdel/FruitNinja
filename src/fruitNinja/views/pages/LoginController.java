package fruitNinja.views.pages;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.users.Player;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    public TextField usernameTextField;
    public PasswordField passwordTextField;
    public Button signInBtn;
    public Button signUpBtn;

    private Navigation navigation;
    private Alerts alerts;
    private PlayerRepository playerRepository;

    public LoginController()
    {
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

        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        navigation.showMainDashboardPage(stage);
    }

    public void handleSignUpActionButton(ActionEvent actionEvent) {
        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        navigation.showRegisterPage(stage);
    }
}
