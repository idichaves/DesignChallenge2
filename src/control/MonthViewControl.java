package control;

import view.MonthViewPanel;
import model.MonthViewModel;

public class MonthViewControl {

    private MonthViewPanel view;
    private MonthViewModel model;

    public MonthViewControl(MonthViewPanel view){
        this.view = view;
        model = new MonthViewModel();
        view.addDatePicker(model);
    }

    public MonthViewPanel getView(){
        return view;
    }

    public MonthViewModel getModel(){
        return model;
    }
}
