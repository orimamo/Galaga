import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Ship {
    private int x;
    private int y;

    private int hight;
    private int wight;
    private ImageIcon picture;
    private boolean alive;

    public Ship(ImageIcon picture,int x,int y) {
        this.x = x;
        this.y = y;
        this.picture = picture;
        this.hight = picture.getIconHeight();
        this.wight = picture.getIconWidth();
        this.alive = true;
    }

    public void paint(Graphics graphics) {
        if (this.alive) {
            graphics.fillRect(this.x, this.y, this.wight, this.hight);

        }
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public void setPicture(ImageIcon picture) {
        this.picture = picture;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void shot( boolean shot){
        if(shot) {
            Bullet bullet = new Bullet(this.getX(), this.getY()+this.hight);
            bullet.moveUp();
        }

    }

    public void moveRight() {
        this.x++;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveUp() {
        this.y--;
    }

    public void moveDown() {
        this.y++;
    }

    public void kill() {
        this.alive = false;
    }
}
