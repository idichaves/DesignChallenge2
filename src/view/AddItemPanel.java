package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class AddItemPanel extends JPanel {

    private JTextField nameTxtField;
    private JTextField dateTxtField;
    private JTextField timeStarttxtField;
    private JTextField textField;
    private ButtonGroup itemTypeGroup;

    public AddItemPanel() {
        setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Rockwell", Font.PLAIN, 16));
        lblName.setBounds(30, 75, 89, 27);
        add(lblName);

        nameTxtField = new JTextField();
        nameTxtField.setFont(new Font("Rockwell", Font.PLAIN, 15));
        nameTxtField.setBounds(131, 74, 370, 29);
        add(nameTxtField);
        nameTxtField.setColumns(10);

        JRadioButton rdbtnEvent = new JRadioButton("Event");
        rdbtnEvent.setFont(new Font("Rockwell", Font.PLAIN, 16));
        rdbtnEvent.setBounds(30, 243, 115, 35);
        add(rdbtnEvent);

        JRadioButton rdbtnTask = new JRadioButton("Task");
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

        textField = new JTextField();
        textField.setFont(new Font("Rockwell", Font.PLAIN, 15));
        textField.setColumns(10);
        textField.setBounds(386, 303, 115, 29);
        add(textField);

        JLabel lblItemType = new JLabel("Item Type:");
        lblItemType.setFont(new Font("Rockwell", Font.PLAIN, 16));
        lblItemType.setBounds(30, 203, 89, 31);
        add(lblItemType);

        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnAdd.setBounds(159, 397, 97, 35);
        add(btnAdd);

        JButton btnDiscard = new JButton("Discard");
        btnDiscard.setFont(new Font("Rockwell", Font.PLAIN, 15));
        btnDiscard.setBounds(277, 397, 97, 35);
        add(btnDiscard);

        JLabel lblAddCalendarItem = new JLabel("Add Calendar Item");
        lblAddCalendarItem.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lblAddCalendarItem.setBounds(30, 13, 204, 35);
        add(lblAddCalendarItem);

    }
}
