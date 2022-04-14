import javax.swing.*;
import java.awt.*;

public class Alien {

    private int x;
    private int y;
    private int hight;
    private int wight;
    private ImageIcon picture;
    private boolean alive;

    public Alien(ImageIcon picture) {
        this.x = 10;
        this.y = 10;
        this.picture = picture;
        this.hight=picture.getIconHeight();
        this.wight=picture.getIconWidth();
    }
    public void paint(Graphics graphics){
        if (this.alive){
            graphics.fillRect(this.x,this.y,this.wight,this.hight);

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

}
