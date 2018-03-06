package View;

import sun.rmi.server.InactiveGroupException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class MonthCalendarPanel extends JPanel {

    private JLabel lblMonth;
    private JRadioButton tglbtnDayView;
    private JRadioButton tglbtnWeekView;
    private JRadioButton tglbtnMonthView;
    private JRadioButton rdbtnEventsOnly;
    private JRadioButton rdbtnToDoOnly;
    private ButtonGroup itemBtnContainer;
    private ButtonGroup viewBtnContainer;
    private JLabel lblFilterItems;
    private JComboBox cmbYear;
    private JLabel lblYear;
    private List year;

    public MonthCalendarPanel() {
        setLayout(null);
        initComponents(); //InitGuiComponents
    }


    /*
    Place Gui below
     */
    public void initComponents(){
       year =  IntStream.range(Integer.parseInt(Year.now().toString())- 100,
                Integer.parseInt(Year.now().toString()) + 100).boxed().collect(Collectors.toList());
        lblMonth = new JLabel("MONTH");
        lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
        lblMonth.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblMonth.setBounds(245, 0, 145, 36);
        add(lblMonth);
        itemBtnContainer = new ButtonGroup();

        rdbtnEventsOnly = new JRadioButton("Events");
        rdbtnEventsOnly.setFont(new Font("Rockwell", Font.PLAIN, 15));
        rdbtnToDoOnly = new JRadioButton("Task");
        rdbtnToDoOnly.setFont(new Font("Rockwell", Font.PLAIN, 15));

        rdbtnEventsOnly.setBounds(20, 76, 127, 25);
        rdbtnToDoOnly.setBounds(20, 106, 127, 25);

        itemBtnContainer.add(rdbtnEventsOnly);
        itemBtnContainer.add(rdbtnToDoOnly);

        add(rdbtnEventsOnly);
        add(rdbtnToDoOnly);

        viewBtnContainer = new ButtonGroup();

        tglbtnDayView = new JRadioButton("Day View");
        tglbtnDayView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        tglbtnDayView.setBounds(492, 46, 127, 25);
        viewBtnContainer.add(tglbtnDayView);

        tglbtnWeekView = new JRadioButton("Week View");
        tglbtnWeekView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        tglbtnWeekView.setBounds(492, 76, 127, 25);
        viewBtnContainer.add(tglbtnWeekView);

        tglbtnMonthView = new JRadioButton("Month View");
        tglbtnMonthView.setFont(new Font("Rockwell", Font.PLAIN, 15));
        tglbtnMonthView.setBounds(492, 106, 127, 25);
        viewBtnContainer.add(tglbtnMonthView);

        add(tglbtnDayView);
        add(tglbtnWeekView);
        add(tglbtnMonthView);

        lblFilterItems = new JLabel("Filter Items:");
        lblFilterItems.setFont(new Font("Rockwell", Font.PLAIN, 15));
        lblFilterItems.setBounds(20, 46, 103, 21);
        add(lblFilterItems);

        cmbYear = new JComboBox(year.toArray());
        cmbYear.setFont(new Font("Rockwell", Font.PLAIN, 15));
        cmbYear.setBounds(245, 95, 145, 36);
        cmbYear.setSelectedItem(Integer.parseInt(Year.now().toString()));
        add(cmbYear);

        lblYear = new JLabel("YEAR");
        lblYear.setHorizontalAlignment(SwingConstants.CENTER);
        lblYear.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblYear.setBounds(288, 49, 56, 33);
        add(lblYear);
    }

    private void initActionsListener(){
        cmbYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}