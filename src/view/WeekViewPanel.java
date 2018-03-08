package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class WeekViewPanel extends JPanel {

    public WeekViewPanel() {
        setLayout(null);

        JLabel lblThisWeek = new JLabel("This Week");
        lblThisWeek.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblThisWeek.setBounds(30, 13, 204, 35);
        add(lblThisWeek);

    }
}