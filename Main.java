import java.awt.Color;

import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {

        JLabel name = new JLabel();
        JTextField name_input = new JTextField();
        name.setText("Racer Number 1");//text for racer 1
        name.setHorizontalAlignment(JLabel.LEFT);//alignment is Upward to the left
        name.setVerticalAlignment(JLabel.TOP);

        JLabel tyre = new JLabel();
        JTextField tyre_input = new JTextField();
        tyre.setText("Racer Number 2");//text for racer 2
        tyre.setHorizontalAlignment(JLabel.LEFT);//alignment is to the left

        JLabel lap_time = new JLabel();
        JTextField lap_time_input = new JTextField();
        lap_time.setText("Racer Number 3");//text for racer 3
        lap_time.setHorizontalAlignment(JLabel.LEFT);//alignment is downward to the left
        lap_time.setVerticalAlignment(JLabel.BOTTOM);


        //Creating JFrame
        JFrame window = new JFrame();
        window.setTitle("Race Timing System");
        window.setSize(600, 600);
        window.setResizable(false);
        window.setVisible(true);
        //window.getContentPane().setBackground(new Color(8, 143, 143));

        window.add(number_1_label);
        window.add(number_2_label);
        window.add(number_3_label);

    } 

}
