import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Ship {
    private int x=350;
    private int y = 700;

    private int height;
    private int width;
    private ImageIcon picture;
    private boolean alive;
//     public ArrayList<Bullet> bullets;

    public Ship(ImageIcon picture) {
        this.picture = picture;
        this.height = picture.getIconHeight();
        this.width = picture.getIconWidth();
        this.alive = true;
//        this.bullets=new ArrayList<Bullet>();

    }

    public void paint(Graphics graphics) {
        if (this.alive) {
            graphics.fillRect(this.x, this.y, this.width, this.height);

        }
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int wight) {
        this.width = wight;
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
//    public Bullet shot(){
//            Bullet bullet = new Bullet(this.getX()+(this.getWidth()/2), this.getY()+(this.getHeight()/2));
//            return bullet;
//    }

    public void moveRight() {
        this.x+=5;
    }

    public void moveLeft() {
        this.x-=5;
    }

    public void moveUp() {
        this.y-=5;
    }

    public void moveDown() {
        this.y+=5;
    }

    public void kill() {
        this.alive = false;
    }

    public Bullet createBullet(){
        Bullet bullet=new Bullet(this.getX()+(this.getWidth()/2),this.getY()) ;
//        this.bullets.add(bullet);
        return bullet;
    }

//    public ArrayList<Bullet> getBullets() {
//        return bullets;
//    }
//
//    public void setBullets(ArrayList<Bullet> bullets) {
//        this.bullets = bullets;
//    }


}
