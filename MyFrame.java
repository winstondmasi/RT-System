import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    MyFrame(){

        JLabel name = new JLabel();
        name.setText("What is the racers name?");//name of the racer
        name.setBounds(500,10, 10,10);

        JLabel tyre = new JLabel();
        tyre.setText("What type of tyre did they use?");//type of tyre
        tyre.setBounds(350,10, 10,10);

        JLabel lap_time = new JLabel();
        lap_time.setText("What was the lap time they set (in seconds)?");//lap time
        lap_time.setBounds(300,10, 10,10);

        JTextField name_input = new JTextField();
        name_input.setBounds(500, 150, 100, 100);

        JTextField tyre_input = new JTextField();
        tyre_input.setBounds(350, 150, 100, 100);

        JTextField lap_time_input = new JTextField();
        lap_time_input.setBounds(200, 150, 100, 100);

        JButton button = new JButton();
        button.setBounds(100, 300, 100, 50);

        this.setTitle("Race Timing System");
        this.setSize(700, 700);
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

        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
