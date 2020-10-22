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
    JButton winButton = new JButton("Vin spelet (Debug)");

    public BrickGame() {
        //Add the panel and newGame button to the window.
        add("Center", panel);
        add("North", newGameButton);
        add("South", winButton);

        //Shuffle the the list of buttons and add them to the panel
        panel.setLayout(new GridLayout(4,4));
        newGame();
        newGameButton.addActionListener(new buttonListener());
        winButton.addActionListener(new buttonListener());

        //Finishing touches
        pack();
        setVisible(true);
        setLocation(500,500);
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

    private void winTheGame() {
        JOptionPane.showMessageDialog(null, "Du vann!");
        System.exit(0);
    }

    private void newGame() {
        randomiseButtons();
        panel.removeAll();
        panel.revalidate();
        for (JButton jButton:buttonList) {
            panel.add(jButton);
            jButton.addActionListener(new buttonListener());
        }
        selectedButton = null;
    }

    private int getEmpty() {
        for (int i = 0; i < buttonList.size(); i++) {
            if (buttonList.get(i).getText().equals("")) {
                return i;
            }
        }
        return -1;
    }

    private void eligibleClick() {

    }

    private void checkWinCondition() {
        for (int i = 0; i < buttonList.size()-1; i++) {
            if (Integer.parseInt(buttonList.get(i).getText()) != (i+1)) {
                return;
            }
        }
        winTheGame();
    }

    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() != newGameButton && ae.getSource() != winButton) {
                System.out.println(((JButton)ae.getSource()).getText());
                checkWinCondition();
                //TODO: Swap location of button
            } else if (ae.getSource() == newGameButton){
                newGame();
            }
            else if (ae.getSource() == winButton) {
                for (int i = 0; i < buttonList.size()-1; i++) {
                    buttonList.get(i).setText(String.valueOf(i+1));
                }
                buttonList.get(15).setText("");
                checkWinCondition();
            }
        }
    }

    public static void main(String[] args) {
        BrickGame b = new BrickGame();
    }
}
