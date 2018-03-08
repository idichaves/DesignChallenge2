package model;

public class Event extends CalendarItem {
    private boolean holidayIndicator;

    public Event(String date, int hrStart, int minStart, int hrEnd, int minEnd, String name, String color, boolean holiday) {
        String[] dateComps = date.split("/");
        super.setMonth(Integer.parseInt(dateComps[0]));
        super.setDay(Integer.parseInt(dateComps[1]));
        super.setYear(Integer.parseInt(dateComps[2]));
        super.setHrStart(hrStart);
        super.setMinStart(minStart);
        super.setHrEnd(hrEnd);
        super.setMinEnd(minEnd);
        super.setName(name);
        super.setColor(color);
        holidayIndicator = holiday;
    }

    public boolean isHoliday() {
        return holidayIndicator;
    }

    public void setHoliday(boolean holidayIndicator) {
        this.holidayIndicator = holidayIndicator;
    }
}
