import java.awt.*;

public class Bullet {
    private int bulletWidth=20;
    private int bulletHeight=20;
    private CustomRectangle bullet;
    private boolean hit;

    public Bullet(int x, int y) {
        this.bullet = new CustomRectangle(
                x,
                y,
                bulletWidth,
                bulletHeight,
                Color.white);
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

    public void moveDown(){
        while (hit){
            this.bullet.moveDown();
        }
    }
    public void kill () {
        this.hit = true;
    }



}