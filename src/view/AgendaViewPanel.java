package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import javax.swing.JTextArea;

import control.AgendaViewControl;
import model.CalendarDataModel;

public class AgendaViewPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextArea agendaTextArea;
    private AgendaViewControl agendaViewControl;

    public AgendaViewPanel(String date, String filterType, CalendarDataModel model) { //ArrayList<CalendarItem> calendarItems
        setLayout(null);

        JLabel lblAgenda = new JLabel("Agenda for " + date);
        lblAgenda.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblAgenda.setBounds(30, 13, 250, 35);
        add(lblAgenda);

        //TODO: Add loop here to check if date in each event matches the data to day then use insert
        agendaTextArea = new JTextArea();
        agendaTextArea.setEditable(false);
        agendaTextArea.setFont(new Font("Century", Font.BOLD, 20));
        agendaTextArea.setBounds(0, 61, 555, 394);
        add(agendaTextArea);

        agendaViewControl = new AgendaViewControl(date, model, this, filterType);
    }

    public void append(String s){
        agendaTextArea.append(s + "\n");
    }

    public void refresh(){
        agendaTextArea.repaint();
        this.repaint();
    }
}