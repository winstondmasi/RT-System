import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;

    JTextField name_input;
    JTextField tyre_input;
    JTextField lap_time_input;

    //local variable for table void method
    JTable jTable;

    MyFrame(){

        JLabel name = new JLabel();
        name.setText("Name: \r\n");//name of the racer
        name.setBounds(25,100, 70,50);

        JLabel tyre = new JLabel();
        tyre.setText("Tyre: \r\n");//type of tyre
        tyre.setBounds(25,250, 70,50);

        JLabel lap_time = new JLabel();
        lap_time.setText("Time: \r\n");//lap time
        lap_time.setBounds(25,400, 70,50);

        name_input = new JTextField();
        name_input.setBounds(250, 100, 250, 75);

        tyre_input = new JTextField();
        tyre_input.setBounds(250, 250, 250, 75);

        lap_time_input = new JTextField();
        lap_time_input.setBounds(250, 400, 250, 75);


        ImageIcon imageIcon = new ImageIcon("image/point.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back

        button = new JButton();
        button.setBounds(200, 550, 300, 50);
        button.addActionListener(this);
        button.setText("Submit");
        button.setIcon(imageIcon);
        button.setFont(new Font("Ubuntu", Font.PLAIN, 20));

        this.setTitle("Race Timing System");
        this.setSize(700, 700);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);

        this.getContentPane().setBackground(new Color(128, 128, 128));

        this.add(name);
        this.add(tyre);
        this.add(lap_time);

        this.add(name_input);
        this.add(tyre_input);
        this.add(lap_time_input);

        this.add(button);
    }

    public void clear() {
        String EMPTY_STRING = "";
        name_input.setText(EMPTY_STRING);
        tyre_input.setText(EMPTY_STRING);
        lap_time_input.setText(EMPTY_STRING);
    }

    public static boolean containsItemFromArray(JTextField tyre_input2, String[] tyre_used) {
        // Convert the array of String items as a Stream
        // For each element of the Stream call inputString.contains(element)
        // If you have any match returns true, false otherwise

            for(int i =0; i < tyre_used.length; i++){
                if(tyre_input2.getText().contains(tyre_used[i])){
                return true;
            }
        }
        return false;
    }

    //creating the table 2).
    JFrame tablFrame;
    public void table(){

        //Tables Colomns
        //model = new DefaultTableModel();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Tyre");
        model.addColumn("Lap TIme");
        model.addRow(new Object[]{name_input.getText(), tyre_input.getText(), lap_time_input.getText()});

        //creating table
        jTable = new JTable (model);
        jTable.setBounds(100, 100, 350, 350);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        

        tablFrame = new JFrame();
        tablFrame.setTitle("Table");
        tablFrame.setSize(350, 300);
        tablFrame.add(jScrollPane);
        tablFrame.add(jTable);
        tablFrame.pack();
        tablFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablFrame.setVisible(true);
        tablFrame.setResizable(true);
        tablFrame.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        String[] tyre_used = {"Hard", "Medium", "Soft", "Intermediate", "Wet"};


        if (e.getSource() == button)
        {
            if(name_input != null && tyre_input != null
            && lap_time_input != null && containsItemFromArray(tyre_input, tyre_used))
            {
                System.out.println(name_input.getText() + " " 
                + tyre_input.getText() + " " 
                + lap_time_input.getText() + "s");

                table();
                
                clear(); 
            }else{
                System.out.println("Not a valid.\n(The types of tyres are Hard, Medium, Soft, Intermediate and Wet) ");
            }
            
        }
    }
}