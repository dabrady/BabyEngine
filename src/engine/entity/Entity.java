package engine.entity;

import java.awt.Color;
import java.awt.Graphics;

import engine.world.Board;
import engine.world.Tile;

public class Entity {
  Board board;
  Tile tile;
  int size = 32;
  int x;
  int y;

  public Entity(int x, int y, Board b) {
    this.x = x;
    this.y = y;
    board = b;
    moveTo(x, y);
  }

  public void tick() {
    moveTo(x, y + 1);
  }

  public void move(int x, int y) {
    moveTo(this.x + x, this.y + y);
  }

  public void moveTo(int x, int y) {
    this.x = x;
    this.y = y;
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
    g.fillOval(x, y, size, size);
  }
}
