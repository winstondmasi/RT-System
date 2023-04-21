import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Table extends JFrame {
    private static String[][] data;
    private String[] columnNames = {"Name", "Tyre", "Lap Time"};
    private static JTable table;
    private JScrollPane scrollPane;

    public Table() {
        data = new String[10][3];
        table = new JTable(data, columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(scrollPane);
        panel.setPreferredSize(new Dimension(400, 200));

        JFrame frame = new JFrame("Table Example");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(400, 150));
        JTextField nameField = new JTextField("Name", 20);
        JTextField tyreField = new JTextField("Tyre", 20);
        JTextField lapTimeField = new JTextField("Lap Time", 20);

        // Add focus listeners to the text fields
        nameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                nameField.setText("");
            }
        });

        tyreField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                tyreField.setText("");
            }
        });

        lapTimeField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                lapTimeField.setText("");
            }
        });

        panel1.add(nameField);
        panel1.add(tyreField);
        panel1.add(lapTimeField);

        JButton submitButton = new JButton("Submit");
        panel1.add(submitButton);

        JButton clearButton = new JButton("Clear");
        panel1.add(clearButton);

        JButton deleteButton = new JButton("Delete");
        panel1.add(deleteButton);

        frame.add(panel1);

        // Use pack() to size the frame based on the preferred size of its contents
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loadLaps();

        submitButton.addActionListener(e -> {
            Table.addEntry(nameField.getText(), tyreField.getText(), lapTimeField.getText());
            saveLap(nameField.getText(), tyreField.getText(), lapTimeField.getText());
        });
        clearButton.addActionListener(e -> {
            clearLapTimes();
            clearTableData(); // Clear the table data after clearing the file
        });

        deleteButton.addActionListener(e -> {
            deleteLapTime(nameField.getText(), tyreField.getText(), lapTimeField.getText());
            deleteTableRow(nameField.getText(), tyreField.getText(), lapTimeField.getText());
        });

    }


    // This method adds a new entry to the table
    public static void addEntry(String name, String tyre, String lapTime) {
        // Find the first empty row in the table
        int row = 0;
        while (row < data.length && data[row][0] != null) {
            row++;
        }

        // If the table is full, do nothing
        if (row >= data.length) {
            return;
        }

        // Add the entry to the table
        data[row][0] = name;
        data[row][1] = tyre;
        data[row][2] = lapTime;

        // Update the table
        table.repaint();
    }

    public void saveLap(String name, String tyre, String lapTime) {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("laps.txt", true));
            writer.println(name + "," + tyre + "," + lapTime);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace for troubleshooting
            // Display error message to user or log the exception
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

    // Add a method to clear the table data
    public static void clearTableData() {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col] = null;
            }
        }
        table.repaint();
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

    // Add a method to delete a table row based on the given data
    public static void deleteTableRow(String name, String tyre, String lapTime) {
        for (int row = 0; row < data.length; row++) {
            if (data[row][0] != null && data[row][0].equals(name) &&
                    data[row][1] != null && data[row][1].equals(tyre) &&
                    data[row][2] != null && data[row][2].equals(lapTime)) {
                // Shift the remaining rows up by one
                for (int i = row; i < data.length - 1; i++) {
                    data[i][0] = data[i + 1][0];
                    data[i][1] = data[i + 1][1];
                    data[i][2] = data[i + 1][2];
                }
                // Clear the last row
                data[data.length - 1][0] = null;
                data[data.length - 1][1] = null;
                data[data.length - 1][2] = null;
                break;
            }
        }
        table.repaint();
    }
}
