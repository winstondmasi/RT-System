import java.awt.Color;

import javax.swing.*;

public class Main {
    
    public static void main(String[] args) {

        JLabel number_1_label = new JLabel();
        number_1_label.setText("Racer Number 1");//text for racer 1
        number_1_label.setHorizontalAlignment(JLabel.LEFT);//alignment is Upward to the left
        number_1_label.setVerticalAlignment(JLabel.TOP);

        JLabel number_2_label = new JLabel();
        number_2_label.setText("Racer Number 2");//text for racer 2
        number_2_label.setHorizontalAlignment(JLabel.LEFT);//alignment is to the left

        JLabel number_3_label = new JLabel();
        number_3_label.setText("Racer Number 3");//text for racer 3
        number_3_label.setHorizontalAlignment(JLabel.LEFT);//alignment is downward to the left
        number_3_label.setVerticalAlignment(JLabel.BOTTOM);


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
