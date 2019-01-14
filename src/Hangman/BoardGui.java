package Hangman;

//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


// Class to draw the Hangman GUI
public class BoardGui extends Application {

    // Hangman Game Instance
    private static GameBoard currentGame;

    // Game Buttons
    Button newGameButton, exitButton;

    // Game Screens
    Scene mainMenu, gameScreen;

    public void BoardGui() {
        currentGame = new GameBoard();
    }

    public void start(Stage primaryStage) throws Exception {
        currentGame = new GameBoard();

        primaryStage.setTitle("Hangman Game");

        TextField userInputField = new TextField();

        newGameButton = new Button("New Game");

        exitButton = new Button("Exit");
        exitButton.setOnAction(e -> {
            System.out.println("Exiting");
            return;
        });

        StackPane layout = new StackPane();
        HBox menuBox = new HBox();
        
        // Add components to the HBox
        menuBox.getChildren().add(userInputField);
        menuBox.getChildren().add(newGameButton);
        menuBox.getChildren().add(exitButton);

        layout.getChildren().add(menuBox);
        layout.setAlignment(Pos.CENTER);

        mainMenu = new Scene(layout, 300, 250);

        primaryStage.setScene(mainMenu);

        newGameButton.setOnAction(e -> {
            String gameString = userInputField.getText();
            currentGame.newGame(gameString);
        });

        primaryStage.show();
    }

}
