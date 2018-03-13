package view;

import javax.swing.*;
import java.awt.*;

public class WeekAgendaButtons {
    private JButton button;
    private int x;

    public WeekAgendaButtons(String day){
        button = new JButton(day);
        button.setSize(new Dimension(50, 75));
//        button.setBoun

    }

    public void setX(int x) {
        this.x = x;
    }

    public JButton getButton() {
        return button;
    }

    public int getX() {
        return x;
    }
}
