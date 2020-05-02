package fruitNinja.views.guiUtils;

import fruitNinja.data.repositories.PlayerRepository;
import fruitNinja.data.services.PlayerService;
import fruitNinja.models.users.Player;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.xml.bind.JAXBException;
import java.awt.*;

public class Validation {
    PlayerService playerService = new PlayerService();


    public  boolean isStringOnlyAlphabet(String str) {
        return ((str != null)
                ||(str.matches("\\S+"))
                && (str.matches("^[a-zA-Z]*$")));
    }


    public boolean allowedPassword(String password) {
        boolean valid = true;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if ((password.length() > 15 || password.length() < 8)) {
            valid = false;
        }
        if (!password.matches(upperCaseChars) && !password.matches(lowerCaseChars) && !password.matches(numbers) && !password.matches(specialChars))
            valid = false;

        return valid;
    }

    public Validation() {
    }

    private Alerts alerts = new Alerts();

    public boolean validateEmptyTextField(TextField textField) {
        String text = textField.getText();
        if (text.equals("")) {
            alerts.showErrorAlert("Missing Field", "You must enter data in the text fields");
            return false;
        }

        return true;
    }


    public boolean validateUsernameTextField(TextField textField) {

        String username = textField.getText();
        for (Player player:playerService.readData()){
            if(player.getUsername().equalsIgnoreCase(username)){
                alerts.showErrorAlert("Invalid Username","Username already exits");
                return false;
            }
        }
//        if (username.contains(" ") || username.length() > 20 || username.length() < 5) {
//            alerts.showErrorAlert("Invalid Username",
//                    "Username should not contain spaces and should be between 5 and 20 chars");
//            return false;
//        }

        return true;
    }

    public boolean validateFullNameTextField(TextField textField) {
        String fullName = textField.getText().toLowerCase();
        return isStringOnlyAlphabet(fullName);

//        String[] numOfWords = fullName.split(" ");
//        if (numOfWords.length == 1) {
//            alerts.showErrorAlert("Invalid Full Name", "please user your full name for ex \"John Smith\"");
//            return false;
//        }
//
//        for (int i = 0; i < fullName.length(); i++)
//        {
//            char c = fullName.charAt(i);
//            if (!((c >= 'a' && c <= 'z') || c == ' '))
//            {
//                alerts.showErrorAlert("Invalid Full Name",  "Please use only alphabetical letters and spaces");
//                return false;
//            }
//        }

//        return true;
    }
    public boolean checkFirst(TextField fullName,TextField username,PasswordField passwordField){
        return validateEmptyTextField(fullName)&&validateEmptyTextField(username)&&validateEmptyTextField(passwordField);
    }

    public boolean validatePasswordField(PasswordField passwordField) {

          if( allowedPassword(passwordField.getText()))
              return true;
          else {
            alerts.showErrorAlert("error in pass","please enter pass between 8 and 15");
            return false;
          }
    }

    public boolean isLongPassword(String password) {
        if (password.length() < 6) {
            alerts.showErrorAlert("Weak Password", "Please choose a password which is at least 6 chars long");
            return false;
        }
        return true;
    }
}
