package fruitNinja.views.pages;

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

    }

    public void handleSignInActionButton(ActionEvent actionEvent) {
        Stage stage = (Stage)signUpBtn.getScene().getWindow();
        navigation.showLoginPage(stage);
    }
}
