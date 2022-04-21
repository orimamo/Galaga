import javax.swing.*;
import java.awt.*;

public class Ship {
    private int x;
    private int y;

    private int hight;
    private int wight;
    private ImageIcon picture;
    private boolean alive;

    public Ship(ImageIcon picture) {
        this.x=x;
        this.y=y;
        this.picture = picture;
        this.hight=picture.getIconHeight();
        this.wight=picture.getIconWidth();
        this.alive=true;
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

    public void moveRight () {
        this.x++;
    }

    public void moveLeft () {
        this.x--;
    }

    public void moveUp () {
    this.y --;
    }

    public void moveDown () {
        this.y++;
    }
    public boolean checkCollision (Alien obstacle) {
        boolean collision = false;
        Rectangle r = new Rectangle(obstacle.getX(),obstacle.getY(),obstacle.getWight(),obstacle.getHight());
        Rectangle p = new Rectangle(this.getX(),this.getY(),this.wight,this.hight);
        if (p.intersects(r)) {
            collision = true;
        }
        return collision;
    }
    public void kill(){
        this.alive=false;
    }






}
