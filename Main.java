import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        
        //Creating Jframe 
        JFrame window = new JFrame();

        window.setTitle("Race Timing System");
        
        window.setSize(600, 600);

        window.setResizable(false);

        window.setVisible(true);

        ImageIcon oP_ImageIcon = new ImageIcon("image/Crountch-One-Piece-Jolly-Roger-Luffys-flag.ico");

        window.setIconImage(oP_ImageIcon.getImage());

        window.getContentPane().setBackground(new Color(8, 143, 143));
    } 

}
