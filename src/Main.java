import model.CalendarDataModel;
import view.CalendarView;

public class Main {
    public static void main(String[] args) {
        //test
        CalendarDataModel model = new CalendarDataModel();
        new CalendarView(model);
    }
}
