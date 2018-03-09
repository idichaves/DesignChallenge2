package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class WeekViewPanel extends JPanel {

    private DefaultTableModel weekTableModel;
    private JTable weekTable;
    private JScrollPane scrollWeekTable;

    public WeekViewPanel() {
        setLayout(null);

        JLabel lblThisWeek = new JLabel("This Week");
        lblThisWeek.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblThisWeek.setBounds(30, 13, 204, 35);
        add(lblThisWeek);

        weekTableModel = new DefaultTableModel(24, 1){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        weekTableModel.setColumnIdentifiers(new String[] {"Time"});

        weekTable = new JTable(weekTableModel);
        weekTable.setRowHeight(50);
        weekTable.getTableHeader().setResizingAllowed(false);

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
