package model;

public class Event extends CalendarItem {

    private boolean holidayIndicator;

    public Event(String date, String timeStart, String timeEnd, String name, String color, boolean holidayIndicator) {
        String[] dateComps = date.split("/");
        super.setMonth(Integer.parseInt(dateComps[0]));
        super.setDay(Integer.parseInt(dateComps[1]));
        super.setYear(Integer.parseInt(dateComps[2]));

        String[] timeComps = timeStart.split(":");
        super.setHrStart(Integer.parseInt(timeComps[0]));
        super.setMinStart(Integer.parseInt(timeComps[1]));

        String[] timeEndComps = timeEnd.split(":");
        super.setHrEnd(Integer.parseInt(timeEndComps[0]));
        super.setMinEnd(Integer.parseInt(timeEndComps[1]));

        super.setColor(color);
        super.setName(name);
        this.holidayIndicator = holidayIndicator;
    }

    public boolean isHoliday(){
        return holidayIndicator;
    }
}
