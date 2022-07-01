import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    
    public static void main(String[] args) {

        JTextField name_input = new JTextField();
        JTextField tyre_input = new JTextField();
        JTextField lap_time_input = new JTextField();

        JLabel name = new JLabel();
        name.setText("Racer Number 1");//text for racer 1
        name.setHorizontalAlignment(JLabel.LEFT);//alignment is Upward to the left
        name.setVerticalAlignment(JLabel.TOP);

        JLabel tyre = new JLabel();
        tyre.setText("Racer Number 2");//text for racer 2
        tyre.setHorizontalAlignment(JLabel.LEFT);//alignment is to the left

        JLabel lap_time = new JLabel();
        lap_time.setText("Racer Number 3");//text for racer 3
        lap_time.setHorizontalAlignment(JLabel.LEFT);//alignment is downward to the left
        lap_time.setVerticalAlignment(JLabel.BOTTOM);

        //Creating JFrame
        JFrame window = new JFrame();
        window.setTitle("Race Timing System");
        window.setSize(600, 600);
        window.setResizable(false);
        window.setVisible(true);
        window.getContentPane().setBackground(new Color(128, 128, 128));

        window.add(name);
        window.add(tyre);
        window.add(lap_time);

        window.add(name_input);
        window.add(tyre_input);
        window.add(lap_time_input);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
