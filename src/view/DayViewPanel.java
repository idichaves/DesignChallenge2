package view;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;

public class DayViewPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTable dayTable;
    private JScrollPane scrollDayTable;

    public DayViewPanel(JDatePickerImpl datePicker) {//ArrayList<CalendarItem> calendarItems
        setLayout(null);

        JLabel lblToday = new JLabel("Today");
        lblToday.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblToday.setBounds(30, 13, 204, 35);
        add(lblToday);
        tableModel = new DefaultTableModel(48, 2){
            int i = 0;
            public boolean isCellEditable(int row, int col){
                return false;
            }

        };
        tableModel.setColumnIdentifiers(new String[] {"Time", "Item"});
<<<<<<< HEAD
<<<<<<< HEAD
            for (int i = 0; i < 24; i++) {
                int hr = i + 1;
                if(hr <= 12) {
                    tableModel.setValueAt(hr + ":00AM", i * 2, 0);
                    tableModel.setValueAt(hr + ":30AM", i *2 + 1 , 0);
                }
                else {
                hr -=12;
                    tableModel.setValueAt(hr+ ":00PM", i * 2, 0);
                    tableModel.setValueAt(hr+ ":30PM", i *2 + 1,0);
                }
            }



=======
=======
>>>>>>> 95ac90dae8816729f99509cf4efa3a233f35c535
        
        for (int i = 0; i < 24; i++) {
            if(i+1 <= 12)
                tableModel.setValueAt(i + 1 + ":00AM", i,0);
            else
                tableModel.setValueAt(i - 11 + ":00PM", i, 0);
        }
>>>>>>> 95ac90dae8816729f99509cf4efa3a233f35c535

        dayTable = new JTable(tableModel);
        dayTable.setRowHeight(50);
        dayTable.getTableHeader().setResizingAllowed(false);
        dayTable.getColumn("Item").setPreferredWidth(500);

        scrollDayTable = new JScrollPane(dayTable);
        scrollDayTable.setBounds(new Rectangle(0, 61, 555, 394));
        add(scrollDayTable);
    }
}
