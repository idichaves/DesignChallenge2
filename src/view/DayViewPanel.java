package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;

public class DayViewPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTable dayTable;
    private JScrollPane scrollDayTable;

    public DayViewPanel() {
        setLayout(null);

        JLabel lblToday = new JLabel("Today");
        lblToday.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblToday.setBounds(30, 13, 204, 35);
        add(lblToday);

        tableModel = new DefaultTableModel(24, 2){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        tableModel.setColumnIdentifiers(new String[] {"Time", "Item"});

        dayTable = new JTable(tableModel);
        dayTable.setRowHeight(50);
        dayTable.getTableHeader().setResizingAllowed(false);

        scrollDayTable = new JScrollPane(dayTable);
        scrollDayTable.setBounds(new Rectangle(0, 61, 555, 394));
        add(scrollDayTable);
    }
}
