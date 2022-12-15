import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
    JFrame frame = new JFrame("Window Example");

    // Set the size of the window
        frame.setSize(400, 200);

    // Set the default close operation (what happens when the user clicks the X button)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a panel to hold the fields and the button
    JPanel panel = new JPanel();

    // Create the three fields and add them to the panel
    JTextField nameField = new JTextField("Name", 20);
    JTextField tyreField = new JTextField("Tyre", 20);
    JTextField lapTimeField = new JTextField("Lap Time", 20);
        panel.add(nameField);
        panel.add(tyreField);
        panel.add(lapTimeField);

    // Create the submit button and add it to the panel
    JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

    // Add the panel to the window
        frame.add(panel);

    // Show the window
        frame.setVisible(true);

    // Add an action listener to the submit button
submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // When the submit button is pressed, add the values in the fields to the table
            Table.addEntry(nameField.getText(), tyreField.getText(), lapTimeField.getText());
        }
    });

}
