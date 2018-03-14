package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    private JRadioButton rdbtnAll;
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
        rdbtnEvent.setBounds(20, 228, 84, 30);
        add(rdbtnEvent);
        rdbtnTask = new JRadioButton("Task");
        rdbtnTask.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnTask.setBounds(20, 264, 84, 30);
        add(rdbtnTask);

        rdbtnAll = new JRadioButton("All");
        rdbtnAll.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnAll.setBounds(20, 299, 84, 30);
        add(rdbtnAll);
        rdbtnAll.setSelected(true);

        itemGroup = new ButtonGroup();
        itemGroup.add(rdbtnEvent);
        rdbtnEvent.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                JPanel eventView = new JPanel();
                if(rdbtnDayView.isSelected()) {
                    eventView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnEvent.getText());

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
                else if (rdbtnWeekView.isSelected()) {
                    eventView = new WeekViewPanel(rdbtnEvent.getText(), datePicker, model.getCalendarItems() );

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
                else if (rdbtnAgendaView.isSelected()) {
                    eventView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnEvent.getText(), model);

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
            }
        });
        itemGroup.add(rdbtnTask);
        rdbtnTask.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                JPanel eventView = new JPanel();

                if(rdbtnDayView.isSelected()) {
                    eventView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnTask.getText());

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
                else if (rdbtnWeekView.isSelected()) {
                    eventView = new WeekViewPanel(rdbtnTask.getText(), datePicker, model.getCalendarItems());

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
                else if (rdbtnAgendaView.isSelected()) {
                    eventView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnTask.getText(), model);

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
            }
        });
        itemGroup.add(rdbtnAll);
        rdbtnAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel eventView = new JPanel();
                if(rdbtnDayView.isSelected()) {
                    eventView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnAll.getText());

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
                else if (rdbtnWeekView.isSelected()) {
                    eventView = new WeekViewPanel(rdbtnAll.getText(), datePicker, model.getCalendarItems());

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
                else if (rdbtnAgendaView.isSelected()) {
                    eventView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnAll.getText(), model);

                    eventView.setBounds(0, 0, 555,445);
                    itemPanel.removeAll();
                    itemPanel.add(eventView);
                    itemPanel.repaint();
                }
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
                JPanel dayView = new JPanel();
                if (rdbtnEvent.isSelected())
                    dayView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnEvent.getText());
                else if (rdbtnTask.isSelected())
                    dayView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnTask.getText());
                else
                    dayView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnAll.getText());

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
                JPanel weekView = new JPanel();
                if (rdbtnEvent.isSelected())
                    weekView = new WeekViewPanel(rdbtnEvent.getText(), datePicker, model.getCalendarItems());
                else if (rdbtnTask.isSelected())
                    weekView = new WeekViewPanel(rdbtnTask.getText(),datePicker, model.getCalendarItems());
                else
                    weekView = new WeekViewPanel(rdbtnAll.getText(), datePicker, model.getCalendarItems());

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
                JPanel agendaView = new JPanel();
                if(rdbtnEvent.isSelected())
                    agendaView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnEvent.getText(), model);
                else if (rdbtnTask.isSelected())
                    agendaView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnTask.getText(), model);
                else
                    agendaView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnAll.getText(), model);

                agendaView.setBounds(0, 0, 555, 445);
                itemPanel.removeAll();
                itemPanel.add(agendaView);
                itemPanel.repaint();
            }
        });

        /*rdbtnWeeklyAgenda = new JRadioButton("Weekly Agenda");
        rdbtnWeeklyAgenda.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnWeeklyAgenda.setBounds(177, 334, 157, 30);
        add(rdbtnWeeklyAgenda);
        rdbtnWeeklyAgenda.addActionListener();*/

        datePicker.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                JPanel contentView = new JPanel();
                if (rdbtnDayView.isSelected()){
                    if (rdbtnEvent.isSelected())
                        contentView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnEvent.getText());
                    else if (rdbtnTask.isSelected())
                        contentView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnTask.getText());
                    else
                        contentView = new DayViewPanel(datePicker, model.getCalendarItems(), rdbtnAll.getText());

                    contentView.setBounds(0, 0, 555, 445);
                    itemPanel.removeAll();
                    itemPanel.add(contentView);
                    itemPanel.repaint();
                }
                else if (rdbtnWeekView.isSelected()){
                    if (rdbtnEvent.isSelected())
                        contentView = new WeekViewPanel(rdbtnEvent.getText(), datePicker, model.getCalendarItems());
                    else if (rdbtnTask.isSelected())
                        contentView = new WeekViewPanel(rdbtnTask.getText(), datePicker, model.getCalendarItems());
                    else
                        contentView = new WeekViewPanel(rdbtnAll.getText(), datePicker, model.getCalendarItems());

                    contentView.setBounds(0, 0, 555, 445);
                    itemPanel.removeAll();
                    itemPanel.add(contentView);
                    itemPanel.repaint();
                }
                else if (rdbtnAgendaView.isSelected()){
                    if (rdbtnEvent.isSelected())
                        contentView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnEvent.getText(), model);
                    else if (rdbtnTask.isSelected())
                        contentView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnTask.getText(), model);
                    else
                        contentView = new AgendaViewPanel(datePicker.getJFormattedTextField().getText(), rdbtnAll.getText(), model);

                    contentView.setBounds(0, 0, 555, 445);
                    itemPanel.removeAll();
                    itemPanel.add(contentView);
                    itemPanel.repaint();
                }
           }
        });

        //For Windows Laf, IGNORE
        rdbtnAgendaView.setBackground(Color.decode("#2591ba"));
        rdbtnDayView.setBackground(Color.decode("#2591ba"));
        rdbtnEvent.setBackground(Color.decode("#2591ba"));
        rdbtnTask.setBackground(Color.decode("#2591ba"));
        rdbtnAll.setBackground(Color.decode("#2591ba"));
        rdbtnWeekView.setBackground(Color.decode("#2591ba"));

        viewGroup = new ButtonGroup();
        viewGroup.add(rdbtnDayView);
        viewGroup.add(rdbtnWeekView);
        viewGroup.add(rdbtnAgendaView);
    }

    public void addDatePicker(MonthViewModel model){
        monthCalPanel = new JDatePanelImpl(model.getDateModel(), model.getProperties());
        datePicker = new JDatePickerImpl(monthCalPanel, new DateLabelFormatter());
        datePicker.setShowYearButtons(true);
        datePicker.setBounds(0, 0, 334, 25);
        datePicker.getModel().setSelected(true);
//        String sZero = "";
//        datePicker.getJFormattedTextField().setText(sDate);
        add(datePicker);
    }
}
