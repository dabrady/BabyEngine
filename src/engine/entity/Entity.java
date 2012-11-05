package engine.entity;

import java.awt.Color;
import java.awt.Graphics;

import engine.GFX.InputHandler;
import engine.world.Board;
import engine.world.Tile;

public class Entity {
  Board board;
  Tile tile;
  int size = 32;
  int x;
  int y;
  InputHandler ih;

  public Entity(int x, int y, Board b, InputHandler ih) {
    this.x = x;
    this.y = y;
    this.board = b;
    this.ih = ih;
    this.moveTo(x, y);
  }

  public void tick() {
    if (ih.UP.pressed) {
      moveTo(x, y - 1);
    }
  }

  public void moveTo(int x, int y) {
    Tile t = board.getTileAt(x, y);

    // leave our old tile if we had one
    if (tile != null) {
      tile.removeEntity(this);
    }

    // join the new tile
    tile = t;
    tile.addEntity(this);
  }

  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillOval(tile.getX(), tile.getY(), size, size);
  }
}
