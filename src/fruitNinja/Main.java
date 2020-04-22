package fruitNinja;

import fruitNinja.models.audios.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Application {
    AudioController audioController = new AudioController();
    @Override
    public void start(Stage primaryStage) throws Exception{
        settAudio();
        Parent root = FXMLLoader.load(getClass().getResource("views/pages/LoginPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    public void settAudio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioController.start("start");
    }
    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Font font = Font.loadFont(Main.class.getResourceAsStream("./views/fonts/go3v2.ttf"), 14);
        launch(args);
    }
}
