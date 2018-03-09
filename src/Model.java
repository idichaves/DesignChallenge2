import model.*;


import java.util.ArrayList;

public class Model {
    private ArrayList<CalendarItem> calendarItems;
    private MonthViewModel monthViewModel;
    private DateLabelFormatter dateLabelFormatter;
    private ArrayList<FileImport> fileImporters;

    public Model(){
        calendarItems = new ArrayList<>();
        fileImporters = new ArrayList<>();
        dateLabelFormatter = new DateLabelFormatter();
        monthViewModel = new MonthViewModel();
    }

    public ArrayList<CalendarItem> getCalendarItems() {
        return calendarItems;
    }

    public MonthViewModel getMonthViewModel() {
        return monthViewModel;
    }

    public DateLabelFormatter getDateLabelFormatter() {
        return dateLabelFormatter;
    }

    public ArrayList<FileImport> getFileImporters() {
        return fileImporters;
    }
}
