package Model;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/*
    Note: find Event and find/get Color removed;
    TODO: commented Methods  needs to be modified if the program will require the use of it;
 */
public abstract class FileImport {

    protected String fileName;
    protected List<CalendarItem> calendarItems;
    protected int nDateIndex = 0;
    protected int nNameIndex = 1;
    protected int nTypeIndex = 2;
    protected int nStartTimeIndex = 3;
    protected int nEndTimeIndex = 4;
    protected int nColorIndex = 5;
    public abstract void readData();
    public abstract void writeData(CalendarItem calendarItem);

    public List<CalendarItem> getCalendarItems() {
        return calendarItems;
    }


    /*** Modify if method will be used ***/
//    public ArrayList<ArrayList<String>> findEvent(int year, int month, int day) {
//        //String sEvent = "";
//        while(!events.isEmpty())
//            events.remove(0);
//        readData();
//        ArrayList<ArrayList<String>> sEvents = new ArrayList<>();
//        ArrayList<String> sEvent = new ArrayList<>();
//        ArrayList<String> sHolidays = new ArrayList<>();
//        for(int i = 0; i < events.size(); i++) {
//            if(fileName.toLowerCase().contains("holiday") && events.get(i).getDay() == day && events.get(i).getMonth() == month)
//                sHolidays.add(events.get(i).getName());
//            else if(events.get(i).getDay() == day && events.get(i).getMonth() == month && events.get(i).getYear() == year)
//                sEvent.add(events.get(i).getName());
//        }
//        sEvents.add(sEvent);
//        sEvents.add(sHolidays);
//        return sEvents;
//    }
//
//    public Color findColor(int year, int month, int day, String[] sEvent){
//        Color color = null;
//        String sEvent2 = sEvent[0]; //event name
//        for (int j = 0; j < events.size(); j++) {
//            if(fileName.toLowerCase().contains("holiday") && events.get(j).getMonth() == month && events.get(j).getDay() == day
//                    && events.get(j).getName().equalsIgnoreCase(sEvent2)) {
//                color = getColor(j, color);
//            }else if (events.get(j).getYear() == year && events.get(j).getMonth() == month && events.get(j).getDay() == day
//                    && events.get(j).getName().equalsIgnoreCase(sEvent2)){
//                color = getColor(j, color);
//            }
//        }
//        return color;
//    }
//
//    private Color getColor (int j, Color color){
//        try {
//            //System.out.print("match");
//            //sEvent2 = sEvent[sEvent.length - 1];
////			System.out.println(sEvent2);
////			System.out.println(events.get(j).getColor());
//            Field field = Class.forName("java.awt.Color").getField(events.get(j).getColor().toLowerCase().trim());
//            color = (Color) field.get(null);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return color;
//    }

}