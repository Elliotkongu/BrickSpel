import javax.swing.*;
import java.awt.*;
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
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button10 = new JButton("10");
    JButton button11 = new JButton("11");
    JButton button12 = new JButton("12");
    JButton button13 = new JButton("13");
    JButton button14 = new JButton("14");
    JButton button15 = new JButton("15");
    JButton button16 = new JButton();
    JButton newGame = new JButton("Nytt spel");
    boolean isSelected = false;
    JButton selectedButton;

    public BrickGame() {
        setLayout(new BorderLayout());
        add("North", panel);
        add("South", newGame);
        panel.setLayout(new GridLayout(4,4));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button11);
        panel.add(button12);
        panel.add(button13);
        panel.add(button14);
        panel.add(button15);
        panel.add(button16);

        //Finishing touches
        pack();
        setVisible(true);
        setLocation(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() != newGame && !isSelected) {
                isSelected = true;
                selectedButton = (JButton) ae.getSource();
            } else if (ae.getSource()!= newGame && isSelected) {
                //TODO: Swap the newly clicked button with the old/selected button
            } else if (ae.getSource() == newGame){
                //TODO: Randomise the buttons and clear selectedButton and isSelected when clicking newGame.
            }
        }
    }



    public static void main(String[] args) {
        BrickGame b = new BrickGame();
    }


}
