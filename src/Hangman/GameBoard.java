package Hangman;

import java.util.List;

public class GameBoard
{
    // Word to be guessed
    private String answer;

    // Number of guesses
    private int numGuesses;

    // Letters guessed so far
    private String rightCharsGuessed;
    private String wrongCharsGuessed;

    private boolean isWinner;

    GameBoard()
    {
        this.setAnswer("");
        this.numGuesses = 0;
        this.rightCharsGuessed = "";
        this.wrongCharsGuessed = "";
        isWinner = false;
    }

    public void PrintOptions()
    {
        System.out.println("Welcome to Hangman! Please choose one of the following options:\n" +
                "1. New Word\n" +
                "2. Guess Letter\n" +
                "3. Print Board\n" +
                "4. Exit\n");
    }

    // Method to handle a user guess. Returns 'true' if the guess is valid.
    // TODO: Make this smarter.
    public boolean Guess(Character charGuess) {

        // Check if guess has been guessed already
        if (this.rightCharsGuessed.contains(charGuess.toString()) ||
            this.wrongCharsGuessed.contains(charGuess.toString())) {
            System.out.println("Character already guessed!");
            return false;
        }

        if (this.answer.contains(charGuess.toString())) {
            // TODO: Reveal some of the answer
            rightCharsGuessed += charGuess.toString();
            if (rightCharsGuessed.equals(answer)) {
                this.isWinner = true;
                this.ProcessGameOver();
                return true;
            }
            return true;
        } else {
            this.wrongCharsGuessed += charGuess.toString();
            return true;
        }

    }

    public void printState()
    {
        System.out.println("Answer: " + getAnswer() + "\n" +
                            "Number of Guesses: " + numGuesses + "\n" +
                            "Letters guessed (right: wrong): " + rightCharsGuessed + ": " + wrongCharsGuessed);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private void ProcessGameOver() {
        System.out.println("Game over! You " + (this.isWinner ? "Won!" : "Lost :("));
    }
}
