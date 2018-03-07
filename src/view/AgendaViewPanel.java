package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AgendaViewPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public AgendaViewPanel() {
        setLayout(null);

        JLabel lblAgenda = new JLabel("Agenda for Today");
        lblAgenda.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblAgenda.setBounds(30, 13, 204, 35);
        add(lblAgenda);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
        scrollPane.setBounds(0, 61, 525, 384);
        add(scrollPane);

    }
}