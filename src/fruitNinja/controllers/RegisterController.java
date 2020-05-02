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
    private Validation validations=new Validation();

    private RegisterView registerView;

    public RegisterController(RegisterView registerView)
    {
        this.registerView = registerView;
        setEventHandlers();
    }
    Player player;
    private boolean validateInput()
    {
        if(validations.checkFirst(registerView.getFullNameTextField(),registerView.getUsernameTextField(),registerView.getPasswordTextField()))
            if(validations.validateFullNameTextField(registerView.getFullNameTextField()))
                if(validations.validateUsernameTextField(registerView.getUsernameTextField()))
                    return validations.validatePasswordField(registerView.getPasswordTextField());


        return false;
    }
    private void signUp() {
        if(validateInput()) {
            // TODO: Validations to be made
            String fullName = registerView.getFullNameTextField().getText();
            String username = registerView.getUsernameTextField().getText();
            String password = registerView.getPasswordTextField().getText();
            //player = playerRepository.signUp(fullName, username, password);
        player=new Player(fullName,username,password);
        }
        if (player == null) {
            //alerts.showErrorAlert("Eligible username", "A User with the same username already exist");
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
