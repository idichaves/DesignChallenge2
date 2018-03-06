import View.MonthCalendarPanel;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

public class Main {
    public static void main(String[] args) {
        JFrame a = new JFrame();

        a.setLocationRelativeTo(null);
        a.setResizable(true);
        a.setLayout(null);
        a.setContentPane(new MonthCalendarPanel());
        a.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        a.add(new MonthCalendarPanel());
        a.setVisible(true);
        a.setSize(new DimensionUIResource(625, 400));
    }
}
