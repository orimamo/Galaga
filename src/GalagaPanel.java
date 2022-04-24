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
    public static final int MOVE_OFFSET = 10;
    private ImageIcon space, ship, alien;
    private Ship spaceShip;
    private Alien enemy;
    private ArrayList<Alien> enemies;

    public GalagaPanel(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);

        this.space = new ImageIcon("sky.jpeg");
        this.ship = new ImageIcon("ship.png");
        this.alien = new ImageIcon("alien.png");
        this.spaceShip = new Ship(ship,350,700);
        this.enemies = new ArrayList<Alien>();
        for (int i = 0; i < 90; i++) {
            if (i != 0) {
                if (i % 9 == 0) {
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
            this.alien.paintIcon(this, graphics, alien.getX(), alien.getY());
        }
        this.spaceShip.getPicture().paintIcon(this, graphics, spaceShip.getX(),spaceShip.getY());
    }

    public void mainGameLoop() {
        new Thread(() -> {
            while (true) {
                PlayerController playerController = new PlayerController(this.spaceShip);
                this.addKeyListener(playerController);
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
            while(true){
                //left arrow is pressed
            }
            //detect arrow key(up,down,left,right)
            //with loop

        }).start();
    }

    public Ship getPlayer() {
        return spaceShip;
    }


}

