package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import control.MonthViewControl;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class MonthViewPanel extends JPanel {

    private JLabel lblFilterItems;
    private JLabel lblViewType;
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

    public MonthViewPanel(JPanel itemPanel) {
        setLayout(null);

        lblFilterItems = new JLabel("Filter Items");
        lblFilterItems.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblFilterItems.setBounds(20, 194, 97, 25);
        add(lblFilterItems);

        controller = new MonthViewControl(this);

        lblViewType = new JLabel("View Type");
        lblViewType.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblViewType.setBounds(177, 194, 97, 25);
        add(lblViewType);

        btnAddItem = new JButton("Add Item");
        btnAddItem.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnAddItem.setBounds(111, 399, 106, 33);
        add(btnAddItem);
        btnAddItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JPanel panel = new AddItemPanel(itemPanel);
                panel.setBounds(0, 0, 555, 445);
                itemPanel.removeAll();
                itemPanel.add(panel);
                itemPanel.repaint();
                //addItemPanel.setVisible(true);
            }
        });

        UtilDateModel dateModel = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        monthCalPanel = new JDatePanelImpl(dateModel, p);
        datePicker = new JDatePickerImpl(monthCalPanel, new DateComponentFormatter());
        datePicker.setBounds(0, 0, 334, 25);
        add(datePicker);

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
        itemGroup.add(rdbtnTask);

        rdbtnDayView = new JRadioButton("Day View");
        rdbtnDayView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnDayView.setBounds(177, 229, 134, 30);
        add(rdbtnDayView);
        rdbtnDayView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

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
                //JPanel panel = new WeekViewPanel();
                //panel.setBounds(0, 0, 555, 445);

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
                JPanel agendaView = new AgendaViewPanel();
                agendaView.setBounds(0, 0, 555, 445);
                itemPanel.removeAll();
                itemPanel.add(agendaView);
                itemPanel.repaint();
            }
        });

        viewGroup = new ButtonGroup();
        viewGroup.add(rdbtnDayView);
        viewGroup.add(rdbtnWeekView);
        viewGroup.add(rdbtnAgendaView);
    }
}
