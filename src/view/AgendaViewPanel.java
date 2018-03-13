package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import control.AgendaViewControl;
import control.DataFilter;
import model.CalendarDataModel;
//import sun.util.resources.CalendarData;

public class AgendaViewPanel extends JPanel {
    private AgendaViewControl agendaViewControl;
    private CalendarDataModel model;
    private ArrayList<JButton> jButtons;
    private JButton jButton1, jButton2, jButton3,
                    jButton4, jButton5, jButton6, jButton7;
    private String date;
    private ArrayList<int[]> arrDates;
    private String filterType;
    private int y;

    public AgendaViewPanel(String sdate, String filterType, CalendarDataModel model) {//ArrayList<CalendarItem> calendarItems
        date = sdate;
        this.filterType = filterType;
        String[] arrSDate = date.split("/");
        init(filterType, model, date);
        createButtons(arrSDate);
    }

    public void init(String filterType, CalendarDataModel model, String date){
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

    public void addEvent(String time, String date, String name, boolean done){
        //add thread checker if current time has already past
        JPanel panel = new JPanel(null);
        panel.setBounds(0, y, 590, 30);

        panel.setBackground(Color.decode("#12bca2"));
        if (!done) {
            JCheckBox checkBox = new JCheckBox(time + " " + name);
            checkBox.setFont(new Font("Rockwell", Font.PLAIN, 20));
            checkBox.setBounds(0, 0, 400, 30);

            add(panel);
            panel.add(checkBox);
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) { //set the task in model to accomplished = true;
                    model.setEventStatus(name, date, checkBox.isSelected());
                    panel.remove(checkBox);
                    JCheckBox box = new JCheckBox(checkBox.getText());
                    box.setBackground(Color.decode("#19aaa2"));
                    box.setFont(new Font("Rockwell", Font.PLAIN, 20));
                    box.setBounds(checkBox.getBounds());
                    box.setSelected(true);
                    box.setEnabled(false);
                    panel.add(box);
                    panel.repaint();
                }
            });
        }
        else{
            JCheckBox checkBox = new JCheckBox(time + " " + name);
            checkBox.setFont(new Font("Rockwell", Font.PLAIN, 20));
            checkBox.setBounds(0, 0, 400, 30);
            checkBox.setSelected(true);
            checkBox.setEnabled(false);
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
                model.removeEvent(name, date);
                remove(panel);
                repaint();
            }
        });
        y+=35;
    }

    public void addTask(String time, String date, String name, boolean accomplished) {
        JPanel panel = new JPanel(null);
        panel.setBounds(0, y, 590, 30);

        panel.setBackground(Color.decode("#12bca2"));
        if (!accomplished) {
            JCheckBox checkBox = new JCheckBox(time + " " + name);
            checkBox.setFont(new Font("Rockwell", Font.PLAIN, 20));
            checkBox.setBounds(0, 0, 400, 30);
            add(panel);
            panel.add(checkBox);
            checkBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) { //set the task in model to accomplished = true;
                    model.setTaskStatus(name, date, checkBox.isSelected());
                    panel.remove(checkBox);
                    JCheckBox box = new JCheckBox("<html><strike>" + checkBox.getText() + "</strike></html>");
                    box.setBackground(Color.decode("#19aaa2"));
                    box.setFont(new Font("Rockwell", Font.PLAIN, 20));
                    box.setBounds(checkBox.getBounds());
                    box.setSelected(true);
                    panel.add(box);
                    panel.repaint();
                }
            });
        } else {
            JCheckBox checkBox = new JCheckBox("<html><strike>" + time + " " + name + "</strike></html>");
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
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                model.removeTask(name, date);
                remove(panel);
                repaint();
            }
        });
    }

    public void createButtons(String[] arrSDate){
        DataFilter d = new DataFilter();
        Date dDate = null;
        try {
            String sDate2 = String.format("%d-%d-%d", Integer.parseInt(arrSDate[2]), Integer.parseInt(arrSDate[0]),
                    Integer.parseInt(arrSDate[1]));
            dDate = new SimpleDateFormat("yyyy-M-d").parse(sDate2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(dDate);

        int[] arrMon = d.getMonday(d.dayChecker(dayOfWeek), Integer.parseInt(arrSDate[2]), Integer.parseInt(arrSDate[0]), Integer.parseInt(arrSDate[1]));
        for (int i = 0; i < 6; i++)
            arrMon = d.incrementArr(arrMon);
        arrDates = d.getArrDates();
        jButton1 = new JButton(String.valueOf(arrDates.get(0)[2]));
        jButton2 = new JButton(String.valueOf(arrDates.get(1)[2]));
        jButton3 = new JButton(String.valueOf(arrDates.get(2)[2]));
        jButton4 = new JButton(String.valueOf(arrDates.get(3)[2]));
        jButton5 = new JButton(String.valueOf(arrDates.get(4)[2]));
        jButton6 = new JButton(String.valueOf(arrDates.get(5)[2]));
        jButton7 = new JButton(String.valueOf(arrDates.get(6)[2]));
        jButtons = new ArrayList<>();
        jButtons.add(jButton1);
        jButtons.add(jButton2);
        jButtons.add(jButton3);
        jButtons.add(jButton4);
        jButtons.add(jButton5);
        jButtons.add(jButton6);
        jButtons.add(jButton7);
        for (int i = 0; i < jButtons.size(); i++) {
            jButtons.get(i).setBounds(315 + (i * 34), 5, 35, 50);
            add(jButtons.get(i));
        }

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify(0, jButton1);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify(1, jButton2);
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify(2, jButton3);
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify(3, jButton4);
            }
        });

        jButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify(4, jButton5);
            }
        });

        jButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify(5, jButton6);
            }
        });

        jButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Modify(6, jButton7);
            }
        });
    }

    public void Modify(int i, JButton jButton){
        date = getDate(i, jButton);
        removeAllComponents(jButton);
        init(filterType, model, date);
        repaint();
    }

    public void removeAllComponents(JButton jButton){
        for (int j = 0; j < getComponents().length; j++)
            for (int i = 0; i < getComponents().length; i++)
               if(!(jButton.getParent().getComponent(i) instanceof JButton)) {
                   jButton1.getParent().remove(jButton1.getParent().getComponent(i));
                    repaint();
               }

    }

    public void addEvent(String time, String name){
        JLabel label = new JLabel(time + " " + name);
        label.setFont(new Font("Rockwell", Font.PLAIN, 20));
        label.setBounds(0, y, 500, 30);
        add(label);
        y+=35;
    }

    public String getDate(int i, JButton jButton){
        String sMonth = String.valueOf(arrDates.get(i)[1]);
        String sYear = String.valueOf(arrDates.get(i)[0]);
        String sDay = jButton.getText();
        if(Integer.parseInt(jButton.getText())<10)
            sDay = "0" + jButton.getText();
        if(arrDates.get(i)[1] < 10)
            sMonth = "0" + sMonth;
        return sMonth + "/" + sDay + "/" +sYear;
    }
}