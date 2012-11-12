package engine.entity;

import java.awt.Color;
import java.awt.Graphics;

import engine.world.Board;
import engine.world.Tile;

public class Entity {
  Board board;
  Tile tile;
  int size = 32;
  int x, y, xa, ya;
  Color color = Color.RED;

  public Entity(int x, int y, Board b) {
    this.x = x;
    this.y = y;
    board = b;
    moveTo(x, y);
  }

  public void tick() {
    move(0, 1);
  }

  public void move() {
    move(xa, ya);
  }

  public void move(int xa, int ya) {

    // if not already moving
    if (this.xa == 0 && this.ya == 0) {
      // start accelerating.
      this.xa = xa;
      this.ya = ya;

    } else {
      // otherwise, move.
      moveTo(x + xa, y + ya);

      if (x % board.getTileSize() == 0 && y % board.getTileSize() == 0) {
        this.xa = 0;
        this.ya = 0;
      }
    }

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
    g.setColor(color);
    g.fillOval(x, y, size, size);

    g.setColor(Color.black);
    g.drawOval(x, y, size, size);
  }
}
