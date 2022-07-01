import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        
        //Creating Jframe 
        JFrame window = new JFrame();

        window.setTitle("Race Timing System");
        
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);

        window.setSize(600, 600);

        window.setResizable(false);

        window.setVisible(true);
    }

}
