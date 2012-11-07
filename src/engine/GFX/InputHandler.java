package engine.GFX;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class InputHandler implements KeyListener {

  HashMap<Integer, Key> keys = new HashMap<Integer,Key>();

  public class Key {

    public boolean isPressed, clicked;
    int keyCode, presses, absorbs;

    Key(int keyCode) {
      this.keyCode = keyCode;
      keys.put(keyCode, this);
    }

    public int getKeyCode() {
      return keyCode;
    }

    public void toggle(boolean pressed) {
      if (isPressed != pressed) {
        isPressed = pressed;
        if (pressed) {
          presses++;
        }
      }
    }

    public void tick() {
      if (absorbs < presses) {
        absorbs++;
        clicked = true;
      } else {
        clicked = false;
      }
    }

  }

  public Key UP = new Key(KeyEvent.VK_W);
  public Key DOWN = new Key(KeyEvent.VK_S);
  public Key LEFT = new Key(KeyEvent.VK_A);
  public Key RIGHT = new Key(KeyEvent.VK_D);

  public void tick() {
    for (Key k : keys.values()) {
      k.tick();
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (keys.containsKey(e.getKeyCode()))
      keys.get(e.getKeyCode()).toggle(true);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (keys.containsKey(e.getKeyCode()))
      keys.get(e.getKeyCode()).toggle(false);
  }

}
