package Util;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 * Class to listen for user input.
 *
 * May be adapted in the future to listen for other types
 * of input but for now it's only going to be used to listen
 * for a single character input.
 */
public class InputListener implements DocumentListener {

    @Override
    public void insertUpdate(DocumentEvent e) {
        // Do something with the text that was entered
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // Does nothing
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Does nothing
    }
}
