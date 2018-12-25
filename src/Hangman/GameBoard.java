package Hangman;

import java.util.List;

public class GameBoard {

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
        //TODO: Clear existing clue and guess lists and prompt for a new word.
        setAnswer(newAnswer);
        clearExistingGame();
    }

    public void clearExistingGame() {
        setRightCharsGuessed("");
        setWrongCharsGuessed("");
        setNumGuesses(0);
    }

    // Getters and Setters
    public String getAnswer() {
        return answer;
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
}
