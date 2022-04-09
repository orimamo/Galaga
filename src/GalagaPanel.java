import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GalagaPanel extends JPanel {
   private ImageIcon space,ship;
   private Ship player;
   //private Arraylist<alien> aliens;

    public GalagaPanel(int x,int y,int wight ,int hight){
    this.setBounds(x,y,wight,hight);
    this.player=new Ship(150,250);
    //alien array  this.aliens=new Arraylist<>();

   this.space=new ImageIcon("sky.jpeg");

     /*JLabel ship = new JLabel("",new ImageIcon("ship.png"),JLabel.CENTER);
     add(ship);
     ship.setBounds(0,0,30,30);*/
     this.ship=new ImageIcon("ship.png");



    }

 protected void paintComponent(Graphics graphics) {
  super.paintComponent(graphics);
  this.space.paintIcon(this,graphics,0,0);
  this.ship.paintIcon(this,graphics,getX(),getY());
  ship.
 }
    public void mainGameLoop () {
        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            PlayerController playerController = new PlayerController(this);
            this.addKeyListener(playerController);

            while (true) {
                repaint();
                try {
                    Random random = new Random();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

 public Ship getPlayer() {
  return player;
 }
}
