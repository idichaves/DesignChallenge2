package control;

import model.CalendarItem;
import model.Event;
import model.ToDo;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class DataFilter {

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

    public ArrayList<CalendarItem> findItems(JDatePickerImpl datePicker, ArrayList<CalendarItem> calendarItems, int currentHr, int currentMin) {
        ArrayList<CalendarItem> eventForDay = new ArrayList<>();
        for (int i = 0; i < calendarItems.size(); i++) {
            CalendarItem itm = calendarItems.get(i);
            String datePickerDate = datePicker.getModel().getMonth()+1 + "/" +
                    datePicker.getModel().getDay() + "/" + datePicker.getModel().getYear();
            String itmDate = itm.getMonth() + "/" + itm.getDay() + "/" + itm.getYear();
            if (isItemForToday(itm, currentHr, currentMin, itmDate, datePickerDate))
                eventForDay.add(itm);
        }
        return eventForDay;
    }

    public boolean isItemForToday(CalendarItem itm, int currentHr, int currentMin, String itmDate, String datePickerDate){
        boolean bMinCheck;
        if((currentHr == itm.getHrEnd() || currentHr == itm.getHrStart()) && currentMin == 30)
            bMinCheck = itm.getMinEnd() >= currentMin || itm.getMinStart() >= currentMin;
        else if((currentHr == itm.getHrEnd() || currentHr == itm.getHrStart()) && currentMin == 0)
            bMinCheck = itm.getMinStart() <= 30 || itm.getMinEnd() <= 30;
        else bMinCheck = true;
        return datePickerDate.equalsIgnoreCase(itmDate) &&
                (currentHr >= itm.getHrStart() && currentHr <= itm.getHrEnd()) && bMinCheck;
    }

    public void itemsForTheDay(DefaultTableModel tableModel, ArrayList<CalendarItem> calendarItems, JDatePickerImpl datePicker, String sFilter){
        for (int i = 0; i < 24; i++) {
            int hr = i + 1;
            if (hr <= 12) {
                tableModel.setValueAt(hr + ":00AM", i * 2, 0);
                inserTtems(findItems(datePicker, calendarItems, i + 1, 0), tableModel, sFilter,i *2, 1);
                tableModel.setValueAt(hr + ":30AM", i * 2 + 1, 0);
                inserTtems(findItems(datePicker, calendarItems, i + 1, 30), tableModel,  sFilter,i *2 + 1, 1);
            } else {
                hr -= 12;
                tableModel.setValueAt(hr + ":00PM", i * 2, 0);
                inserTtems(findItems(datePicker, calendarItems, i + 1, 0), tableModel,  sFilter,i *2, 1);
                tableModel.setValueAt(hr + ":30PM", i * 2 + 1, 0);
                inserTtems(findItems(datePicker, calendarItems, i + 1, 30), tableModel,  sFilter,i *2 + 1, 1);
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

    public ArrayList<CalendarItem> findItemsWithDate(ArrayList<CalendarItem> calendarItems, String date){
        ArrayList<CalendarItem> items = new ArrayList<>();
        for (int i = 0; i < calendarItems.size(); i++){
            if (calendarItems.get(i).dateToString().equals(date))
                items.add(calendarItems.get(i));
        }

        return items;
    }
}
