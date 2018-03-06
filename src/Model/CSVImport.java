package Model;
//TODO: MODIFY WRITE


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVImport extends FileImport {

    public CSVImport() {
        this.fileName = "EventsToDo.csv";
        calendarItems = new ArrayList<>();
        readData();
    }
    //format: date, name of event, color
    @Override
    public void readData() {
        // TODO read data from csv file
        try {
            FileReader r = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(r);
            while (bf.ready()) {
                String line;
                line = bf.readLine();
                String[] event = line.split(",");
                String[] arrDate = event[nDateIndex].split("/");// mm/dd/yyyy format
                String[] arrStartTime = event[nStartTimeIndex].trim().split(":"); //hh:mm
                String[] arrEndTime = event[nEndTimeIndex].trim().split(":"); //hh:mm
                String sType = event[nTypeIndex].trim();
                String sName = event[nNameIndex].trim();
                String sColor = event[nColorIndex];
                if(isEvent(sType))
                    calendarItems.add(new Event(Integer.parseInt(arrDate[0]), Integer.parseInt(arrDate[1]), Integer.parseInt(arrDate[3]),
                            Integer.parseInt(arrStartTime[0]), Integer.parseInt(arrStartTime[1]), Integer.parseInt(arrEndTime[0]),
                            Integer.parseInt(arrEndTime[1]), sName, sColor, isHoliday(sType)));
                else if(isToDo(sType))
                    calendarItems.add(new ToDo(Integer.parseInt(arrDate[0]), Integer.parseInt(arrDate[1]), Integer.parseInt(arrDate[3]),
                            Integer.parseInt(arrStartTime[0]), Integer.parseInt(arrStartTime[1]), Integer.parseInt(arrEndTime[0]),
                            Integer.parseInt(arrEndTime[1]), sName, sColor));
                /******append here for additional types of events follow previous examples******/

            }
            bf.close();
            r.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    /****   Calendar item type checkers     ****/
    private boolean isEvent(String sType){
        return sType.trim().equalsIgnoreCase("Event") ||
                sType.equalsIgnoreCase("Holiday");
    }

    private boolean isToDo(String sType){
        return sType.trim().equalsIgnoreCase("todo");
    }
    /**** End of calendar item type checkers ****/



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
                write.append(e.getMonth()+ "/" + e.getDay() + "/" + e.getYear());
                write.append(","); // 1st sep

                write.append(e.getName());
                write.append(","); //2nd sep

                /*** TODO: CREATE A METHOD for append to avoid mess***/
                if(e instanceof ToDo)
                    write.append("ToDo");
                else if (e instanceof Event && ((Event) e).isHoliday())
                    write.append("Holiday");
                else
                    write.append("Event");

                write.append(","); //3rd sep

                write.append(e.getHrStart() + ":" + e.getMinStart());
                write.append(",");//4th sep

                write.append(e.getHrEnd() + ":" + e.getMinEnd());
                write.append(",");//5th sep

                write.append(e.getColor());
                write.append(",");//6th sep final

                pw.println(write.toString());
            }
            pw.close();
            w.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //	public Color findColor(){
//		Color color = null;
//		for (int i = 0; i < ; i++) {
//
//		}
//		return color;
//	}
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

    public boolean isHoliday(String sType){
        return sType.trim().equalsIgnoreCase("Holiday");
    }

}
