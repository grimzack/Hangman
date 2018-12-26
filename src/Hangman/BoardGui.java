package Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class to draw the Hangman GUI
public class BoardGui {

    // Hangman Game Instance
    private static GameBoard currentGame;

    // Static locations of buttons
    public static final int NEW_GAME_X = 0;
    public static final int NEW_GAME_Y = 0;
    public static final int NEW_GAME_WIDTH = 100;
    public static final int NEW_GAME_HEIGHT = 30;

//    public static final int PRINT_BUTTON_X = NEW_GAME_X + NEW_GAME_WIDTH + 10;
//    public static final int PRINT_BUTTON_Y = NEW_GAME_Y;
//    public static final int PRINT_BUTTON_WIDTH = NEW_GAME_WIDTH;
//    public static final int PRINT_BUTTON_HEIGHT = NEW_GAME_HEIGHT;

    public static final int SUBMIT_X = NEW_GAME_X;// + NEW_GAME_WIDTH + 10;
    public static final int SUBMIT_Y = NEW_GAME_Y + NEW_GAME_HEIGHT + 10;
    public static final int SUBMIT_WIDTH = NEW_GAME_WIDTH;
    public static final int SUBMIT_HEIGHT = NEW_GAME_HEIGHT;

    public static final int EXIT_X = NEW_GAME_X;// + SUBMIT_WIDTH + 10;
    public static final int EXIT_Y = SUBMIT_Y + SUBMIT_HEIGHT + 10;
    public static final int EXIT_WIDTH = NEW_GAME_WIDTH;
    public static final int EXIT_HEIGHT = NEW_GAME_HEIGHT;

    public static void createAndShowGui() {
        // Initialization of game board
        currentGame = new GameBoard();

        // Create and set up the window
        JFrame frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

//        // Icon for JLabel
//        ImageIcon hangmanIcon = new ImageIcon("C:/Users/Admin/Documents/CodePractice/Java/Hangman/emptyGallow.gif");
//
//        // Add a label
//        JLabel label = new JLabel("Hangman Game", hangmanIcon, 0);
//        frame.getContentPane().add(label);

        // Add buttons for each function
        JButton newGameButton = new JButton("New Game");
        newGameButton.setBounds(NEW_GAME_X, NEW_GAME_Y, NEW_GAME_WIDTH, NEW_GAME_HEIGHT);

//        JButton printButton = new JButton("Print Board");
//        printButton.setBounds(PRINT_BUTTON_X, PRINT_BUTTON_Y, PRINT_BUTTON_WIDTH, PRINT_BUTTON_HEIGHT);

        JButton submitButton = new JButton("Submit Guess");
        submitButton.setBounds(SUBMIT_X, SUBMIT_Y, SUBMIT_WIDTH, SUBMIT_HEIGHT);

        JButton exitButton = new JButton("Exit Game");
        exitButton.setBounds(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);

        //  Add event listeners to the buttons
        newGameButton.addActionListener(e -> {
            String userInput = (String) JOptionPane.showInputDialog(frame, "Enter the new word:");
            currentGame.newGame(userInput);
        });

        submitButton.addActionListener(e -> {
            String userInput = (String) JOptionPane.showInputDialog(frame, "Guess a letter:");
            currentGame.guess(userInput);
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Icon for JLabel
        ImageIcon hangmanIcon = new ImageIcon("C:/Users/Admin/Documents/CodePractice/Java/Hangman/emptyGallow.gif");

        // Add a label
        JLabel label = new JLabel("Hangman Game", hangmanIcon, 0);

        // Add a content panel
        JPanel gameMenuPanel = new JPanel();

        // Add components to the panel
        gameMenuPanel.add(label);
        gameMenuPanel.add(newGameButton);
        gameMenuPanel.add(submitButton);
        gameMenuPanel.add(exitButton);

        // Add panel to the frame
        frame.add(gameMenuPanel);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    public static void createGameMenu() {
        JFrame menuWindow = new JFrame("Hangman Game");
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game Options");

        JMenuItem newGameItem = new JMenuItem("New Game");
        JMenuItem exitGameItem = new JMenuItem("Exit Game");

        gameMenu.add(newGameItem);
        gameMenu.add(exitGameItem);

        menuBar.add(gameMenu);

        menuWindow.setJMenuBar(menuBar);
        menuWindow.setSize(300, 100);
        menuWindow.setVisible(true);
    }

}
