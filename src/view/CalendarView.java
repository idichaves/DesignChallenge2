package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import model.CalendarDataModel;

public class CalendarView {

    private JFrame mainFrame;
    private Container mainPane;
    private JPanel monthViewPanel;
    private JPanel contentView;

    public CalendarView(CalendarDataModel model) {
        mainFrame = new JFrame("Productivity Tool");
        mainFrame.getContentPane().setLayout(null);
        mainFrame.setSize(893, 465);
        mainFrame.setBackground(Color.decode("#2591ba"));
        mainPane = mainFrame.getContentPane();
        try {
            UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ab) {
            ab.printStackTrace();
        }

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        contentView = new JPanel();
        contentView.setBounds(338, 0, 555, 445);

        monthViewPanel = new MonthViewPanel(contentView, model);
        monthViewPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        monthViewPanel.setBounds(0, 0, 335, 445);

        mainPane.add(monthViewPanel);
        mainPane.add(contentView);

        mainFrame.setVisible(true);
    }
}