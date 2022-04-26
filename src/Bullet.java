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

    public int getBulletWidth() {
        return bulletWidth;
    }

    public void setBulletWidth(int bulletWidth) {
        this.bulletWidth = bulletWidth;
    }

    public int getBulletHeight() {
        return bulletHeight;
    }

    public void setBulletHeight(int bulletHeight) {
        this.bulletHeight = bulletHeight;
    }

    public CustomRectangle getBullet() {
        return bullet;
    }

    public void setBullet(CustomRectangle bullet) {
        this.bullet = bullet;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
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
    public int getY(){
        return this.bullet.getY();
    }
    public int getX(){
        return this.bullet.getX();
    }

    public void moveUp () {

            this.bullet.moveUp();
            this.shot=true;

    }

//    public void moveDown(){
//        while (!hit){
//            this.bullet.moveDown();
//
//    }
    public void kill (CustomRectangle obstacle) {
        if (checkCollision(obstacle)){
            this.hit = true;

        }
    }
    public boolean checkCollision (CustomRectangle obstacle) {
        boolean collision = false;
        Rectangle bodyRect = new Rectangle(
                this.bullet.getX(),
                this.bullet.getY(),
                this.bullet.getWidth(),
                this.bullet.getHeight()
        );
        Rectangle obstacleRect = new Rectangle(
                obstacle.getX(),
                obstacle.getY(),
                obstacle.getWidth(),
                obstacle.getHeight()
        );
        if (bodyRect.intersects(obstacleRect)) {
            collision = true;
        }
        return collision;
    }



}