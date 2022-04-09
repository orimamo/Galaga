import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {

    private GalagaPanel galagaPanel;

    public PlayerController (GalagaPanel galagaPanel) {
        this.galagaPanel = galagaPanel;
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyReleased(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                this.galagaPanel.getPlayer().moveRight();
                break;
            case KeyEvent.VK_LEFT:
                this.galagaPanel.getPlayer().moveLeft();
                break;
            case KeyEvent.VK_UP:
                this.galagaPanel.getPlayer().moveUp();
                break;
            case KeyEvent.VK_DOWN:
                this.galagaPanel.getPlayer().moveDown();
                break;

        }
    }
}
