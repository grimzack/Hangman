package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

// Class to draw the application GUI
public class HangmanGameApplication extends Application {

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL mainMenuUrl = getClass().getResource("/resources/screens/MainMenu.fxml");

        loader.setLocation(mainMenuUrl);

        Parent mainMenuRoot = loader.load();

        primaryStage.setScene(new Scene(mainMenuRoot));
        primaryStage.show();
    }
}
