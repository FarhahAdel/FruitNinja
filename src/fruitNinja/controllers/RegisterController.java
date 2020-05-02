package fruitNinja.controllers;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.models.users.Player;
import fruitNinja.models.users.PlayerSingleton;
import fruitNinja.views.guiUtils.Alerts;
import fruitNinja.views.guiUtils.Navigation;
import fruitNinja.views.guiUtils.Validation;
import fruitNinja.views.pages.RegisterView;
import javafx.stage.Stage;

public class RegisterController {

    private Navigation navigation = new Navigation();
    private Alerts alerts = new Alerts();
    private PlayerRepository playerRepository = new PlayerRepository();
    private Validation validations;

    private RegisterView registerView;
    Player player;

    public RegisterController(RegisterView registerView)
    {
        this.registerView = registerView;
        setEventHandlers();
    }


    private boolean validateInput()
    {
        validations = new Validation();
        validations.validateEmptyTextFields(registerView.getFullNameTextField(),registerView.getUsernameTextField(),registerView.getPasswordTextField());
        validations.validateFullNameTextField(registerView.getFullNameTextField());
        validations.validateUsernameTextField(registerView.getUsernameTextField());
        validations.validatePasswordField(registerView.getPasswordTextField());


        return !validations.getFlag();
    }

    private void signUp() {
        if(validateInput()) {
            // TODO: Validations to be made
            String fullName = registerView.getFullNameTextField().getText();
            String username = registerView.getUsernameTextField().getText();
            String password = registerView.getPasswordTextField().getText();
            player=new Player(fullName,username,password);

            PlayerSingleton.setPlayerSingleton(player);

            Stage stage = (Stage) registerView.getSignUpBtn().getScene().getWindow();
            navigation.showMainDashboardPage(stage);
        }


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
