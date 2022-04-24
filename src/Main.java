import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static final int WINDOW_WIDTH = 800  ;
    public static final int WINDOW_HEIGHT = 800 ;

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        GalagaPanel galagaPanel = new GalagaPanel(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.add(galagaPanel);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);



    }



}
