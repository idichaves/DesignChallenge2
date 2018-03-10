import model.*;


import java.util.ArrayList;
//Last Modified: 03/09/2018 - 11:01PM
public class Model {
    private ArrayList<CalendarItem> calendarItems;
    private MonthViewModel monthViewModel;
    private DateLabelFormatter dateLabelFormatter;
    private ArrayList<FileImport> fileImporters;

    public Model(){
        calendarItems = new ArrayList<>();
        fileImporters = new ArrayList<>();
        fileImporters.add(new CSVImport());
        dateLabelFormatter = new DateLabelFormatter();
        monthViewModel = new MonthViewModel();
    }

    //gets content from file
    public ArrayList<CalendarItem> getCalendarItems() {
        for (int i = 0; i < fileImporters.size(); i++) {
           ArrayList<CalendarItem> temp =  fileImporters.get(i).getCalendarItems();
            for (int j = 0; j < temp.size(); j++)
                calendarItems.add(temp.get(j));
        }

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
