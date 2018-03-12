package view;

import model.CalendarItem;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class TableCellRender{
    public void TableRenderer(JTable calendarTable){
        calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new DefaultTableCellRenderer(){
            public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column){
                super.getTableCellRendererComponent(table, value, selected, focused, row, column);
                setForeground(Color.black);
                if (column == 0)
                    setBackground(new Color(220,220,255));
                else if(getText().contains("Task: "))
                    setBackground(Color.decode("#1ad8bc"));
                else if(getText().contains("Event: "))
                    setBackground(Color.decode("#d8791a"));
                
                else
                    setBackground(Color.decode("#a2ada8"));
                setBorder(null);

//                if(cColor !=null)
//                    setForeground(cColor);
                return this;
            }
        });
    }
}
