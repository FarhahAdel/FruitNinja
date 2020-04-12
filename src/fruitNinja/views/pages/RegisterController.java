package fruitNinja.views.pages;

import fruitNinja.models.users.User;
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

    private Navigation navigation = new Navigation();

    public void handleSubmitActionButton(ActionEvent actionEvent) {
        // TODO: Call the userRepository to login

        // TODO: Validations to be made

        String fullName = fullNameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        User user = new User(fullName, username, password);

        // TODO: CALL THE USERS REPOSITORY TO SIGN UP
        // The Following happens if login is sucessful

        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        navigation.showMainDashboardPage(stage);
    }

    public void handleSignInActionButton(ActionEvent actionEvent) {
        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        navigation.showLoginPage(stage);
    }
}
