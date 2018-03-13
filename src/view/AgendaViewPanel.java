package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.AgendaViewControl;
import model.CalendarDataModel;
import sun.util.resources.CalendarData;

public class AgendaViewPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private AgendaViewControl agendaViewControl;
    private CalendarDataModel model;
    JButton btnMon, btnTue, btnWed, btnThu, btnFri, btnSat, btnSun;
    private int y;

    public AgendaViewPanel(String date, String filterType, CalendarDataModel model) {//ArrayList<CalendarItem> calendarItems
        init(date, filterType, model);
    }

    public void init(String date, String filterType, CalendarDataModel model){
        setLayout(null);
        this.model = model;
        setBackground(Color.decode("#19aaa2"));
        JLabel lblAgenda = new JLabel("Agenda for " + date);
        lblAgenda.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblAgenda.setBounds(30, 13, 250, 35);
        add(lblAgenda);

        //TODO: Add loop here to check if date in each event matches the data to day then use insert
        y = 57;
        agendaViewControl = new AgendaViewControl(date, model, this, filterType);
    }

    public void addTask(String time, String name, boolean accomplished){
        JPanel panel = new JPanel(null);
        panel.setBounds(0, y, 590, 30);

        if (!accomplished) {
            JCheckBox checkBox = new JCheckBox(time + " " + name);
            checkBox.setFont(new Font("Rockwell", Font.PLAIN, 20));
            checkBox.setBounds(0, 0, 400, 30);
            add(panel);
            panel.add(checkBox);
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) { //set the task in model to accomplished = true;
                    model.setTaskStatus(name, checkBox.isSelected());
                    panel.removeAll();
                    JCheckBox box = new JCheckBox("<html><strike>" + checkBox.getText() + "</strike></html>");
                    box.setFont(new Font("Rockwell", Font.PLAIN, 20));
                    box.setBounds(checkBox.getBounds());
                    box.setSelected(true);
                    panel.add(box);
                    panel.repaint();
                }
            });
        }
        else{
            JCheckBox checkBox = new JCheckBox("<html><strike>" + time + " "+ name + "</strike></html>");
            checkBox.setFont(new Font("Rockwell", Font.PLAIN, 20));
            checkBox.setBounds(0, 0, 400, 30);
            checkBox.setSelected(true);
            add(panel);
            panel.add(checkBox);
        }
        JButton btnRemove = new JButton("Remove");
        btnRemove.setFont(new Font("Rockwell", Font.PLAIN, 20));
        btnRemove.setBounds(400, 0, 120, 30);
        panel.add(btnRemove);
        btnRemove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                model.removeTask(name);
                remove(panel);
                repaint();
            }
        });
        y+=35;
    }

    public void addEvent(String time, String name){
        JLabel label = new JLabel(time + " " + name);
        label.setFont(new Font("Rockwell", Font.PLAIN, 20));
        label.setBounds(0, y, 500, 30);
        add(label);
        y+=35;
    }
}