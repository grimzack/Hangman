package Hangman;

import Hangman.GameBoard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            board.PrintOptions();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    String curAnswer = board.getAnswer();
                    if (!(curAnswer.equals(""))) {
                        System.out.println("Answer already exists. Continue and replace? (y\\n\n");
                        char decision = scanner.next().charAt(0);
                        if (decision == 'n') {
                            System.out.println("Not replacing word.\n");
                            break;
                        }
                    }
                    System.out.println("Please supply a word to guess: ");
                    String temp = scanner.next();
                    board.setAnswer(temp);
                    break;
                case 2:
                    System.out.println("Please enter a letter: ");
                    char guess = scanner.next().charAt(0);
                    board.Guess(guess);
                    break;
                case 3:
                    System.out.println("Current state: ");
                    board.printState();
                    break;
                case 4:
                    System.out.println("Thanks for playing!\n");
                    break;

            }
        }
    }
}
