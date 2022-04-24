import java.awt.*;

public class Bullet {
    private int bulletWidth;
    private int bulletHeight;
    private CustomRectangle bullet;
    private boolean hit;

    public Bullet(int x, int y) {
        this.bullet = new CustomRectangle(x, y, bulletWidth,bulletHeight, Color.CYAN);
        this.hit=false;
    }

    public void paint (Graphics graphics) {
        if (this.hit) {
            this.bullet.paint(graphics);
        }
    }
    public void moveUp () {
        while (hit){
            this.bullet.moveUp();
        }
    }
    public void kill () {
        this.hit = true;
    }



}