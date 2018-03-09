package model;

import java.util.Properties;

import org.jdatepicker.impl.UtilCalendarModel;

public class MonthViewModel {
    private UtilCalendarModel dateModel;
    private Properties properties;

    public MonthViewModel() {
        dateModel = new UtilCalendarModel();
        properties = new Properties();
        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");
    }

    public UtilCalendarModel getDateModel() {
        return dateModel;
    }

    public Properties getProperties() {
        return properties;
    }
}
