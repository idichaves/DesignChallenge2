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

        monthViewPanel = new MonthViewPanel();
        monthViewPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        monthViewPanel.setBounds(0, 0, 335, 445);
        mainPane.add(monthViewPanel);

        contentView = new JPanel();
        contentView.setBounds(338, 0, 555, 445);
        mainPane.add(contentView);

        mainPane.remove(contentView);
        contentView.setLayout(null);
        contentView = new AddItemPanel();
        contentView.setBounds(335, 0, 569, 445);
        mainFrame.getContentPane().add(contentView);
        mainFrame.setVisible(true);
    }
}