import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {

    private Ship ship;

    public PlayerController (Ship ship) {
        this.ship = ship;
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyReleased(KeyEvent keyEvent) {
    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if(keyCode==keyEvent.VK_RIGHT)
        {
            ship.moveRight();
        }
        if(keyCode==keyEvent.VK_LEFT)
        {
            ship.moveLeft();
        }
        if(keyCode==keyEvent.VK_UP)
        {
            ship.moveUp();
        }
        if(keyCode==keyEvent.VK_DOWN)
        {
            ship.moveDown();
        }
        if (keyCode==keyEvent.VK_SPACE){
            boolean shot=true;
            ship.shot(shot);
        }

    }
}
