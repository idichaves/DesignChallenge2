package control;

import view.MonthViewPanel;
import model.CalendarModel;

public class MonthViewControl {

    private MonthViewPanel view;
    private CalendarModel model;

    public MonthViewControl(MonthViewPanel view){
        this.view = view;
        model = new CalendarModel();
        view.addDatePicker(model);
    }

    public MonthViewPanel getView(){
        return view;
    }

    public CalendarModel getModel(){
        return model;
    }
}
