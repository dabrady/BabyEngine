package engine.GFX;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class InputHandler implements KeyListener {

  ArrayList<Key> keys = new ArrayList<Key>();

  class Key {

    boolean pressed;
    int keyCode;

    Key(int keyCode) {
      this.keyCode = keyCode;
      keys.add(this);
    }

    public int getKeyCode() {
      return keyCode;
    }
  }

  public Key UP = new Key(KeyEvent.VK_W);
  public Key DOWN = new Key(KeyEvent.VK_S);

  public void tick() {
    for (Key k : keys) {
      if (k.pressed) {
        System.out.println(k.getKeyCode());
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(KeyEvent e) {
    for (Key k : keys) {
      if (e.getKeyCode() == k.getKeyCode()) {
        k.pressed = true;
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    for (Key k : keys) {
      if (e.getKeyCode() == k.getKeyCode()) {
        k.pressed = false;
      }
    }
  }

}
