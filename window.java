import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window extends JFrame implements ActionListener {

    window(){
        this.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);

        JButton jButton = new JButton("Submit Information");
        jButton.addActionListener(this);

        JLabel number_1_label = new JLabel();
        number_1_label.setText("Racer Number 1");

        JLabel number_2_label = new JLabel();
        number_2_label.setText("Racer Number 2");

        JLabel number_3_label = new JLabel();
        number_3_label.setText("Racer Number 3");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
