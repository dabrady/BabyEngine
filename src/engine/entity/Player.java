package engine.entity;

import engine.GFX.InputHandler;
import engine.world.Board;

public class Player extends Entity {
  int xa = 0;
  int ya = 0;
  InputHandler input;

  public Player(int x, int y, Board b, InputHandler input) {
    super(x, y, b);
    this.input = input;
  }

  public void tick() {
    if (xa == 0 && ya == 0) {
      if (input.UP.isPressed)    ya = -1;
      if (input.DOWN.isPressed)  ya =  1;
      if (input.LEFT.isPressed)  xa = -1;
      if (input.RIGHT.isPressed) xa =  1;
    } else {
      move(xa, ya);

      if (x % board.getTileSize() == 0 &&
          y % board.getTileSize() == 0) {
        xa = 0;
        ya = 0;
      }
    }


  }
}