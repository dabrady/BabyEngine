package engine.world;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import engine.entity.Entity;

public class Tile {
  int x;
  int y;
  final static int SIZE = 32;
  ArrayList<Entity> entities = new ArrayList<Entity>();

  public Tile(int x, int y) {
    this.x = x * Tile.SIZE;
    this.y = y * Tile.SIZE;
  }

  public void tick() {
    for (Entity entity : entities) {
      entity.tick();
    }
  }

  public void removeEntity(Entity entity) {
    entities.remove(entity);
  }

  public void addEntity(Entity entity) {
    entities.add(entity);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void paint(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(x, y, Tile.SIZE, Tile.SIZE);

    g.setColor(Color.BLACK);
    g.drawRect(x, y, Tile.SIZE, Tile.SIZE);

    for (Entity e : entities) {
      e.paint(g);
    }
  }
}
