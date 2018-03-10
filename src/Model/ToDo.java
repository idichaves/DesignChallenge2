package model;

public class ToDo extends CalendarItem {
    private boolean accomplished;

    public ToDo(String date, String timeStart, String timeEnd, String name/*, String color */) {
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

        super.setName(name);
        //super.setColor(color);
        accomplished = false;
    }

    public boolean isAccomplished() {
        return accomplished;
    }

    public void setAccomplished(boolean accomplished) {
        this.accomplished = accomplished;
    }
}
