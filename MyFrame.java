import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    MyFrame(){

        JLabel name = new JLabel();
        name.setText("What is the racers name?\r\n");//name of the racer
        name.setBounds(25,100, 50,50);

        JLabel tyre = new JLabel();
        tyre.setText("What type of tyre did they use?\r\n");//type of tyre
        tyre.setBounds(25,250, 50,50);

        JLabel lap_time = new JLabel();
        lap_time.setText("What was the lap time they set (in seconds)?\r\n");//lap time
        lap_time.setBounds(25,400, 10,50);

        JTextField name_input = new JTextField();
        name_input.setBounds(300, 100, 250, 75);

        JTextField tyre_input = new JTextField();
        tyre_input.setBounds(300, 250, 250, 75);

        JTextField lap_time_input = new JTextField();
        lap_time_input.setBounds(300, 400, 250, 75);

        JButton button = new JButton();
        button.setBounds(200, 550, 300, 50);

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

    }
}
