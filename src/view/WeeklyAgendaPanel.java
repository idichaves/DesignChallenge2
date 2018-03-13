package view;

import model.CalendarDataModel;

import javax.swing.*;

public class WeeklyAgendaPanel extends AgendaViewPanel{
    public WeeklyAgendaPanel(String date, String filterType, CalendarDataModel model) {
        super(date, filterType, model);

    }

    @Override
    public void init(String date, String filterType, CalendarDataModel model) {
        super.init(date, filterType, model);
    }
}
