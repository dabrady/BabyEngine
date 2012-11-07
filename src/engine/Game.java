package engine;

import engine.GFX.GUI;
import engine.GFX.InputHandler;
import engine.entity.Entity;
import engine.entity.Player;
import engine.world.Board;

public class Game extends Thread {

  protected InputHandler input;
  protected GUI gui;
  protected Board board;

  public Game() {
    input = new InputHandler();
    board = new Board(20, 10);
    gui = new GUI(this);
    gui.addKeyListener(input);
    new Entity(0, 0, board);
    new Player(0, 0, board, input);
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
    input.tick();
    board.tick();
    gui.tick();
  }

  public GUI getGUI() {
    return gui;
  }

  public static void main(String[] args) {
    Game game = new Game();
    game.start();
  }
}
