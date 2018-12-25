package Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class to draw the Hangman GUI
public class BoardGui {

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
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Add panel to the frame
        frame.add(gameMenuPanel);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    private JMenuItem newGameItem = new JMenuItem("New Game");
    private JMenuItem exitGameItem = new JMenuItem("Exit Game");

    public static void createGameMenu() {
        JFrame menuWindow = new JFrame("Hangman Game");
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game Options");

        gameMenu.add(newGameItem);
        gameMenu.add(exitGameItem);

        menuBar.add(gameMenu);

        menuWindow.setJMenuBar(menuBar);
        menuWindow.setSize(300, 100);
        menuWindow.setVisible(true);
    }

}
