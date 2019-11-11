package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class GameScreenController  {
    public Pane rootGameScreenPane;
    public Button returnToMenuButton;

    public void returnToMenu(ActionEvent actionEvent) {
        URL gameScreenUrl = getClass().getResource("/resources/screens/MainMenu.fxml");
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(gameScreenUrl);

        try {
            Parent currentRoot = loader.load();
            returnToMenuButton.getScene().setRoot(currentRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Parent getRoot() {
        return rootGameScreenPane;
    }
}
