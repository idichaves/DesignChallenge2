package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class DayViewPanel extends JPanel {

    public DayViewPanel() {
        setLayout(null);

        JLabel lblToday = new JLabel("Today");
        lblToday.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblToday.setBounds(30, 13, 204, 35);
        add(lblToday);
    }
}
