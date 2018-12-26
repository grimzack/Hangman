package Hangman;

import javax.swing.*;
import java.util.List;

public class GameBoard {

    // Static locations of buttons
    public static final int NEW_GAME_X = 0;
    public static final int NEW_GAME_Y = 0;
    public static final int NEW_GAME_WIDTH = 100;
    public static final int NEW_GAME_HEIGHT = 30;

    public static final int SUBMIT_X = NEW_GAME_X + NEW_GAME_WIDTH + 10;
    public static final int SUBMIT_Y = NEW_GAME_Y;
    public static final int SUBMIT_WIDTH = NEW_GAME_WIDTH;
    public static final int SUBMIT_HEIGHT = NEW_GAME_HEIGHT;

    public static final int EXIT_X = SUBMIT_X + SUBMIT_WIDTH + 10;
    public static final int EXIT_Y = 0;
    public static final int EXIT_WIDTH = NEW_GAME_WIDTH;
    public static final int EXIT_HEIGHT = NEW_GAME_HEIGHT;


    // Word to be guessed
    private String answer;

    // Number of guesses
    private int numGuesses;

    // Letters guessed so far
    private String rightCharsGuessed;
    private String wrongCharsGuessed;

    private boolean isWinner;

    GameBoard() {
        this.setAnswer("");
        this.numGuesses = 0;
        this.rightCharsGuessed = "";
        this.wrongCharsGuessed = "";
        isWinner = false;
    }

    /**
     * newGame method creates a new game of Hangman.
     * Clicking the New Game button will replace the
     * word being guessed, clear all existing guesses
     * and refresh the game board.
     *
     * @param newAnswer String representing the new word to guess.
     */
    public void newGame(String newAnswer) {
        setAnswer(newAnswer);
        clearExistingGame();
    }

    public void clearExistingGame() {
        setRightCharsGuessed("");
        setWrongCharsGuessed("");
        setNumGuesses(0);
    }

    /**
     * Main game method in which the user submits a letter guess and
     * the game checks whether it exists in the current answer being
     * guessed.
     *
     * @param userGuess String indicating what character the user has guessed
     * @return String indicating result of the guess (can be success or fail)
     */
    public String guess(String userGuess) {
        // Things to do:
        //  - Check if guess is valid
        //  - Check if guess is in the answer
        //  - Check if guess is in either of wrong or correct guesses
        //      NOTE: Handling duplicate characters?

        // Check that guess is valid
        if (userGuess.length() > 1 || userGuess.length() == 0) {
            // Invalid guess
            // TODO: Handle exception
            return "Invalid guess";
        }

        // Check if guess has been guessed already
        if (rightCharsGuessed.contains(userGuess) || wrongCharsGuessed.contains(userGuess)) {
            // Character has been guessed already
            return "You've already guessed that letter!";
        }

        if (answer.contains(userGuess)) {
            // TODO: Figure out how to reveal letters
            rightCharsGuessed += userGuess;
        }

        // Guess was valid but incorrect
        incrementNumGuesses();
        return "Oh no! That letter isn't part of the word!";
    }

    // Getters and Setters
    public String getAnswer() {
        return answer;
    }

    // Print out answer string. If correct answer has not been guessed, print '_' character.
    public String getDisplayableAnswerString() {
        String printedAnswerString = "";
        for (int i = 0; i < answer.length() - 1; i++) {
            if (rightCharsGuessed.contains("" + answer.charAt(i))) {
                printedAnswerString += answer.charAt(i);
            } else {
                printedAnswerString += " _ ";
            }
        }

        return printedAnswerString;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getRightCharsGuessed() {
        return rightCharsGuessed;
    }

    public void setRightCharsGuessed(String rightCharsGuessed) {
        this.rightCharsGuessed = rightCharsGuessed;
    }

    public String getWrongCharsGuessed() {
        return wrongCharsGuessed;
    }

    public void setWrongCharsGuessed(String wrongCharsGuessed) {
        this.wrongCharsGuessed = wrongCharsGuessed;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }

    public void incrementNumGuesses() {
        this.numGuesses += 1;
    }

    public static void createAndShowGui() {
        // Create and set up the window
        JFrame frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a label
        JLabel label = new JLabel("Hangman Game");
        frame.getContentPane().add(label);

        // Add a content panel
        JPanel gameMenuPanel = new JPanel();

        // Add buttons for each function
        JButton newGameButton = new JButton("New Game");
        newGameButton.setBounds(NEW_GAME_X, NEW_GAME_Y, NEW_GAME_WIDTH, NEW_GAME_HEIGHT);

        JButton submitButton = new JButton("Submit Guess");
        submitButton.setBounds(SUBMIT_X, SUBMIT_Y, SUBMIT_WIDTH, SUBMIT_HEIGHT);

        JButton exitButton = new JButton("Exit Game");
        exitButton.setBounds(EXIT_X, EXIT_Y, EXIT_WIDTH, EXIT_HEIGHT);

        // Add buttons to the panel
        gameMenuPanel.add(newGameButton);
        gameMenuPanel.add(submitButton);
        gameMenuPanel.add(exitButton);

        //  Add event listeners to the buttons
        newGameButton.addActionListener(e -> {

        });

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
