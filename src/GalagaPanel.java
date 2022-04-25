import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.ArrayList;

public class GalagaPanel extends JPanel {
    private boolean inGame = true;
    public int ENEMYX = 60;
    public int ENEMYY = 10;
    public static final char RIGHT = 'R';
    public static final char LEFT = 'L';
    public static final int NUM_OF_ALIEN =18;
    public static final int AMOUNT_OF_ALIEN_IN_LINE =9;
    public static final int MOVE_OFFSET = 10;
    private ImageIcon space, ship, alien;
    private Ship spaceShip;
    private Alien enemy;
    private ArrayList<Alien> enemies;
    private Bullet bullet;
    private ArrayList<Bullet> bullets;
    private boolean isShoting=false;

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(ArrayList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public GalagaPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setDoubleBuffered(true);
        this.space = new ImageIcon("sky.jpeg");
        this.ship = new ImageIcon("ship.png");
        this.alien = new ImageIcon("alien.png");
        this.spaceShip = new Ship(ship,350,700);
        this.enemies = new ArrayList<Alien>();
        for (int i = 0; i < NUM_OF_ALIEN; i++) {
            if (i != 0) {
                if (i % AMOUNT_OF_ALIEN_IN_LINE == 0) {
                    ENEMYX = 60;
                    ENEMYY += 50;// new row
                } else {
                    ENEMYX = ENEMYX + 80;
                }
            }
            Alien temp = new Alien(alien, ENEMYX, ENEMYY, RIGHT);
            this.enemies.add(temp);
        }
        this.bullet=spaceShip.shot();
        this.mainGameLoop();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.space.paintIcon(this, graphics, 0, 0);
        for (Alien alien : this.enemies) {
            this.alien.paintIcon(this, graphics, alien.getX(), alien.getY());
        }
        this.spaceShip.getPicture().paintIcon(this, graphics, spaceShip.getX(),spaceShip.getY());
        this.bullet.paint(graphics);



    }

    public void mainGameLoop() {
        new Thread(() -> {
            Random random=new Random();
            this.setFocusable(true);
            this.requestFocus();
            while (true) {
                for (int i = 0; i < this.enemies.size(); i++) {
                    Alien currentAlien = this.enemies.get(i);
                    if (currentAlien.getDirection() == RIGHT) {
                        currentAlien.setX(currentAlien.getX() - MOVE_OFFSET);
                        if (currentAlien.getX() <= 0) {
                            currentAlien.setDirection(LEFT);
                        }
                    }else{
                        currentAlien.setX(currentAlien.getX() + MOVE_OFFSET);
                        if (currentAlien.getX() >= 760) {
                            currentAlien.setDirection(RIGHT);
                        }
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();
        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            while (true) {
                PlayerController playerController = new PlayerController(this);
                this.addKeyListener(playerController);
                if (isShoting)
                {
                    this.bullet.moveUp();
                    isShoting=false;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }).start();

    }

    public Ship getPlayer() {
        return spaceShip;
    }
    public boolean isShoting() {
        return isShoting;
    }

    public void setShoting(boolean shoting) {
        isShoting = shoting;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }


}

