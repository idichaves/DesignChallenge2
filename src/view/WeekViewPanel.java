package view;

import control.DataFilter;
import model.CalendarItem;
import org.jdatepicker.impl.JDatePickerImpl;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class WeekViewPanel extends JPanel {

    private DefaultTableModel weekTableModel;
    private JTable weekTable;
    private JScrollPane scrollWeekTable;

    //append additional parameters in front of filterType
    public WeekViewPanel(String sFilter, JDatePickerImpl datePicker, ArrayList<CalendarItem> calendarItems) {

        int nYear = datePicker.getModel().getYear();
        int nMonth = datePicker.getModel().getMonth() + 1;
        int nDay = datePicker.getModel().getDay();
        String sDate = nMonth + "/" + nDay + "/" + nYear;
        JLabel lblThisWeek = new JLabel("Week of " + sDate) ;
        setLayout(null);
        lblThisWeek.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblThisWeek.setBounds(30, 13, 204, 35);
        add(lblThisWeek);
        weekTableModel = new DefaultTableModel(48, 8){
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        setBackground(Color.decode("#19aaa2"));
        weekTable = new JTable(weekTableModel);
        weekTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        weekTable.setRowHeight(50);
        weekTable.getTableHeader().setResizingAllowed(false);


        /******************FOR EVENTS****************/
        Date date = null;
        try {
            String sDate2 = String.format("%d-%d-%d", nYear, nMonth, nDay);
            date = new SimpleDateFormat("yyyy-M-d").parse(sDate2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
        DataFilter d = new DataFilter();
        int[] arrDate = d.getMonday(d.dayChecker(dayOfWeek), nYear, nMonth, nDay);
        d.itemsForTheDay(weekTableModel);

        for (int i = 1; i < 8; i++)
            arrDate = d.insertAll(arrDate, calendarItems, weekTableModel, sFilter, i); //Year, Month, Day
//            GregorianCalendar gCalendar = new GregorianCalendar(nYear, nMonth -1, nDay);//nMonth - 1 current month for gregCal const
//            new DataFilter().itemsForTheDay(weekTableModel,calendarItems, sDate, sFilter, i);
//        weekTable.setDefaultRenderer(weekTable.getColumnClass(0),);
        /**************End of FOR EVENTS*************/

        scrollWeekTable = new JScrollPane(weekTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollWeekTable.setBounds(0, 50, 555, 394);
        ArrayList<int[]> arrDays =  d.getArrDates();
        weekTableModel.setColumnIdentifiers(new String[] {"Time", "Monday (" + arrDays.get(0)[2]  + ")", "Tuesday (" + arrDays.get(1)[2] + ")", "Wednesday ("
                + arrDays.get(2)[2] + ")", "Thursday (" + arrDays.get(3)[2] + ")", "Friday (" + arrDays.get(4)[2] + ")",
                "Saturday (" + arrDays.get(5)[2] + ")", "Sunday (" + arrDays.get(6)[2] + ")"});
        weekTable.getColumn("Time").setPreferredWidth(70);
        weekTable.getColumn("Monday (" + arrDays.get(0)[2] + ")").setPreferredWidth(200);
        weekTable.getColumn("Tuesday (" + arrDays.get(1)[2] + ")").setPreferredWidth(200);
        weekTable.getColumn("Wednesday (" + arrDays.get(2)[2] + ")").setPreferredWidth(200);
        weekTable.getColumn("Thursday (" + arrDays.get(3)[2] + ")").setPreferredWidth(200);
        weekTable.getColumn("Friday (" + arrDays.get(4)[2] + ")").setPreferredWidth(200);
        weekTable.getColumn("Saturday (" + arrDays.get(5)[2] + ")").setPreferredWidth(200);
        weekTable.getColumn("Sunday (" + arrDays.get(6)[2] + ")").setPreferredWidth(200);
        new TableCellRender().TableRenderer(weekTable);
        add(scrollWeekTable);
    }
}
