package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import model.MonthViewModel;
import model.DateLabelFormatter;
import model.CalendarDataModel;
import control.MonthViewControl;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;

public class MonthViewPanel extends JPanel {

    private JDatePanelImpl monthCalPanel;
    private JDatePickerImpl datePicker;
    private JButton btnAddItem;
    private JRadioButton rdbtnEvent;
    private JRadioButton rdbtnTask;
    private JRadioButton rdbtnDayView;
    private JRadioButton rdbtnWeekView;
    private JRadioButton rdbtnAgendaView;
    private ButtonGroup itemGroup;
    private ButtonGroup viewGroup;
    private MonthViewControl controller;

    public MonthViewPanel(JPanel itemPanel, CalendarDataModel model) {
        setLayout(null);
        controller = new MonthViewControl(this);

        JLabel lblFilterItems = new JLabel("Filter Items");
        lblFilterItems.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblFilterItems.setBounds(20, 194, 97, 25);
        add(lblFilterItems);

        JLabel lblViewType = new JLabel("View Type");
        lblViewType.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblViewType.setBounds(177, 194, 97, 25);
        add(lblViewType);
        setBackground(Color.decode("#2591ba"));
        btnAddItem = new JButton("Add Item");
        btnAddItem.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnAddItem.setBounds(111, 399, 106, 33);
        btnAddItem.setBackground(Color.decode("#2591ba"));
        add(btnAddItem);
        btnAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                itemGroup.clearSelection();
                viewGroup.clearSelection();
                JPanel panel = new AddItemPanel(itemPanel, datePicker, model);
                panel.setBounds(0, 0, 555, 445);

                itemPanel.removeAll();
                itemPanel.add(panel);
                itemPanel.repaint();
            }
        });

        rdbtnEvent = new JRadioButton("Event");
        rdbtnEvent.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnEvent.setBounds(20, 228, 84, 33);
        add(rdbtnEvent);
        rdbtnTask = new JRadioButton("Task");
        rdbtnTask.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnTask.setBounds(20, 275, 84, 33);
        add(rdbtnTask);

        itemGroup = new ButtonGroup();
        itemGroup.add(rdbtnEvent);
        rdbtnEvent.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){

            }
        });
        itemGroup.add(rdbtnTask);
        rdbtnTask.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){

            }
        });


        rdbtnDayView = new JRadioButton("Day View");
        rdbtnDayView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnDayView.setBounds(177, 229, 134, 30);
        add(rdbtnDayView);
        rdbtnDayView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JPanel dayView = new DayViewPanel(datePicker, model.getCalendarItems());
                dayView.setBounds(0, 0, 555, 445);

                itemPanel.removeAll();
                itemPanel.add(dayView);
                itemPanel.repaint();
            }
        });

        rdbtnWeekView = new JRadioButton("Week View");
        rdbtnWeekView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnWeekView.setBounds(177, 264, 134, 30);
        add(rdbtnWeekView);
        rdbtnWeekView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JPanel weekView = new WeekViewPanel();
                weekView.setBounds(0, 0, 555, 445);

                itemPanel.removeAll();
                itemPanel.add(weekView);
                itemPanel.repaint();
            }
        });

        rdbtnAgendaView = new JRadioButton("Agenda View");
        rdbtnAgendaView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnAgendaView.setBounds(177, 299, 134, 30);
        add(rdbtnAgendaView);
        rdbtnAgendaView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JPanel agendaView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText());
                agendaView.setBounds(0, 0, 555, 445);

                itemPanel.removeAll();
                itemPanel.add(agendaView);
                itemPanel.repaint();
            }
        });
        //For Windows Laf, IGNORE
        rdbtnAgendaView.setBackground(Color.decode("#2591ba"));
        rdbtnDayView.setBackground(Color.decode("#2591ba"));
        rdbtnEvent.setBackground(Color.decode("#2591ba"));
        rdbtnTask.setBackground(Color.decode("#2591ba"));
        rdbtnWeekView.setBackground(Color.decode("#2591ba"));

        viewGroup = new ButtonGroup();
        viewGroup.add(rdbtnDayView);
        viewGroup.add(rdbtnWeekView);
        viewGroup.add(rdbtnAgendaView);
//        for (int i = 0; i < datePicker.getComponentCount(); i++) {
//            if(datePicker.getComponent(i) instanceof JButton) {
//                System.out.println(((JButton) datePicker.getComponent(i)).getActionListeners()[0].;;
////                ((JButton)datePicker.getComponent(i)).setVisible(false);
//                break;
//            }
//        }
    }

    public void addDatePicker(MonthViewModel model){
        monthCalPanel = new JDatePanelImpl(model.getDateModel(), model.getProperties());
        datePicker = new JDatePickerImpl(monthCalPanel, new DateLabelFormatter());
        datePicker.setShowYearButtons(true);
        datePicker.setBounds(0, 0, 334, 25);
        add(datePicker);
    }
}
