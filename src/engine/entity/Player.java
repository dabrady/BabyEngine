package engine.entity;

import java.awt.Color;

import engine.GFX.InputHandler;
import engine.world.Board;

public class Player extends Entity {
  InputHandler input;


  public Player(int x, int y, Board b, InputHandler input) {
    super(x, y, b);
    color = new Color(128, 248, 192);
    this.input = input;
  }

  public void tick() {
    if (xa == 0 && ya == 0) {
      if (input.UP.isPressed)    ya = -1;
      if (input.DOWN.isPressed)  ya =  1;
      if (input.LEFT.isPressed)  xa = -1;
      if (input.RIGHT.isPressed) xa =  1;
    } else {
      move();
    }
  }
}