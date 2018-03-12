package control;

import model.CalendarItem;
import model.Event;
import model.ToDo;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DataFilter {

    private ArrayList<Integer> arrDates;

    public  DataFilter(){
        arrDates = new ArrayList<>();
    }

    public void inserTtems(ArrayList<CalendarItem> calendarItems, DefaultTableModel tableModel, String sFilter,int row, int col){
        String sItemToInsert = "";

        for (int i = 0; i < calendarItems.size(); i++) {
            CalendarItem calendarItem = calendarItems.get(i);
            if(isAll(sFilter)) //All instance
                sItemToInsert += getItemType(calendarItem) + calendarItem.getName();
            else if(isEvent(sFilter) && calendarItem instanceof Event) // all event only
                sItemToInsert  += getItemType(calendarItem) + calendarItem.getName();
            else if(isTask(sFilter) && calendarItem instanceof ToDo) // todos only
                sItemToInsert  += getItemType(calendarItem) + calendarItem.getName();

            // there maybe 1 event and 1 todoitem for the day at the same time?
        }
        tableModel.setValueAt(sItemToInsert, row, col);
    }

    private String getItemType(CalendarItem calendarItem){
        if(calendarItem instanceof ToDo)
            return "Task: ";
        return "Event: ";
    }

    private boolean isAll(String sFilter){
        return sFilter.equalsIgnoreCase("all");
    }

    private boolean isEvent(String sFilter){
        return sFilter.equalsIgnoreCase("event");
    }
    private boolean isTask(String sFilter){
        return sFilter.equalsIgnoreCase("task");
    }

    private ArrayList<CalendarItem> findItems(String datePickerDate, ArrayList<CalendarItem> calendarItems, int currentHr, int currentMin) {
        ArrayList<CalendarItem> eventForDay = new ArrayList<>();
        for (int i = 0; i < calendarItems.size(); i++) {
            CalendarItem itm = calendarItems.get(i);
            String itmDate = itm.getMonth() + "/" + itm.getDay() + "/" + itm.getYear();
            if (isItemForToday(itm, currentHr, currentMin, itmDate, datePickerDate))
                eventForDay.add(itm);
        }
        return eventForDay;
    }

    private boolean isItemForToday(CalendarItem itm, int currentHr, int currentMin, String itmDate, String datePickerDate){
        String startTime, endTime, currentTime, tempEnd, tempStart;
        int currentMinStart = currentMin;
        int currentMinEnd = currentMin;
        if(itm.getMinStart() <10)
            startTime = String.valueOf(itm.getHrStart()) + "0" + String.valueOf(itm.getMinStart());
        else {
            if (currentMinStart < itm.getMinStart() && currentHr == itm.getHrStart())
                currentMinStart = 59;
            startTime = String.valueOf(itm.getHrStart()) + String.valueOf(itm.getMinStart());
        }
        if(itm.getMinEnd() <10)
            endTime = String.valueOf(itm.getHrEnd()) + "0" + String.valueOf(itm.getMinEnd());
        else {
            if(currentMinEnd < itm.getMinEnd() && currentHr == itm.getHrEnd())
                currentMinEnd = 0;
            endTime = String.valueOf(itm.getHrEnd()) + String.valueOf(itm.getMinEnd());
        }
        if(currentMin == 0)
            tempEnd = tempStart = currentHr + "0" + currentMin;
        else {
            tempEnd = currentHr + String.valueOf(currentMinEnd);
            tempStart = currentHr + String.valueOf(currentMinStart);
        }

        //else currentTime = String.valueOf(currentHr) + String.valueOf(currentMin);
        return datePickerDate.equalsIgnoreCase(itmDate) &&
                Integer.parseInt(startTime) <= Integer.parseInt(tempStart) &&
                Integer.parseInt(endTime) >= Integer.parseInt(tempEnd);
    }

    public void itemsForTheDay(DefaultTableModel tableModel, ArrayList<CalendarItem> calendarItems, String sDate, String sFilter, int nCol){
        for (int i = 0; i < 24; i++) {
            int hr = i + 1;
            if (hr <= 12) {
                inserTtems(findItems(sDate, calendarItems, i + 1, 0), tableModel, sFilter,i *2, nCol);
                inserTtems(findItems(sDate, calendarItems, i + 1, 30), tableModel,  sFilter,i *2 + 1, nCol);
            } else {
                inserTtems(findItems(sDate, calendarItems, i + 1, 0), tableModel,  sFilter,i *2, nCol);
                inserTtems(findItems(sDate, calendarItems, i + 1, 30), tableModel,  sFilter,i *2 + 1, nCol);
            }
        }
    }

    public void itemsForTheDay(DefaultTableModel tableModel){
        for (int i = 0; i < 24; i++) {
            int hr = i + 1;
            if (hr <= 12) {
                tableModel.setValueAt(hr + ":00AM", i * 2, 0);
                //inserTtems(findItems(datePicker, calendarItems, i + 1, 0), tableModel, sFilter,i *2, 1);
                tableModel.setValueAt(hr + ":30AM", i * 2 + 1, 0);
               // inserTtems(findItems(datePicker, calendarItems, i + 1, 30), tableModel,  sFilter,i *2 + 1, 1);
            } else {
                hr -= 12;
                tableModel.setValueAt(hr + ":00PM", i * 2, 0);
                //inserTtems(findItems(datePicker, calendarItems, i + 1, 0), tableModel,  sFilter,i *2, 1);
                tableModel.setValueAt(hr + ":30PM", i * 2 + 1, 0);
               // inserTtems(findItems(datePicker, calendarItems, i + 1, 30), tableModel,  sFilter,i *2 + 1, 1);
            }
        }
    }
    public int dayChecker(String sName){
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

    public int[] getMonday(int nSubtrahend, int nYear, int nMonth, int nDay){
        for (int i = 0; i < nSubtrahend ; nSubtrahend--) {

            if(nDay - 1 == 0)
                if(nMonth - 1 == 0) {
                    nYear--;
                    nMonth = 12;
                    nDay = new GregorianCalendar(nYear, nMonth - 1, 1).getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
                }
                else {
                    nMonth--;
                    nDay = new GregorianCalendar(nYear, nMonth - 1, 1).getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
                }
            else nDay--;
        }

        int[] date = new int[]{nYear, nMonth, nDay};
        arrDates.add(date[2]);
        return date;
    }

    public int[] insertAll(int[] arrDate, ArrayList<CalendarItem> calendarItems,
                           DefaultTableModel weekTableModel,String sFilter, int nCol){//arrdate = nYear, nMonth, nDay
        String sDate = arrDate[1] + "/" +arrDate[2] + "/" + arrDate[0]; //nMonth, nDay, nyear
        GregorianCalendar gCalendar = new GregorianCalendar(arrDate[0], arrDate[1] - 1, arrDate[2]);
        itemsForTheDay(weekTableModel, calendarItems, sDate, sFilter, nCol);
        int maxDate = gCalendar.getActualMaximum(gCalendar.DAY_OF_MONTH);
        if(arrDate[2] + 1 > maxDate)
            if(arrDate[1] + 1 > 12) {
                arrDate[0]++;
                arrDate[1] = 1;
                arrDate[2] = 1;
            }
            else {
                arrDate[1]++;
                arrDate[2] = 1;
            }
        else arrDate[2]++;
        arrDates.add(arrDate[2]);
        return arrDate;
    }

    public ArrayList<CalendarItem> findItemsWithDate(ArrayList<CalendarItem> calendarItems, String date){
        ArrayList<CalendarItem> items = new ArrayList<>();
        for (int i = 0; i < calendarItems.size(); i++){
            if (calendarItems.get(i).dateToString().equals(date))
                items.add(calendarItems.get(i));
        }

        return items;
    }

    public ArrayList<Integer> getArrDates() {
        return arrDates;
    }
}
