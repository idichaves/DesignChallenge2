package control;

import model.Event;
import model.ToDo;
import model.CalendarDataModel;

public class AddItemControl {

    private CalendarDataModel model;

    public AddItemControl(CalendarDataModel model){
        this.model = model;
    }

    public void passToModel(String date, String timeStart, String timeEnd, String name, String itemType){
        if (itemType.equalsIgnoreCase("Event")){
            model.addCalendarItem(new Event(date, timeStart, timeEnd, name));
        }
        else {
            model.addCalendarItem(new ToDo(date, timeStart, timeEnd, name));
        }
    }
}
