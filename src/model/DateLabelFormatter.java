package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

    private String datePattern = "MM/dd/yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    @Override
    public Object stringToValue(String text) throws ParseException {
        // TODO Auto-generated method stub
        return dateFormatter.parse(text);
    }

    @Override
    public String valueToString(Object val) throws ParseException {
        // TODO Auto-generated method stub
        if (val != null) {
            Calendar cal = (Calendar) val;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}