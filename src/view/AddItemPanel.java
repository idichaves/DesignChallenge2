package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;

import model.CalendarDataModel;
import org.jdatepicker.impl.JDatePickerImpl;
import control.AddItemControl;

public class AddItemPanel extends JPanel {

    private JTextField nameTxtField;
    private JTextField dateTxtField;
    private JTextField timeStarttxtField;
    private JTextField timeEndTxtField;
    private JRadioButton rdbtnEvent;
    private JRadioButton rdbtnTask;
    private ButtonGroup itemTypeGroup;
    private JButton btnAdd;
    private JButton btnCancel;
    private JButton btnClear;
    private AddItemControl addItemController;

    public AddItemPanel(JPanel itemPanel, JDatePickerImpl datePicker, CalendarDataModel model) {
        setLayout(null);

        addItemController = new AddItemControl(model);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Rockwell", Font.PLAIN, 16));
        lblName.setBounds(30, 75, 89, 27);
        add(lblName);

        nameTxtField = new JTextField();
        nameTxtField.setFont(new Font("Rockwell", Font.PLAIN, 15));
        nameTxtField.setBounds(131, 74, 370, 29);
        add(nameTxtField);


        rdbtnEvent = new JRadioButton("Event");
        rdbtnEvent.setFont(new Font("Rockwell", Font.PLAIN, 16));
        rdbtnEvent.setBounds(30, 243, 115, 35);
        add(rdbtnEvent);

        rdbtnTask = new JRadioButton("Task");
        rdbtnTask.setFont(new Font("Rockwell", Font.PLAIN, 16));
        rdbtnTask.setBounds(159, 243, 115, 35);
        add(rdbtnTask);

        itemTypeGroup = new ButtonGroup();
        itemTypeGroup.add(rdbtnEvent);
        itemTypeGroup.add(rdbtnTask);

        JLabel lblDate = new JLabel("Date: ");
        lblDate.setFont(new Font("Rockwell", Font.PLAIN, 16));
        lblDate.setBounds(30, 140, 77, 29);
        add(lblDate);

        dateTxtField = new JTextField();
        dateTxtField.setFont(new Font("Rockwell", Font.PLAIN, 15));
        dateTxtField.setBounds(131, 140, 115, 29);
        dateTxtField.setEditable(false);
        add(dateTxtField);
        dateTxtField.setColumns(10);

        JLabel lblTimeStart = new JLabel("Time Start:");
        lblTimeStart.setFont(new Font("Rockwell", Font.PLAIN, 16));
        lblTimeStart.setBounds(30, 302, 89, 31);
        add(lblTimeStart);

        timeStarttxtField = new JTextField();
        timeStarttxtField.setFont(new Font("Rockwell", Font.PLAIN, 15));
        timeStarttxtField.setColumns(10);
        timeStarttxtField.setBounds(131, 303, 115, 29);
        add(timeStarttxtField);

        JLabel lblTimeEnd = new JLabel("Time End:");
        lblTimeEnd.setFont(new Font("Rockwell", Font.PLAIN, 16));
        lblTimeEnd.setBounds(277, 302, 89, 31);
        add(lblTimeEnd);

        timeEndTxtField = new JTextField();
        timeEndTxtField.setFont(new Font("Rockwell", Font.PLAIN, 15));
        timeEndTxtField.setColumns(10);
        timeEndTxtField.setBounds(386, 303, 115, 29);
        add(timeEndTxtField);

        JLabel lblItemType = new JLabel("Item Type:");
        lblItemType.setFont(new Font("Rockwell", Font.PLAIN, 16));
        lblItemType.setBounds(30, 203, 89, 31);
        add(lblItemType);

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnAdd.setBounds(117, 397, 97, 35);
        add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                //pass data to controller and let it pass to model then add it to csv?
                if (isGood()) {
                    if (isTimeValid()) {
                        JOptionPane.showMessageDialog(new JFrame(), "Item successfully added", "Prompt", JOptionPane.INFORMATION_MESSAGE);
                        if (rdbtnEvent.isSelected())
                            addItemController.passToModel(dateTxtField.getText(), timeStarttxtField.getText(),
                                    timeEndTxtField.getText(), nameTxtField.getText(), rdbtnEvent.getText());
                        else
                            addItemController.passToModel(dateTxtField.getText(), timeStarttxtField.getText(),
                                    timeEndTxtField.getText(), nameTxtField.getText(), rdbtnTask.getText());

                        itemPanel.removeAll();
                        itemPanel.repaint();
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Time!", "Invalid Time", JOptionPane.OK_OPTION);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(new JFrame(), "Empty field(s) found!", "Empty Field", JOptionPane.OK_OPTION);
                }
            }
        });

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnCancel.setBounds(314, 397, 97, 35);
        add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                reset();
                itemPanel.removeAll();
                itemPanel.repaint();
            }
        });

        JLabel lblAddCalendarItem = new JLabel("Add Calendar Item");
        lblAddCalendarItem.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblAddCalendarItem.setBounds(30, 13, 204, 35);
        add(lblAddCalendarItem);

        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnClear.setBounds(215, 397, 97, 35);
        add(btnClear);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                reset();
            }
        });

        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dateTxtField.setText(datePicker.getJFormattedTextField().getText());
            }
        });

    }

    public void reset() {
        nameTxtField.setText("");
        itemTypeGroup.clearSelection();
        dateTxtField.setText("");
        timeStarttxtField.setText("");
        timeEndTxtField.setText("");
    }

    private boolean isGood(){
        boolean good = false;
        if (!nameTxtField.getText().equals("") && !dateTxtField.getText().equals("") &&
            !timeStarttxtField.getText().equals("") && !timeEndTxtField.getText().equals("") &&
            (itemTypeGroup.isSelected(rdbtnEvent.getModel()) || itemTypeGroup.isSelected(rdbtnTask.getModel())))
            good = true;

        return good;
    }

    private boolean isTimeValid(){
        String[] timeStart = timeStarttxtField.getText().split(":");
        String[] timeEnd = timeEndTxtField.getText().split(":");
        boolean valid = true;

        if (Integer.parseInt(timeStart[0]) > Integer.parseInt(timeEnd[0])){
            valid = false;
        }
        else if (Integer.parseInt(timeStart[1]) >= Integer.parseInt(timeEnd[1])){
            valid = false;
        }

        return valid;
    }
}
