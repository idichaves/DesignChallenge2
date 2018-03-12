package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableCellRender{
//    public void TableRenderer(JTable calendarTable, ){
//        calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new DefaultTableCellRenderer(){
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column){
//                super.getTableCellRendererComponent(table, value, selected, focused, row, column);
//                String[] sEvent;
//                int nDay;
//                Color cColor = null;
//                if(this.getText().contains("-")) {
//                    sEvent = getText().split(" -");
//                    nDay = Integer.parseInt(sEvent[0]);
//                    sEvent = sEvent[1].split(",");
//                    cColor = notifier.getEventColor(year, month + 1, nDay, sEvent);
//                }
//
//                if (column == 0 || column == 6)
//                    setBackground(new Color(220,220,255));
//                else
//                    setBackground(Color.WHITE);
//                setBorder(null);
//                setForeground(Color.black);
//                if(cColor !=null)
//                    setForeground(cColor);
//                return this;
//            }
//        });
//    }
}
