package view;

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

    public DayViewPanel(JDatePickerImpl datePicker, ArrayList<CalendarItem> calendarItems) {//
        setLayout(null);
//        calendarItems.get(i).get
        JLabel lblToday = new JLabel("Today");
        lblToday.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblToday.setBounds(30, 13, 204, 35);
        add(lblToday);
        tableModel = new DefaultTableModel(48, 2) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        tableModel.setColumnIdentifiers(new String[]{"Time", "Item"});
        for (int i = 0; i < 24; i++) {
            int hr = i + 1;
            if (hr <= 12) {
                tableModel.setValueAt(hr + ":00AM", i * 2, 0);
                inserItems(findItems(datePicker, calendarItems, hr - 1, 0), tableModel, i *2, 1);
                tableModel.setValueAt(hr + ":30AM", i * 2 + 1, 0);
                inserItems(findItems(datePicker, calendarItems, hr - 1, 30), tableModel, i *2 + 1, 1);
            } else {
                hr -= 12;
                tableModel.setValueAt(hr + ":00PM", i * 2, 0);
                inserItems(findItems(datePicker, calendarItems, i - 1, 30), tableModel, i *2, 1);
                tableModel.setValueAt(hr + ":30PM", i * 2 + 1, 0);
                inserItems(findItems(datePicker, calendarItems, i - 1, 30), tableModel, i *2 + 1, 1);
            }
//            System.out.println(calendarItems.size());
        }


        dayTable = new JTable(tableModel);
        dayTable.setRowHeight(50);
        dayTable.getTableHeader().setResizingAllowed(false);
        dayTable.getColumn("Item").setPreferredWidth(500);

        scrollDayTable = new JScrollPane(dayTable);
        scrollDayTable.setBounds(new Rectangle(0, 61, 555, 394));
        add(scrollDayTable);
    }

    private void inserItems(ArrayList<CalendarItem> calendarItems, DefaultTableModel tableModel, int row, int col){
        String sItemToInsert = "";
        String sItemType = "";
//        System.out.println(calendarItems.size());
        for (int i = 0; i < calendarItems.size(); i++) {
            if(calendarItems.get(i) instanceof ToDo)
                sItemType = "Task: ";
            else sItemType = "Event: ";
//            System.out.println(calendarItems.get(i).getName());
            sItemToInsert += sItemType + calendarItems.get(i).getName() + ", "; // there maybe 1 event and 1 todoitem for the day at the same time?
        }
        tableModel.setValueAt(sItemToInsert, row, col);
    }

    private ArrayList<CalendarItem> findItems(JDatePickerImpl datePicker, ArrayList<CalendarItem> calendarItems, int currentHr, int currentMin) {
        ArrayList<CalendarItem> eventForDay = new ArrayList<>();
//        int todoCounter;
        for (int i = 0; i < calendarItems.size(); i++) {
            CalendarItem itm = calendarItems.get(i);
            System.out.println(calendarItems.size());
            String datepickerDate = datePicker.getModel().getMonth()+1 + "/" + datePicker.getModel().getDay() + "/" + datePicker.getModel().getYear();
            String itmDate = itm.getMonth() + "/" + itm.getDay() + "/" + itm.getYear();
//            System.out.println("itmDate: " + itmDate);
//            System.out.println("datePickerDate: " +datepickerDate);
            if (isItemForToday(itm, currentHr, currentMin, itmDate, datepickerDate))
                eventForDay.add(itm);

//            System.out.println(eventForDay.size());
        }
        return eventForDay;
    }

    private boolean isItemForToday(CalendarItem itm, int currentHr, int currentMin, String itmDate, String datePickerDate){
        boolean bMinCheck;

        if(currentMin == 30)
            bMinCheck = itm.getMinEnd() >= currentMin;
        else
            bMinCheck = itm.getMinEnd() <= 30;
        return datePickerDate.equalsIgnoreCase(itmDate) &&
                (itm.getHrStart() == currentHr && currentHr == itm.getHrEnd()) && bMinCheck;
    }

}
