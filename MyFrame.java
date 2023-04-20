
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {
    // Create a frame
    JFrame frame = new JFrame("Window Example");

    public MyFrame() {
        // Set the size of the window
        frame.setSize(400, 200);

        // Set the default close operation (what happens when the user clicks the X
        // button)
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

        JButton clearButton = new JButton("Clear");
        panel.add(clearButton);

        // Create the delete button and add it to the panel
        JButton deleteButton = new JButton("Delete");
        panel.add(deleteButton);

        // Add the panel to the window
        frame.add(panel);

        // Load the lap data from the file
        loadLaps();

        // Show the window
        frame.setVisible(true);

        // Add an action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the submit button is pressed, add the values in the fields to the table
                Table.addEntry(nameField.getText(), tyreField.getText(), lapTimeField.getText());
                saveLap(nameField.getText(), tyreField.getText(), lapTimeField.getText());

            }
        });

        // Add an action listener to the clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the clear button is pressed, clear all the saved lap times
                clearLapTimes();
            }
        });

        // Add an action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the delete button is pressed, delete the selected lap time
                deleteLapTime(nameField.getText(), tyreField.getText(), lapTimeField.getText());
            }
        });
    }

    public void saveLap(String name, String tyre, String lapTime) {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("laps.txt", true));

            writer.println(name + "," + tyre + "," + lapTime);

            writer.close();
        } catch (IOException e) {
            // handle the exception
        }
    }

    public void loadLaps() {
        try {
            // Open the file for reading
            Scanner reader = new Scanner(new FileInputStream("laps.txt"));

            // Read the lap data from the file line by line
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] values = line.split(",");
                String name = values[0];
                String tyre = values[1];
                String lapTime = values[2];

                // Add the lap data to the table
                Table.addEntry(name, tyre, lapTime);
            }

            // Close the file
            reader.close();
        } catch (IOException e) {
            // Handle the exception
        }
    }

    public void clearLapTimes() {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("laps.txt"));
            writer.print("");
            writer.close();
        } catch (IOException e) {
            // handle the exception
        }
    }

    public void deleteLapTime(String name, String tyre, String lapTime) {
        try {
            // Read the lap data from the file
            Scanner reader = new Scanner(new FileInputStream("laps.txt"));
            StringBuilder data = new StringBuilder();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] values = line.split(",");
                String lapName = values[0];
                String lapTyre = values[1];
                String lapLapTime = values[2];
                if (!lapName.equals(name) || !lapTyre.equals(tyre) || !lapLapTime.equals(lapTime)) {
                    data.append(line).append("\n");
                }
            }
            reader.close();

            // Write the remaining lap data back to the file
            PrintWriter writer = new PrintWriter(new FileOutputStream("laps.txt"));
            writer.print(data.toString());
            writer.close();
        } catch (IOException e) {
            // handle the exception
        }
    }

}