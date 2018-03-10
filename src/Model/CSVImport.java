package model;
//TODO: MODIFY WRITE
//Last Modified: 03/09/2018 - 11:07PM

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVImport extends FileImport {

    public CSVImport() {
        this.fileName = "EventsToDo.csv";
        calendarItems = new ArrayList<>();
    }

    //format: date, name of event, color
    @Override
    public void readData() {
        // TODO read data from csv file
        try {
            while(!calendarItems.isEmpty())
                calendarItems.remove(0);

            FileReader r = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(r);
            while (bf.ready()) {
                String line;
                line = bf.readLine();
                String[] event = line.split(",");
//                String[] arrDate = event[nDateIndex].split("/");// mm/dd/yyyy format
//                String[] arrStartTime = event[nStartTimeIndex].trim().split(":"); //hh:mm
//                String[] arrEndTime = event[nEndTimeIndex].trim().split(":"); //hh:mm
                String sType = event[nTypeIndex].trim();
                String sName = event[nNameIndex].trim();
                String sColor = event[nColorIndex];
                if(isEvent(sType))
                    calendarItems.add(new Event(event[nDateIndex].trim(), event[nStartTimeIndex].trim(), event[nEndTimeIndex].trim(),
                            sName));
                else if(isToDo(sType))
                    calendarItems.add(new ToDo(event[nDateIndex].trim(), event[nStartTimeIndex].trim(), event[nEndTimeIndex].trim(),
                            sName));
                /******append conditional statements here for additional types of events follow previous examples******/
            }
            bf.close();
            r.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /****   Calendar item type checkers     ****/
    private boolean isEvent(String sType){
        return sType.toLowerCase().contains("event") ||
                sType.toLowerCase().contains("holiday") ||
                sType.toLowerCase().contains("festival");
    }

    private boolean isToDo(String sType){
        return sType.trim().equalsIgnoreCase("todo");
    }
    /**** End of calendar item type checkers ****/

    //Checks if event is holiday
    public boolean isHoliday(String sType){
        return sType.toLowerCase().contains("holiday");
    }

    @Override
    public void writeData(CalendarItem calendarItem) {
        if(calendarItem != null)
            calendarItems.add(calendarItem);

        try {
            FileWriter w = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(w);
            for(int i = 0; i < calendarItems.size(); i++) {
                StringBuilder write = new StringBuilder();
                CalendarItem e = calendarItems.get(i);

                write.append(e.dateToString() + ","); // 1st sep
                write.append(e.getName() + ",");//2nd sep
                /*** TODO: CREATE A METHOD for append so that each instance has its own***/
                if(e instanceof ToDo)
                    write.append("ToDo");
                else //if (e instanceof Event)
                    write.append("Event");
                write.append(","); //3rd sep
                write.append(e.timeStartToString() + ",");//4th sep
                write.append(e.timeEndToString() + ",");//5th sep
                pw.println(write.toString());
            }
            pw.close();
            w.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<CalendarItem> getCalendarItems() {
        readData();
        return super.getCalendarItems();
    }

    /*** Modify if this method will be used ***/
//	public Color findColor(int year, int month, int day, String[] sEvent){
//		Color color = null;
//		String sEvent2 = sEvent[0];
//		for (int i = 0; i < events.size(); i++) {
//			if(events.get(i).getYear() == year && events.get(i).getMonth() == month && events.get(i).getDay() == day && events.get(i).getName().equalsIgnoreCase(sEvent2)) {
//				try {
//					if(events.get(i).getColor().equalsIgnoreCase("black"))
//						sEvent2 = sEvent[sEvent.length - 1];
//					Field field = Class.forName("java.awt.Color").getField(events.get(i).getColor().toLowerCase().trim());
//					color = (Color) field.get(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return color;
//	}
/***                                    ***/



}
