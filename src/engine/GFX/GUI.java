package engine.GFX;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import engine.Game;
import engine.world.Board;

public class GUI {
  Game game;
  JFrame frame = new JFrame("Wat!");
  BoardView boardView;

  public GUI(Game g) {
    this.game = g;
    boardView = new BoardView(game.getBoard());
    frame.setContentPane(boardView);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
  }

  public void tick() {
    frame.repaint();
  }

  public void setMap(Board board) {
    this.boardView.setBoard(board);
    frame.pack();
  }

  public void addKeyListener(KeyListener kl) {
    frame.addKeyListener(kl);
  }
}
