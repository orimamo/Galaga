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
    private boolean isShoting=false;
    private boolean shot=false;

    public GalagaPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.setDoubleBuffered(true);
        this.space = new ImageIcon("sky.jpeg");
        this.ship = new ImageIcon("ship.png");
        this.alien = new ImageIcon("alien.png");
        this.spaceShip = new Ship(350,700,ship);

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
        this.mainGameLoop();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.space.paintIcon(this, graphics, 0, 0);
        for (Alien alien : this.enemies) {
            if (alien.isAlive()) {
                this.alien.paintIcon(this, graphics, alien.getX(), alien.getY());

            }
        }
        if(spaceShip.isAlive()) {
            this.spaceShip.getPicture().paintIcon(this, graphics, spaceShip.getX(), spaceShip.getY());
        }
        if (isShoting && !this.bullet.isHit()) {
            this.bullet.paint(graphics);
            shot=true;
        }

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
                            currentAlien.moveDown();
                        }
                    }else{
                        currentAlien.setX(currentAlien.getX() + MOVE_OFFSET);
                        if (currentAlien.getX() >= 760) {
                            currentAlien.setDirection(RIGHT);
                            currentAlien.moveDown();
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
//            while (this.bullet.getY() > 0) {
            PlayerController playerController = new PlayerController(this);
            this.addKeyListener(playerController);

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }).start();

        new Thread(() -> {
            this.setFocusable(true);
            this.requestFocus();
            ArrayList<Bullet> bullets = spaceShip.getBullets();
            spaceShip.shot();
            this.bullet=bullets.get(0);
        while (true) {
            if (shot) {
                this.bullet.moveUp();
                }

                for (Alien alien1 : this.enemies) {
                    Alien currentAlien = alien1;
                    if (this.bullet.checkCollision(currentAlien)) {
                        this.bullet.kill(alien1);
                        currentAlien.setAlive(false);
                        System.out.println("COLLISION!");
                        break;
                    }if (this.bullet.getY() == 0) {
                        isShoting = false;
                        shot = false;
                        spaceShip.shot();

                    }
            }
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }).start();
        new Thread(()->{
            this.setFocusable(true);
            this.requestFocus();
            while (spaceShip.isAlive()) {
                for (Alien alien1 : this.enemies) {
                    Alien currentAlien = alien1;
                    if (this.spaceShip.checkCollision(currentAlien)) {
                        this.spaceShip.setAlive(false);
                        System.out.println("dead");
                    }

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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
//    public void addBullets(){
//        this.bullet=new Bullet(spaceShip.getX()+(spaceShip.getWidth()/2),spaceShip.getY()) ;
//        this.bullets.add(this.bullet);
//    }


}

