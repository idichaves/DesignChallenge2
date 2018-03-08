package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Container;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class CalendarView {

    private JFrame mainFrame;
    private Container mainPane;
    private JPanel monthViewPanel;
    private JPanel agendaViewPanel;
    private JPanel contentView;

    public CalendarView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        mainFrame = new JFrame("Productivity Tool");
        mainFrame.getContentPane().setLayout(null);
        mainFrame.setSize(910, 480);

        mainPane = mainFrame.getContentPane();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        contentView = new JPanel();
        contentView.setBounds(338, 0, 555, 445);

        //dayViewPanel = new DayViewPanel();
        //dayViewPanel.setBounds(0, 0, 335, 445);

        //weekViewPanel = new WeekViewPanel();
        //weekViewPanel.setBounds(0, 0, 335, 445);

        agendaViewPanel = new AgendaViewPanel();
        agendaViewPanel.setBounds(0, 0, 335, 445);

        monthViewPanel = new MonthViewPanel(contentView);
        monthViewPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        monthViewPanel.setBounds(0, 0, 335, 445);

        mainPane.add(monthViewPanel);
        mainPane.add(contentView);
        //mainPane.add(dayViewPanel);
        //mainPane.add(weekViewPanel);

        //dayViewPanel.setVisible(false);
        //weekViewPanel.setVisible(false);
        //contentView.setVisible(false);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CalendarView cal = new CalendarView();
    }
}