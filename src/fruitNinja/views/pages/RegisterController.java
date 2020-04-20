package fruitNinja.views.pages;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.users.Player;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    public TextField fullNameTextField;
    public TextField usernameTextField;
    public PasswordField passwordTextField;
    public Button signInBtn;
    public Button signUpBtn;

    private Navigation navigation;
    private Alerts alerts;
    private PlayerRepository playerRepository;

    public RegisterController()
    {
        navigation = new Navigation();
        alerts = new Alerts();
        playerRepository = new PlayerRepository();
    }

    public void handleSubmitActionButton(ActionEvent actionEvent) {
        // TODO: Validations to be made

        String fullName = fullNameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        Player player = playerRepository.signUp(fullName, username, password);
        if (player == null) {
            alerts.showErrorAlert("Eligible username", "A User with the same username already exist");
            return;
        }

        Stage stage = (Stage)signUpBtn.getScene().getWindow();
      Navigation.setLoggedInPlayer(player);
        navigation.showMainDashboardPage(stage);
    }

    public void handleSignInActionButton(ActionEvent actionEvent) {
        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        navigation.showLoginPage(stage);
    }
}
