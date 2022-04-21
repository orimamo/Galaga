import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class GalagaPanel extends JPanel {
    public static int ENEMYX=20;
    public static final int ENEMYY=10;
    private ImageIcon space,ship,alien;
    private Ship spaceShip;
    private Alien enemy;
    private ArrayList<Alien> enemies;

    public GalagaPanel(int x,int y,int wight ,int hight) {
        this.setBounds(x, y, wight, hight);

        this.space = new ImageIcon("sky.jpeg");
        this.ship = new ImageIcon("ship.png");
        this.alien = new ImageIcon("alien.png");
        this.spaceShip = new Ship(ship);
        this.spaceShip.setX(200);
        this.spaceShip.setY(400);
        //alien array  this.aliens=new Arraylist<>()//
        this.enemies = new ArrayList<Alien>();
        Random random = new Random();
        for( int i = 0; i < 8; i++  ) {
                Alien temp = new Alien(alien, ENEMYX, ENEMYY);
                this.enemies.add(temp);
                ENEMYX=ENEMYX+100;
            }
        this.mainGameLoop();
    }
 protected void paintComponent(Graphics graphics) {
  super.paintComponent(graphics);
  this.space.paintIcon(this,graphics,0,0);
     for (Alien alien : this.enemies) {
         this.alien.paintIcon(this,graphics,alien.getX(),alien.getY());
     }
  this.spaceShip.getPicture().paintIcon(this,graphics,350,700);
 }
    public void mainGameLoop () {
        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            PlayerController playerController = new PlayerController(this);
            this.addKeyListener(playerController);
        }).start();
    }

         public Ship getPlayer() {
                return spaceShip;
 }
        }

