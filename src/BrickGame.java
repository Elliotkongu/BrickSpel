import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Elliot Åberg Fält
 * Date: 2020-10-22
 * Time: 09:07
 * Project: Inlamningsuppgift 3
 * Copyright: MIT
 */
public class BrickGame extends JFrame {
    JPanel panel = new JPanel();
    JButton newGameButton = new JButton("Nytt spel");
    List<JButton> buttonList;
    JButton selectedButton;
    //For testing purposes
    JButton winButton = new JButton("Sortera rätt (Debug)");

    public BrickGame() {
        //Add the panel and newGame button to the window.
        add("Center", panel);
        add("North", newGameButton);
        add("South", winButton);

        //Shuffle the the list of buttons and add them to the panel
        panel.setLayout(new GridLayout(4, 4));
        newGame();
        newGameButton.addActionListener(new buttonListener());
        winButton.addActionListener(new buttonListener());

        //Finishing touches
        pack();
        setVisible(true);
        setLocation(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Put all buttons into a list and shuffle the list
     */
    private void randomiseButtons() {
        buttonList = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            buttonList.add(new JButton(String.valueOf(i)));
        }
        buttonList.add(new JButton());
        Collections.shuffle(buttonList);
    }

    /**
     * Show a message dialog that you have won the game and then exit
     */
    private void winTheGame() {
        JOptionPane.showMessageDialog(null, "Du vann!");
        System.exit(0);
    }

    /**
     * Randomise all the buttons on the board again.
     */
    private void newGame() {
        randomiseButtons();
        panel.removeAll();
        panel.revalidate();
        for (JButton jButton : buttonList) {
            panel.add(jButton);
            jButton.addActionListener(new buttonListener());
        }
        selectedButton = null;
    }

    /**
     * Searches the button list and returns the index of the empty block
     *
     * @return Index of the empty block
     */
    private int getEmpty() {
        for (int i = 0; i < buttonList.size(); i++) {
            if (buttonList.get(i).getText().equals("")) {
                return i;
            }
        }
        return -1;
    }

    private void eligibleClick(JButton button) {
        int index = buttonList.indexOf(button);
        if (index % 4 != 0) {
            checkEmpty(index - 1, button);
        }

        if (index - 4 >= 0) {
            checkEmpty(index - 4, button);
        }

        if (index % 4 != 3) {
            checkEmpty(index + 1, button);
        }

        if (index + 4 < buttonList.size()) {
            checkEmpty(index + 4, button);
        }
    }

    private void checkEmpty(int checkIndex, JButton button) {
        JButton checkButton = buttonList.get(checkIndex);
        if (checkButton.getText().equals("")) {
            checkButton.setText(button.getText());
            button.setText("");
        }
    }

    /**
     * Checks if the blocks are in the correct order (1-15 with empty being last) and
     * runs the winTheGame method if they are.
     */
    private void checkWinCondition() {
        for (int i = 0; i < buttonList.size() - 1; i++) {
            JButton button = buttonList.get(i);
            if (button.getText().equals("")) {
                return;
            } else if (Integer.parseInt(button.getText()) != (i + 1)) {
                return;
            }
        }
        winTheGame();
    }

    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() != newGameButton && ae.getSource() != winButton) {
                eligibleClick((JButton) ae.getSource());
                checkWinCondition();
            } else if (ae.getSource() == newGameButton) {
                newGame();
            } else if (ae.getSource() == winButton) {
                for (int i = 0; i < buttonList.size() - 1; i++) {
                    buttonList.get(i).setText(String.valueOf(i + 1));
                }
                buttonList.get(15).setText("");
            }
        }
    }

    public static void main(String[] args) {
        BrickGame b = new BrickGame();
    }
}
