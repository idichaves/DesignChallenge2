package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class MonthViewPanel extends JPanel {

    private JPanel MonthCalPanel;
    private JLabel lblMonth;
    private JLabel lblFilterItems;
    private JLabel lblViewType;
    private JButton btnNext;
    private JButton btnPrev;
    private JButton btnAddItem;
    private JComboBox cmbYear;
    private JRadioButton rdbtnEvent;
    private JRadioButton rdbtnTask;
    private JRadioButton rdbtnDayView;
    private JRadioButton rdbtnWeekView;
    private JRadioButton rdbtnAgendaView;
    private ButtonGroup itemGroup;
    private ButtonGroup viewGroup;

    public MonthViewPanel() {
        setLayout(null);

        lblMonth = new JLabel("Month");
        lblMonth.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblMonth.setBounds(10, 4, 75, 33);
        add(lblMonth);

        lblFilterItems = new JLabel("Filter Items");
        lblFilterItems.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblFilterItems.setBounds(20, 242, 97, 25);
        add(lblFilterItems);

        lblViewType = new JLabel("View Type");
        lblViewType.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblViewType.setBounds(177, 242, 97, 25);
        add(lblViewType);

        btnNext = new JButton(">");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNext.setBounds(291, 5, 41, 33);
        add(btnNext);

        btnPrev = new JButton("<");
        btnPrev.setBounds(252, 5, 41, 33);
        add(btnPrev);

        btnAddItem = new JButton("Add Item");
        btnAddItem.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnAddItem.setBounds(116, 399, 106, 33);
        add(btnAddItem);

        cmbYear = new JComboBox();
        cmbYear.setModel(new DefaultComboBoxModel(new String[] {"Year"}));
        cmbYear.setFont(new Font("Rockwell", Font.PLAIN, 15));
        cmbYear.setBounds(97, 5, 114, 31);
        add(cmbYear);

        MonthCalPanel = new JPanel();
        MonthCalPanel.setBounds(10, 36, 322, 200);
        add(MonthCalPanel);
        MonthCalPanel.setLayout(new GridLayout(0, 7, 0, 0));

        JLabel lblSun = new JLabel("S");
        lblSun.setHorizontalAlignment(SwingConstants.CENTER);
        MonthCalPanel.add(lblSun);

        JLabel lblMon = new JLabel("M");
        lblMon.setHorizontalAlignment(SwingConstants.CENTER);
        MonthCalPanel.add(lblMon);

        JLabel lblTue = new JLabel("T");
        lblTue.setHorizontalAlignment(SwingConstants.CENTER);
        MonthCalPanel.add(lblTue);

        JLabel lblWed = new JLabel("W");
        lblWed.setHorizontalAlignment(SwingConstants.CENTER);
        MonthCalPanel.add(lblWed);

        JLabel lblThurs = new JLabel("TH");
        lblThurs.setHorizontalAlignment(SwingConstants.CENTER);
        MonthCalPanel.add(lblThurs);

        JLabel lblFri = new JLabel("F");
        lblFri.setHorizontalAlignment(SwingConstants.CENTER);
        MonthCalPanel.add(lblFri);

        JLabel lblSat = new JLabel("Sa");
        lblSat.setHorizontalAlignment(SwingConstants.CENTER);
        MonthCalPanel.add(lblSat);

        JButton btnR0C0 = new JButton("");
        MonthCalPanel.add(btnR0C0);

        JButton btnR0C1 = new JButton("");
        MonthCalPanel.add(btnR0C1);

        JButton btnR0C2 = new JButton("");
        MonthCalPanel.add(btnR0C2);

        JButton btnR0C3 = new JButton("");
        MonthCalPanel.add(btnR0C3);

        JButton btnR0C4 = new JButton("");
        MonthCalPanel.add(btnR0C4);

        JButton btnR0C5 = new JButton("");
        MonthCalPanel.add(btnR0C5);

        JButton btnR0C6 = new JButton("");
        MonthCalPanel.add(btnR0C6);

        JButton btnR1C0 = new JButton("");
        MonthCalPanel.add(btnR1C0);

        JButton btnR1C1 = new JButton("");
        MonthCalPanel.add(btnR1C1);

        JButton btnR1C2 = new JButton("");
        MonthCalPanel.add(btnR1C2);

        JButton btnR1C3 = new JButton("");
        MonthCalPanel.add(btnR1C3);

        JButton btnR1C4 = new JButton("");
        MonthCalPanel.add(btnR1C4);

        JButton btnR1C5 = new JButton("");
        MonthCalPanel.add(btnR1C5);

        JButton btnR1C6 = new JButton("");
        MonthCalPanel.add(btnR1C6);

        JButton btnR2C0 = new JButton("");
        MonthCalPanel.add(btnR2C0);

        JButton button_2 = new JButton("");
        MonthCalPanel.add(button_2);

        JButton button_7 = new JButton("");
        MonthCalPanel.add(button_7);

        JButton button_12 = new JButton("");
        MonthCalPanel.add(button_12);

        JButton button_17 = new JButton("");
        MonthCalPanel.add(button_17);

        JButton button_22 = new JButton("");
        MonthCalPanel.add(button_22);

        JButton button_27 = new JButton("");
        MonthCalPanel.add(button_27);

        JButton btnR3C0 = new JButton("");
        MonthCalPanel.add(btnR3C0);

        JButton button_3 = new JButton("");
        MonthCalPanel.add(button_3);

        JButton button_8 = new JButton("");
        MonthCalPanel.add(button_8);

        JButton button_13 = new JButton("");
        MonthCalPanel.add(button_13);

        JButton button_18 = new JButton("");
        MonthCalPanel.add(button_18);

        JButton button_23 = new JButton("");
        MonthCalPanel.add(button_23);

        JButton button_28 = new JButton("");
        MonthCalPanel.add(button_28);

        JButton btnR4C0 = new JButton("");
        MonthCalPanel.add(btnR4C0);

        JButton button_4 = new JButton("");
        MonthCalPanel.add(button_4);

        JButton button_9 = new JButton("");
        MonthCalPanel.add(button_9);

        JButton button_14 = new JButton("");
        MonthCalPanel.add(button_14);

        JButton button_19 = new JButton("");
        MonthCalPanel.add(button_19);

        JButton button_24 = new JButton("");
        MonthCalPanel.add(button_24);

        JButton button_29 = new JButton("");
        MonthCalPanel.add(button_29);

        rdbtnEvent = new JRadioButton("Event");
        rdbtnEvent.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnEvent.setBounds(20, 276, 84, 33);
        add(rdbtnEvent);

        rdbtnTask = new JRadioButton("Task");
        rdbtnTask.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnTask.setBounds(20, 314, 84, 33);
        add(rdbtnTask);

        itemGroup = new ButtonGroup();
        itemGroup.add(rdbtnEvent);
        itemGroup.add(rdbtnTask);

        rdbtnDayView = new JRadioButton("Day View");
        rdbtnDayView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnDayView.setBounds(177, 276, 134, 30);
        add(rdbtnDayView);

        rdbtnWeekView = new JRadioButton("Week View");
        rdbtnWeekView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnWeekView.setBounds(177, 315, 134, 30);
        add(rdbtnWeekView);

        rdbtnAgendaView = new JRadioButton("Agenda View");
        rdbtnAgendaView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnAgendaView.setBounds(177, 350, 134, 30);
        add(rdbtnAgendaView);

        viewGroup = new ButtonGroup();
        viewGroup.add(rdbtnDayView);
        viewGroup.add(rdbtnWeekView);
        viewGroup.add(rdbtnAgendaView);

    }
}
