package view;

import model.CalendarItem;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LiveChecker implements Runnable {
    private JCheckBox checkBox;
    private boolean isRunning;
    private JPanel panel;
    private CalendarItem calendarItem;
    public LiveChecker(JPanel panel, JCheckBox checkBox, CalendarItem calendarItem){
        this.checkBox = checkBox;
        this.panel = panel;
        this.calendarItem = calendarItem;
        isRunning = true;
    }

    @Override
    public void run() {
        while(isRunning){
//            System.out.println(getCurrentTime());
            if(isEqualdate("Year", calendarItem.getYear())) {
                if (isEqualdate("month", calendarItem.getMonth())) {
                    if (isEqualdate("day", calendarItem.getDay())) {
                        if (Integer.parseInt(getCurrentTime()) > parseToInt(calendarItem.timeEndToString()))
                            expiredCheckBox();
                    } else if (sSplit(getCurrentDate(), "day") > calendarItem.getDay())
                        expiredCheckBox();
                }
                else if (sSplit(getCurrentDate(), "month") > calendarItem.getMonth())
                    expiredCheckBox();
            }
            else if(sSplit(getCurrentDate(), "year") > calendarItem.getYear())
                expiredCheckBox();
        }
    }

    public boolean isEqualdate(String split, int nDate){
        return sSplit(getCurrentDate(), split) == nDate;
    }

    public String getCurrentTime(){ //military
        return new SimpleDateFormat("HHmm").format(Calendar.getInstance().getTime());
    }

    public String getCurrentDate(){
        return new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
    }

    public Integer sSplit(String sDate, String split){
        String[] arrDate = sDate.split("/");
        if(split.equals("month"))
            return Integer.parseInt(arrDate[0]);
        else if(split.equalsIgnoreCase("day"))
            return Integer.parseInt(arrDate[1]);
        else
            return Integer.parseInt(arrDate[2]);
    }

    public void expiredCheckBox(){
        checkBox.setEnabled(false);
        panel.repaint();
        isRunning = false;
    }

    //make sure string can be parsed  to int
    public Integer parseToInt(String someString){
        String[] arrString = someString.split(":");
        if(someString.contains(":"))
            someString = String.valueOf(arrString[0]) + String.valueOf(arrString[1]);

        return Integer.parseInt(someString);
    }
}
