package view;

import control.DataFilter;
import model.CalendarItem;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WeekViewPanel extends JPanel {

    private DefaultTableModel weekTableModel;
    private JTable weekTable;
    private JScrollPane scrollWeekTable;

<<<<<<< HEAD
    //append additional parameters in front of filterType
    public WeekViewPanel(String sFilter, JDatePickerImpl datePicker, ArrayList<CalendarItem> calendarItems) {
        int nYear = datePicker.getModel().getYear();
        int nMonth = datePicker.getModel().getMonth() + 1;
        int nDay = datePicker.getModel().getDay();
        String sDate = nMonth + 1 + "/" + nDay + "/" + nYear;
=======
    public WeekViewPanel(String filterType, JDatePickerImpl datePicker) {
        setLayout(null);
>>>>>>> 72b392dda71a11a47ebd82a76a0fe7b39bf0e9c0

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
        weekTableModel.setColumnIdentifiers(new String[] {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});


        weekTable = new JTable(weekTableModel);
        weekTable.setRowHeight(50);
        weekTable.getTableHeader().setResizingAllowed(false);
        weekTable.getColumn("Time").setPreferredWidth(70);


        new DataFilter().itemsForTheDay(weekTableModel);
        for (int i = 1; i < weekTableModel.getColumnCount(); i++) {
            Date date = null;
            try {
                String sDate2 = String.format("%d-%d-%d", nYear, nMonth, nDay);
                date = new SimpleDateFormat("yyyy-M-d").parse(sDate2);
            }catch (ParseException e){
                e.printStackTrace();
            }
            String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
            insertAll(getMonday(dayChecker(dayOfWeek), nYear, nMonth, nDay)); //Year, Month, Day
//            GregorianCalendar gCalendar = new GregorianCalendar(nYear, nMonth -1, nDay);//nMonth - 1 current month for gregCal const
//            new DataFilter().itemsForTheDay(weekTableModel,calendarItems, sDate, sFilter, i);
        }

        scrollWeekTable = new JScrollPane(weekTable);
        scrollWeekTable.setBounds(new Rectangle(0, 61, 555, 394));
        add(scrollWeekTable);
    }

    private int dayChecker(String sName){
        if(sName.equalsIgnoreCase("Monday"))
            return 0;
        else if(sName.equalsIgnoreCase("Tuesday"))
            return 1;
        else if(sName.equalsIgnoreCase("Wednesday"))
            return 2;
        else if(sName.equalsIgnoreCase("Thursday"))
            return 3;
        else if(sName.equalsIgnoreCase("Friday"))
            return 4;
        else if(sName.equalsIgnoreCase("Saturday"))
            return 5;
        else return 6;
    }

    private int[] getMonday(int nSubtrahend, int nYear, int nMonth, int nDay){
        for (int i = 0; i < nSubtrahend ; nSubtrahend--) {
            if(nDay - 1 == 0)
                if(nMonth - 1 == 0)
                    nYear--;
                else
                    nMonth--;
            else nDay--;
        }
        int[] date = new int[]{nYear, nMonth, nDay};
        return date;
    }

    private void insertAll(int[] arrDate){//arrdate = nYear, nMonth, nDay

    }

    // for controller to add columns/dates to the week table
    public void addTableColumn(String header /* or 2D array */){
        weekTableModel.addColumn(header);
        //weekTableModel.setDataVector(); set the table's contents on the first 2d array param, set the table's column headers on the second array param.
        weekTable.repaint();
    }

}
