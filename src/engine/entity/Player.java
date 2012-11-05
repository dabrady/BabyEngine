package engine.entity;

import engine.GFX.InputHandler;
import engine.world.Board;

public class Player extends Entity {

  InputHandler input;

  public Player(int x, int y, Board b, InputHandler input) {
    super(x, y, b);
    this.input = input;
  }
}
