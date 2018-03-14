package model;
import control.DataFilter;

import java.util.ArrayList;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class CalendarDataModel {

    private ArrayList<CalendarItem> calendarItems;
    private ArrayList<FileImport> fileImporters;

    public CalendarDataModel(){
        calendarItems = new ArrayList<>();
        fileImporters = new ArrayList<>();
        fileImporters.add(new CSVImport());
    }

    //gets content from file
    public ArrayList<CalendarItem> getCalendarItems() {
        calendarItems.clear();
        for (int i = 0; i < fileImporters.size(); i++) {
            ArrayList<CalendarItem> temp =  fileImporters.get(i).getCalendarItems();
            for (int j = 0; j < temp.size(); j++)
                calendarItems.add(temp.get(j));
        }

        return calendarItems;
    }

    public void setTaskStatus(String name, String date, boolean status){
        ArrayList<CalendarItem> items = new DataFilter().findItemsWithDate(getCalendarItems(), date);
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getName().equals(name) && items.get(i) instanceof ToDo) {
                CalendarItem item;
                ((ToDo) items.get(i)).setAccomplished(status);
                item = items.get(i);
                fileImporters.get(fileImporters.size()-1).deleteItem(items.get(i));
                addCalendarItem(item);
            }
        }
    }

    public void setEventStatus(String name, String date, boolean status){
        ArrayList<CalendarItem> items = new DataFilter().findItemsWithDate(getCalendarItems(), date);
        for(int i = 0; i < items.size(); i++){
            if (items.get(i).getName().equals(name) && items.get(i) instanceof Event){
                CalendarItem item;
                ((Event) items.get(i)).setDone(status);
                item = items.get(i);
                fileImporters.get(fileImporters.size()-1).deleteItem(items.get(i));
                addCalendarItem(item);
            }
        }
    }

    public void removeTask(String name, String date){
        ArrayList<CalendarItem> items = new DataFilter().findItemsWithDate(getCalendarItems(), date);
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getName().equals(name) && items.get(i) instanceof ToDo) {
                fileImporters.get(fileImporters.size()-1).deleteItem(items.get(i));
            }
        }
    }

    public void removeEvent(String name, String date){
        ArrayList<CalendarItem> items = new DataFilter().findItemsWithDate(getCalendarItems(), date);
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getName().equals(name) && items.get(i) instanceof Event){
                fileImporters.get(fileImporters.size()-1).deleteItem(items.get(i));
            }
        }
    }

    public ArrayList<FileImport> getFileImporters() {
        return fileImporters;
    }

    //for controller's use
    public void addCalendarItem(CalendarItem item){
        for (int i = 0; i < fileImporters.size(); i++)
            fileImporters.get(i).writeData(item);
    }

    public boolean checkNoOverlap(String date, String timeStart, String timeEnd, String type){
        ArrayList<CalendarItem> items = new DataFilter().findItemsWithDate(getCalendarItems(), date);
        String end = timeEnd;
        boolean noOverlap = true;
        String[] startComps = timeStart.split(":");
        if (type.equalsIgnoreCase("Task")) {
            int nMinStart = Integer.parseInt(startComps[1]);
            int nHrStart = Integer.parseInt(startComps[0]);

            nMinStart += 30;
            if (nMinStart > 59) {
                nMinStart -= 60;
                nHrStart += 1;
            }

            StringBuilder endBuilder = new StringBuilder();
            endBuilder.append(Integer.toString(nHrStart));
            endBuilder.append(":");
            endBuilder.append(Integer.toString(nMinStart));
            end = endBuilder.toString();
        }
        String[] endComps = end.split(":");
        if (Integer.parseInt(endComps[0]) < 24) {
            if (items.size() > 0) {
                for (int i = 0; i < items.size() && noOverlap; i++) {
                    LocalTime localStartA = LocalTime.of(Integer.parseInt(startComps[0]), Integer.parseInt(startComps[1]));
                    LocalTime localEndA = LocalTime.of(Integer.parseInt(endComps[0]), Integer.parseInt(endComps[1]));

                    LocalTime localStartB = LocalTime.of(items.get(i).getHrStart(), items.get(i).getMinStart());
                    LocalTime localEndB = LocalTime.of(items.get(i).getHrEnd(), items.get(i).getMinEnd());

                    if (localStartA.toSecondOfDay() > localEndB.toSecondOfDay()) {
                        if (!localStartA.isAfter(localEndB) && !localStartB.isAfter(localEndA) && !(localStartA.until(localEndB, MINUTES) >= 30)) {
                            noOverlap = false;
                        }
                    } else if (!localStartA.isAfter(localEndB) && !localStartB.isAfter(localEndA) && !(localEndB.until(localStartA, MINUTES) >= 30))
                        noOverlap = false;
                }
            }
        }
        else
            noOverlap = false;

        return noOverlap;
    }
}
