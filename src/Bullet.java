import java.awt.*;

public class Bullet {
    private int bulletWidth=5;
    private int bulletHeight=10;
    private CustomRectangle bullet;
    private boolean hit;
    private boolean shot;

    public Bullet(int x, int y) {
        this.bullet = new CustomRectangle(
                x,
                y,
                bulletWidth,
                bulletHeight,
                Color.white);
        this.hit=false;
        this.shot=false;

    }

    public void paint (Graphics graphics) {
            this.bullet.paint(graphics);

    }

    public boolean isShot() {
        return shot;
    }

    public void setShot(boolean shot) {
        this.shot = shot;
    }

    public void moveUp () {
        while (!hit){

            this.bullet.moveUp();
        }
    }

    public void moveDown(){
        while (!hit){
            this.bullet.moveDown();
        }
    }
    public void kill () {
        this.hit = true;
    }



}