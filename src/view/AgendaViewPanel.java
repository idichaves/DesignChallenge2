package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class AgendaViewPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextArea agendaTextArea;

    public AgendaViewPanel() { //ArrayList<CalendarItem> calendarItems
        setLayout(null);

        JLabel lblAgenda = new JLabel("Agenda for Today");
        lblAgenda.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblAgenda.setBounds(30, 13, 204, 35);
        add(lblAgenda);

        //TODO: Add loop here to check if date in each event matches the data to day then use insert
        agendaTextArea = new JTextArea();
        agendaTextArea.setEditable(false);
        agendaTextArea.setFont(new Font("Century", Font.BOLD, 20));
        agendaTextArea.setBounds(0, 61, 555, 394);
        add(agendaTextArea);
    }

    public void append(String s){
        agendaTextArea.append(s);
    }
}