
public class Event extends CalendarItem {
    private boolean holidayIndicator;

    public Event(int month, int day, int year, int hrStart, int minStart, int hrEnd, int minEnd, String name, boolean holiday) {
        super.setMonth(month);
        super.setDay(day);
        super.setYear(year);
        super.setHrStart(hrStart);
        super.setMinStart(minStart);
        super.setHrEnd(hrEnd);
        super.setMinEnd(minEnd);
        super.setName(name);
        holidayIndicator = holiday;
    }

    public boolean isHoliday() {
        return holidayIndicator;
    }

    public void setHoliday(boolean holidayIndicator) {
        this.holidayIndicator = holidayIndicator;
    }
}
