package view;

import control.DataFilter;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WeekViewPanel extends JPanel {

    private DefaultTableModel weekTableModel;
    private JTable weekTable;
    private JScrollPane scrollWeekTable;

    public WeekViewPanel(String filterType, JDatePickerImpl datePicker) {
        setLayout(null);

        JLabel lblThisWeek = new JLabel("Week View");
        lblThisWeek.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblThisWeek.setBounds(30, 13, 204, 35);
        add(lblThisWeek);

        weekTableModel = new DefaultTableModel(48, 8){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        weekTableModel.setColumnIdentifiers(new String[] {"Time", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"});


        weekTable = new JTable(weekTableModel);
        weekTable.setRowHeight(50);
        weekTable.getTableHeader().setResizingAllowed(false);
        weekTable.getColumn("Time").setPreferredWidth(70);


        new DataFilter().itemsForTheDay(weekTableModel);

        scrollWeekTable = new JScrollPane(weekTable);
        scrollWeekTable.setBounds(new Rectangle(0, 61, 555, 394));
        add(scrollWeekTable);
    }

    // for controller to add columns/dates to the week table
    public void addTableColumn(String header /* or 2D array */){
        weekTableModel.addColumn(header);
        //weekTableModel.setDataVector(); set the table's contents on the first 2d array param, set the table's column headers on the second array param.
        weekTable.repaint();
    }

}
