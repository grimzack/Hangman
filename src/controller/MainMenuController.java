package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class MainMenuController {
    public Pane rootMainMenuPane;
    public Button newGameButton;

    public TextField clueField;

    public void beginNewGame(ActionEvent actionEvent) {
        URL gameScreenUrl = getClass().getResource("/resources/screens/GameScreen.fxml");
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(gameScreenUrl);

        try {
            Parent currentRoot = loader.load();
            newGameButton.getScene().setRoot(currentRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pane getRoot() {
        return rootMainMenuPane;
    }
}
