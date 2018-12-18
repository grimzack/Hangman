package Hangman;

import java.util.List;

public class GameBoard
{
    // Word to be guessed
    private String answer;

    // Number of guesses
    private int numGuesses;

    // Letters guessed so far
    private List<Character> rightCharsGuessed;
    private List<Character> wrongCharsGuessed;

    GameBoard()
    {
        this.setAnswer("");
        this.numGuesses = 0;
    }

    public void PrintOptions()
    {
        System.out.println("Welcome to Hangman! Please choose one of the following options:\n" +
                "1. New Word\n" +
                "2. Guess Letter\n" +
                "3. Print Board\n" +
                "4. Exit\n");
    }

    public void Guess(Character charGuess) {
        // TODO: Make this smarter.
        boolean isInCorrectGuesses = false;
        boolean isInWrongGuesses = false;

        for (Character letter : rightCharsGuessed) {
            if (letter == charGuess) {
                isInCorrectGuesses = true;
                break;
            }
        }

        if (isInCorrectGuesses) {
            System.out.println("Already guessed, and is in the answer!");
        }

        for (Character letter2 : wrongCharsGuessed) {
            if (letter2 == charGuess) {
                isInWrongGuesses = true;
                break;
            }
        }

        if (isInWrongGuesses)
        {
            System.out.println("Already guessed, wrong answer!");
        }

        if ((!isInCorrectGuesses) && (!isInWrongGuesses))
        {
            // Guessed a new character
            this.numGuesses++;
            if ((Boolean) this.getAnswer().contains(Character.toString(charGuess)))
            {
                rightCharsGuessed.add(charGuess);
            }
            else
            {
                wrongCharsGuessed.add(charGuess);
            }
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
}
