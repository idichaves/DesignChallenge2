package view;

import model.CalendarItem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DayViewPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTable dayTable;
    private JScrollPane scrollDayTable;

    public DayViewPanel() {//ArrayList<CalendarItem> calendarItems
        setLayout(null);

        JLabel lblToday = new JLabel("Today");
        lblToday.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblToday.setBounds(30, 13, 204, 35);
        add(lblToday);
        tableModel = new DefaultTableModel(24, 2){
            int i = 0;
            public boolean isCellEditable(int row, int col){
                return false;
            }

        };
        tableModel.setColumnIdentifiers(new String[] {"Time", "Item"});

        for (int i = 0; i < 24; i++) {
            if(i+1 <= 12)
                tableModel.setValueAt(i + 1 + ":00AM", i,0);
            else
                tableModel.setValueAt(i - 11 + ":00PM", i, 0);
        }

        dayTable = new JTable(tableModel);
        dayTable.setRowHeight(50);
        dayTable.getTableHeader().setResizingAllowed(false);

        scrollDayTable = new JScrollPane(dayTable);
        scrollDayTable.setBounds(new Rectangle(0, 61, 555, 394));
        add(scrollDayTable);
    }
}
