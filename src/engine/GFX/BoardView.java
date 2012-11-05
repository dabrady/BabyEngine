package engine.GFX;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import engine.world.Board;

public class BoardView extends JPanel {

  Board board;

  public BoardView(Board b) {
    this.board = b;
  }

  public void setBoard(Board b) {
    this.board = b;
  }

  public Dimension getPreferredSize() {
    return new Dimension(board.getWidth(), board.getHeight());
  }

  public void paintComponent(Graphics g) {
    board.paint(g);
  }
}
