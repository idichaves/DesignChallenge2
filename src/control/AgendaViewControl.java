package control;

import model.CalendarDataModel;
import model.CalendarItem;
import view.AgendaViewPanel;
import java.util.ArrayList;
import java.util.Comparator;

public class AgendaViewControl {
    public AgendaViewControl(String date, CalendarDataModel model, AgendaViewPanel panel){
        ArrayList<CalendarItem> items = new DataFilter().findItemsWithDate(model.getCalendarItems(), date);
        items = sortItems(items);

        for (int i = 0; i < items.size(); i++){
            panel.append(items.get(i).durationToString() + " " + items.get(i).getName());
        }
    }

    private ArrayList<CalendarItem> sortItems(ArrayList<CalendarItem> items){
//        int i = 0;
//        boolean sorted = false;
//        while (!sorted && i < items.size() && items.size() > 1){
//            if (items.get(i).getHrStart() < items.get(i+1).getHrStart())
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
        //}

        return items;
    }
}
