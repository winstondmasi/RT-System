import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    MyFrame(){

        JLabel name = new JLabel();
        name.setText("What is the racers name?");//name of the racer

        JLabel tyre = new JLabel();
        tyre.setText("What type of tyre did they use?");//type of tyre

        JLabel lap_time = new JLabel();
        lap_time.setText("What was the lap time they set (in seconds)?");//lap time

        JTextField name_input = new JTextField();
        JTextField tyre_input = new JTextField();
        JTextField lap_time_input = new JTextField();


        this.setTitle("Race Timing System");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);

        //this.getContentPane().setBackground(new Color(128, 128, 128));

        this.add(name);
        this.add(tyre);
        this.add(lap_time);

        this.add(name_input);
        this.add(tyre_input);
        this.add(lap_time_input);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
