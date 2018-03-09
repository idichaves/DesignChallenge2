package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class CalendarView {

    private JFrame mainFrame;
    private Container mainPane;
    private JPanel monthViewPanel;
    private JPanel contentView;

    public CalendarView() {

//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//
//        }
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        }
//        catch (Exception a) {
//
//        }



        mainFrame = new JFrame("Productivity Tool");
        mainFrame.getContentPane().setLayout(null);
        mainFrame.setSize(910, 480);

        mainPane = mainFrame.getContentPane();
        mainFrame.setUndecorated(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        try  {
//             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//             UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel("napkin.NapkinLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        }
        catch  (Exception e) {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            }catch (Exception ab){}
        }
        mainFrame.setUndecorated(false);
        contentView = new JPanel();
        contentView.setBounds(338, 0, 555, 445);

        monthViewPanel = new MonthViewPanel(contentView);
        monthViewPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
        monthViewPanel.setBounds(0, 0, 335, 445);

        mainPane.add(monthViewPanel);
        mainPane.add(contentView);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CalendarView cal = new CalendarView();
    }
}