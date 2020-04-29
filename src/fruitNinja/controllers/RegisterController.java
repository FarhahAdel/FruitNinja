package fruitNinja.controllers;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.pages.RegisterView;
import javafx.stage.Stage;

public class RegisterController {

    private Navigation navigation = new Navigation();
    private Alerts alerts = new Alerts();
    private PlayerRepository playerRepository = new PlayerRepository();

    private RegisterView registerView;

    public RegisterController(RegisterView registerView)
    {
        this.registerView = registerView;
        setEventHandlers();
    }

    private void signUp() {
        // TODO: Validations to be made

        String fullName = registerView.getFullNameTextField().getText();
        String username = registerView.getUsernameTextField().getText();
        String password = registerView.getPasswordTextField().getText();

        Player player = playerRepository.signUp(fullName, username, password);
        if (player == null) {
            alerts.showErrorAlert("Eligible username", "A User with the same username already exist");
            return;
        }

        PlayerSingleton.setPlayerSingleton(player);

        Stage stage = (Stage) registerView.getSignUpBtn().getScene().getWindow();
        navigation.showMainDashboardPage(stage);

    }

    private void login() {
        Stage stage = (Stage) registerView.getSignInBtn().getScene().getWindow();
        navigation.showLoginPage(stage);
    }

    private void setEventHandlers()
    {
        this.registerView.addRegisterButtonListener(actionEvent -> signUp());
        this.registerView.addLoginButtonListener(actionEvent -> login());
    }
}
