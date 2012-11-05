package engine;

import engine.GFX.GUI;
import engine.GFX.InputHandler;
import engine.entity.Entity;
import engine.world.Board;

public class Game extends Thread {

  protected InputHandler inputz;
  protected GUI gui;
  protected Board board;

  public Game() {
    inputz = new InputHandler();
    this.board = new Board(20, 10);
    gui = new GUI(this);
    gui.addKeyListener(inputz);
  }

  public void run() {

    while (true) {

      tick();

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public Board getBoard() {
    return board;
  }

  public void tick() {
    System.out.println("tick!");
    inputz.tick();
    board.tick();
    gui.tick();
  }

  public GUI getGUI() {
    return gui;
  }

  public static void main(String[] args) {
    Game game = new Game();
    new Entity(0, 0, game.getBoard(), inputz);
    game.start();

  }
}
