import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;

    JTextField name_input;
    JTextField tyre_input;
    JTextField lap_time_input;

    MyFrame(){

        JLabel name = new JLabel();
        name.setText("Name: \r\n");//name of the racer
        name.setBounds(25,100, 50,50);

        JLabel tyre = new JLabel();
        tyre.setText("Tyre: \r\n");//type of tyre
        tyre.setBounds(25,250, 50,50);

        JLabel lap_time = new JLabel();
        lap_time.setText("Time: \r\n");//lap time
        lap_time.setBounds(25,400, 10,50);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println(name_input.getText() 
            + tyre_input.getText() 
            + lap_time_input.getText());
        }
    }
}
