
public class ToDo extends CalendarItem {
    private boolean accomplished;

    public ToDo(int month, int day, int year, int hrStart, int minStart, int hrEnd, int minEnd, String name) {
        super.setMonth(month);
        super.setDay(day);
        super.setYear(year);
        super.setHrStart(hrStart);
        super.setMinStart(minStart);
        super.setHrEnd(hrEnd);
        super.setMinEnd(minEnd);
        super.setName(name);
        accomplished = false;
    }

    public boolean isAccomplished() {
        return accomplished;
    }

    public void setAccomplished(boolean accomplished) {
        this.accomplished = accomplished;
    }
}
