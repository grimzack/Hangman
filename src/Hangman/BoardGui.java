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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


// Class to draw the Hangman GUI
public class BoardGui extends Application {

    // Hangman Game Instance
    private static GameBoard currentGame;

    // Game Buttons
    Button newGameButton, exitButton;

    // Game Screens
    Scene mainMenu, gameScreen;

    public void start(Stage primaryStage) throws Exception {
        currentGame = new GameBoard();

        primaryStage.setTitle("Hangman Game");

        TextField userInputField = new TextField();

        newGameButton = new Button("New Game");

        exitButton = new Button("Exit");
        exitButton.setOnAction(e -> {
            primaryStage.close();
        });

        StackPane layout = new StackPane();
        HBox menuBox = new HBox();
        
        // Add components to the HBox
        menuBox.getChildren().add(userInputField);
        menuBox.getChildren().add(newGameButton);
        menuBox.getChildren().add(exitButton);

        layout.getChildren().add(menuBox);
        layout.setAlignment(Pos.CENTER);

        mainMenu = new Scene(layout, 600, 300);

        primaryStage.setScene(mainMenu);

        // Now add the game screen
        // This is more complicated because it requires the gamestate gifs...
        // Initial screen will be empty gallow
        VBox gameBox = new VBox();
        ImageView newGameImage = new ImageView(new Image("file:emptyGallow.gif"));
        TextField guessField = new TextField();

        gameBox.getChildren().add(newGameImage);
        gameBox.getChildren().add(guessField);

        StackPane gameBoardLayout = new StackPane();
        gameBoardLayout.getChildren().add(gameBox);

        gameScreen = new Scene(gameBoardLayout, 600, 300);

        newGameButton.setOnAction(e -> {
            String gameString = userInputField.getText();
            currentGame.newGame(gameString);
            primaryStage.setScene(gameScreen);

        });

        primaryStage.show();
    }

}
