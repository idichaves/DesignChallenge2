package view;

import control.DataFilter;
import model.CalendarItem;
import model.ToDo;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DayViewPanel extends JPanel {

    private DefaultTableModel tableModel;
    private JTable dayTable;
    private JScrollPane scrollDayTable;

    public DayViewPanel(JDatePickerImpl datePicker, ArrayList<CalendarItem> calendarItems, String sFilterType) {//
        setLayout(null);
        String date = datePicker.getModel().getMonth() +1 + "/" + datePicker.getModel().getDay() + "/" +datePicker.getModel().getYear();
        JLabel lblToday = new JLabel("Day View: " + date);
        lblToday.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblToday.setBounds(30, 13, 204, 35);
        add(lblToday);
        tableModel = new DefaultTableModel(48, 2) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(new String[]{"Time", "Item"});

        dayTable = new JTable(tableModel);
        dayTable.setRowHeight(50);
        dayTable.getTableHeader().setResizingAllowed(false);
        dayTable.getColumn("Item").setPreferredWidth(500);

        scrollDayTable = new JScrollPane(dayTable);
        scrollDayTable.setBounds(new Rectangle(0, 61, 555, 394));

        new DataFilter().itemsForTheDay(tableModel, calendarItems, date, sFilterType, 1);
        new DataFilter().itemsForTheDay(tableModel);
        new TableCellRender().TableRenderer(dayTable);
        add(scrollDayTable);
    }


}
