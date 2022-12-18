import javax.swing.*;

public class Table {
    // The table data will be stored in a two-dimensional array
    private static String[][] data;

    // The column names will be stored in an array
    private String[] columnNames = {"Name", "Tyre", "Lap Time"};

    // The table will be created with a JTable object
    private static JTable table;

    // The scroll pane will be used to add scrolling to the table
    private JScrollPane scrollPane;

    public Table() {
        // Initialize the data array with enough rows to hold 10 entries
        data = new String[10][3];

        // Create a new JTable with the data array and the column names array
        table = new JTable(data, columnNames);

        // Create a new scroll pane with the table as its content
        scrollPane = new JScrollPane(table);

        // Add the scroll pane to a panel so it can be added to a window
        JPanel panel = new JPanel();
        panel.add(scrollPane);

        // Create a new window and add the panel with the table to it
        JFrame frame = new JFrame("Table Example");
        frame.add(panel);

        // Set the size of the window and show it
        frame.setSize(400, 200);
        frame.setVisible(true);
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
        table.updateUI();
    }
}

