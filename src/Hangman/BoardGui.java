package Hangman;

//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


// Class to draw the Hangman GUI
public class BoardGui extends Application {

    // Constants
    private String NEW_GAME_BUTTON_TEXT = "New Game";
    private String EXIT_BUTTON_TEXT = "Exit";

    private String TITLE_TEXT = "Hangman Game";
    private String NEW_GAME_IMAGE_LOCATION = "src/Resources/emptyGallow.gif";

    // Hangman Game Instance
    private static GameBoard currentGame;

    // Game Buttons
    private Button newGameButton, mainMenuExitButton, gameScreenExitButton;

    // Game Screens
    private Scene mainMenu, gameScreen;

    // Player input field
    private TextField newGameField, inputField;

    // Guess Displays
    private Label lettersGuessed, lettersRevealed;

    // Game StackPanes
    private StackPane mainMenuStackPane, gameScreenStackPane;

    // Player information
    private String gameString, previousGuess, currentGuess;

    public void start(Stage primaryStage) throws Exception {
        currentGame = new GameBoard();
        primaryStage.setTitle(TITLE_TEXT);

        createButtons(primaryStage);

        setUpMainMenu(primaryStage);

        setUpGameScreen();

        primaryStage.show();
    }

        private void handleGuess() {
        // This method's goals:
        //  1. Clear the input field
        inputField.clear();

        //  2. Post the guess to a label

        //  3. Check whether the guess is good
        //  4. Progress the  game state if good or bad guess

    }

    private void setUpMainMenu(Stage stage) {
        StackPane layout = new StackPane();
        VBox menuBox = new VBox();
        newGameField = new TextField();

        // Add components to the HBox
        menuBox.getChildren().add(newGameField);
        menuBox.getChildren().add(newGameButton);
        menuBox.getChildren().add(mainMenuExitButton);

        newGameButton.setOnAction(e -> {
            gameString = newGameField.getText();
            currentGame.newGame(gameString);
            stage.setScene(gameScreen);
        });

        layout.getChildren().add(menuBox);
        layout.setAlignment(Pos.CENTER);

        mainMenu = new Scene(layout, 600, 300);

        stage.setScene(mainMenu);
    }

    private void setUpGameScreen() {
        HBox gameBox = new HBox();
        FileInputStream localFile = null;
        try {
            localFile = new FileInputStream(NEW_GAME_IMAGE_LOCATION);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView newGameImage = new ImageView(new Image(localFile));
        inputField = new TextField();
        inputField.textProperty().addListener(((observable, oldValue, newValue) -> {
            previousGuess = oldValue;
            currentGuess = inputField.getText();
            handleGuess();
        }));

        gameBox.getChildren().add(inputField);
        gameBox.getChildren().add(gameScreenExitButton);

        StackPane gameBoardLayout = new StackPane();
        gameBoardLayout.getChildren().add(gameBox);

        gameBox.getChildren().add(newGameImage);

        gameScreen = new Scene(gameBoardLayout, 600, 300);
    }

    private void createButtons(Stage stage) {
        newGameButton = new Button(NEW_GAME_BUTTON_TEXT);
        gameScreenExitButton = new Button(EXIT_BUTTON_TEXT);
        gameScreenExitButton.setOnAction(e -> stage.close());
        mainMenuExitButton = new Button(EXIT_BUTTON_TEXT);
        mainMenuExitButton.setOnAction(e -> stage.close());

    }
}
