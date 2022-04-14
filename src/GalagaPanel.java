import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

public class GalagaPanel extends JPanel {
    public static final int ENEMYX=10;
    public static final int ENEMYY=10;
   private ImageIcon space,ship,alien;
   private Ship player;
   private Alien enemy;
    private ArrayList<Alien> enemies;

    public GalagaPanel(int x,int y,int wight ,int hight) {
        this.setBounds(x, y, wight, hight);
        //alien array  this.aliens=new Arraylist<>()//


        this.space = new ImageIcon("sky.jpeg");
        this.ship = new ImageIcon("ship.png");
        this.alien = new ImageIcon("alien.png");

        this.player = new Ship(ship);
        this.player.setX(200);
        this.player.setY(400);
        this.enemies = new ArrayList<Alien>();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            this.enemy = new Alien(alien);
            this.enemy.setX(i+15);
            if (!this.player.checkCollision(enemy)) {
                this.enemies.add(enemy);
            }


        }
    }
 protected void paintComponent(Graphics graphics) {
  super.paintComponent(graphics);
  this.space.paintIcon(this,graphics,0,0);
     for (Alien alien : this.enemies) {
         this.enemy.getPicture().paintIcon(this,graphics,this.enemy.getX(),ENEMYY);
     }
  this.player.getPicture().paintIcon(this,graphics,350,700);
 }
    public void mainGameLoop () {
        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            PlayerController playerController = new PlayerController(this);
            this.addKeyListener(playerController);

            /* while (true) {
                repaint();
                try {
                    Random random = new Random();
                    for (Alien obstacle : this.obstacles) {
                        int direction = random.nextInt(3);
                        if (direction == 0) {
                            obstacle.moveUp();
                        } else if (direction == 1) {
                            obstacle.moveDown();
                        } else if (direction == 2) {
                            obstacle.moveLeft();
                        } else if (direction == 3) {
                            obstacle.moveRight();
                        }
                        if (this.player.checkCollision(obstacle)) {
                            this.player.kill();
                        }
                    }
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

        }).start();

    }


 public Ship getPlayer() {
  return player;
 }
}
