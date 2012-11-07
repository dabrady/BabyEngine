package engine.world;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import engine.entity.Entity;

public class Board {

  Tile[][] board;
  int numRows, numCols;

  public Board(int w, int h) {
    numCols = w;
    numRows = h;

    board = new Tile[w][h];

    // populate our tile array with tiles

    // for each row
    for (int y = 0; y < h; y++) {
      // for each column
      for (int x = 0; x < w; x++) {
        board[x][y] = new Tile(x, y);
      }
    }
  }

  public void tick() {
    for (int y = 0; y < numRows; y++) {
      for (int x = 0; x < numCols; x++) {
        board[x][y].tick();
      }
    }
  }

  // coordinates
  public Tile getTileAt(int x, int y) {
    Tile tile = null;
    System.out.printf("(%d,%d) :: ", x, y);
    x %= Tile.SIZE * numCols;
    y %= Tile.SIZE * numRows;
    x /= Tile.SIZE;
    y /= Tile.SIZE;
    System.out.printf("(%d,%d)\n", x, y);
    return board[x][y];
  }

  public int getHeight() {
    return numRows * Tile.SIZE;
  }

  public int getWidth() {
    return numCols * Tile.SIZE;
  }

  public int getTileSize() {
    return Tile.SIZE;
  }

  public void paint(Graphics g) {
    List<Entity> entities = new ArrayList<Entity>();
    for (int y = 0; y < numRows; y++) {
      for (int x = 0; x < numCols; x++) {
        Tile t = board[x][y];
        t.paint(g);
        entities.addAll(t.getEntities());
      }
    }

    for (int i = 0; i < entities.size(); i++) {
      entities.get(i).paint(g);
    }
  }

}
