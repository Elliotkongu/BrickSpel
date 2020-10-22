import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    List<JButton> buttonList;

    private List<JButton> randomiseButtons() {
        List<JButton> buttonList = new ArrayList<>();
        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);
        buttonList.add(button10);
        buttonList.add(button11);
        buttonList.add(button12);
        buttonList.add(button13);
        buttonList.add(button14);
        buttonList.add(button15);
        buttonList.add(button16);
        Collections.shuffle(buttonList);
        return buttonList;
    }

    public BrickGame() {
        add("South", panel);
        add("North", newGame);
        buttonList = randomiseButtons();
        panel.setLayout(new GridLayout(4,4));
        for (JButton jButton : buttonList) {
            panel.add(jButton);
        }

        //Finishing touches
        pack();
        setVisible(true);
        setLocation(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        BrickGame b = new BrickGame();
    }
}
