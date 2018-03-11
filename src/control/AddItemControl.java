package control;

import model.Event;
import model.ToDo;
import model.CalendarDataModel;

public class AddItemControl {

    //private CalendarDataModel model;

    /*public AddItemControl(CalendarDataModel model){
        this.model = model;
    }*/

    public void passToModel(CalendarDataModel model, String date, String timeStart, String timeEnd, String name, String itemType){
        if (itemType.equalsIgnoreCase("Event")){
            model.addCalendarItem(new Event(date, timeStart, timeEnd, name));
        }
        else { //ADD TIME END SETTING ALGORITHM HERE
            String[] startComps = timeStart.split(":");
            int nMinStart = Integer.parseInt(startComps[1]);
            int nHrStart = Integer.parseInt(startComps[0]);

            nMinStart += 30;
            if (nMinStart > 59){
                nMinStart -= 60;
                nHrStart += 1;
            }

            StringBuilder endBuilder = new StringBuilder();
            endBuilder.append(Integer.toString(nHrStart));
            endBuilder.append(":");
            endBuilder.append(Integer.toString(nMinStart));
            timeEnd = endBuilder.toString();

            model.addCalendarItem(new ToDo(date, timeStart, timeEnd, name));
        }
    }

    public boolean checkNoOverlap(CalendarDataModel model, String date, String timeStart, String timeEnd, String type){
        return model.checkNoOverlap(date, timeStart, timeEnd, type);
    }
}
