package control;

import model.CalendarDataModel;
import model.CalendarItem;
import model.Event;
import model.ToDo;
import view.AgendaViewPanel;
import java.util.ArrayList;
import java.util.Comparator;

public class AgendaViewControl {
    public AgendaViewControl(String date, CalendarDataModel model, AgendaViewPanel panel, String filterType){
        ArrayList<CalendarItem> items = new DataFilter().findItemsWithDate(model.getCalendarItems(), date);
        items = filterItems(items, filterType);
        items = sortItems(items);

        for (int i = 0; i < items.size(); i++){
            if (items.get(i) instanceof Event)
                panel.append(items.get(i).durationToString() + " " + items.get(i).getName());
            else
                panel.append(items.get(i).timeStartToString() + " " + items.get(i).getName());
        }
    }

    private ArrayList<CalendarItem> sortItems(ArrayList<CalendarItem> items){
        items.sort(new Comparator<CalendarItem>() {
        @Override
        public int compare(CalendarItem o1, CalendarItem o2) {
           if (o1.getHrStart() < o2.getHrStart())
               return -1;
           else if (o1.getHrStart() > o2.getHrStart())
               return 1;
           else
               return 0;
           }
        });

        return items;
    }

    private ArrayList<CalendarItem> filterItems(ArrayList<CalendarItem> items, String filterType){
        ArrayList<CalendarItem> filtered = new ArrayList<>();

        if (!filterType.equalsIgnoreCase("All")) {
            for (int i = 0; i < items.size(); i++) {
                if (filterType.equalsIgnoreCase("Event") && items.get(i) instanceof Event)
                    filtered.add(items.get(i));
                else if (filterType.equalsIgnoreCase("Task") && items.get(i) instanceof ToDo)
                    filtered.add(items.get(i));
            }
        }
        else
            filtered = items;

        return filtered;
    }
}
