import javax.swing.*;
import java.awt.*;

public class Ship {
    private int x;
    private int y;
    public Ship(int x,int y) {
        this.x=x;
        this.y=y;
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
        this.x=x+5;

    }

    public void moveLeft () {
        this.x= x-5;
    }

    public void moveUp () {
    this.y = y-5;
    }

    public void moveDown () {
        this.y= y+5;
    }

}
