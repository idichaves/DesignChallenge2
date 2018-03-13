package model;

public abstract class CalendarItem extends AbstractModel {
    protected int month;
    protected int day;
    protected int year;
    protected String name;
    //protected String color;
    protected int hrStart;
    protected int minStart;
    protected int hrEnd;
    protected int minEnd;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHrStart() {
        return hrStart;
    }

    public void setHrStart(int hrStart) {
        this.hrStart = hrStart;
    }

    public int getMinStart() {
        return minStart;
    }

    public void setMinStart(int minStart) {
        this.minStart = minStart;
    }

    public int getHrEnd() {
        return hrEnd;
    }

    public void setHrEnd(int hrEnd) {
        this.hrEnd = hrEnd;
    }

    public int getMinEnd() {
        return minEnd;
    }

    public void setMinEnd(int minEnd) {
        this.minEnd = minEnd;
    }

    public String dateToString() {
        if (month >= 10) {
            if (day >= 10)
                return "" + month + "/" + day + "/" + year;
            else return "" + month + "/" + "0" + day + "/" + year;
        }
        else {
            if (day >= 10)
                return "0" + month + "/" + day + "/" + year;
            else
                return "0" + month + "/" + "0" + day + "/" + year;
        }
    }

    public String timeStartToString() {
        if (hrStart >= 10) {
            if (minStart >= 10)
                return "" + hrStart + ":" + minStart;
            else
                return "" + hrStart + ":0" + minStart;
        }
        else{
            if (minStart >= 10)
                return "0" + hrStart + ":" + minStart;
            else
                return "0" + hrStart + ":0" + minStart;
        }
    }

    public String timeEndToString() {
        if (hrEnd >= 10) {
            if (minEnd >= 10)
                return "" + hrEnd + ":" + minEnd;
            else
                return "" + hrEnd + ":0" + minEnd;
        }
        else{
            if (minEnd >= 10)
                return "0" + hrEnd + ":" + minEnd;
            else
                return "0" + hrEnd + ":0" + minEnd;
        }
    }

    public String durationToString(){
        return timeStartToString() + " - " + timeEndToString();
    }
    /*public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    } */
}