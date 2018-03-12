package view;

import control.DataFilter;
import model.CalendarItem;
import org.jdatepicker.impl.JDatePickerImpl;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.threeten.extra.Weeks;
import org.threeten.extra.YearWeek;

import java.time.temporal.WeekFields;
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
        weekTableModel.setColumnIdentifiers(new String[] {"Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"});
        weekTable = new JTable(weekTableModel);
        weekTable.setRowHeight(50);
        weekTable.getTableHeader().setResizingAllowed(false);
        weekTable.getColumn("Time").setPreferredWidth(70);

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

        for (int i = 1; i < weekTableModel.getColumnCount(); i++)
            arrDate = d.insertAll(arrDate, calendarItems, weekTableModel, sFilter, i); //Year, Month, Day
//            GregorianCalendar gCalendar = new GregorianCalendar(nYear, nMonth -1, nDay);//nMonth - 1 current month for gregCal const
//            new DataFilter().itemsForTheDay(weekTableModel,calendarItems, sDate, sFilter, i);

        /**************End of FOR EVENTS*************/

        scrollWeekTable = new JScrollPane(weekTable);
        scrollWeekTable.setBounds(new Rectangle(0, 61, 555, 394));
        add(scrollWeekTable);
    }


}
