package cs3500.pyramidsolitaire.controller;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the mock controller of the pyramid solitaire controller.
 */
public class MockPyramidSolitaireModel implements PyramidSolitaireModel<Object> {

  public final Appendable log;

  public MockPyramidSolitaireModel(Appendable log) {
    this.log = log;
  }

  @Override
  public List<Object> getDeck() {
    return new ArrayList<>();
  }

  @Override
  public void startGame(List<Object> deck, boolean shuffle, int numRows, int numDraw)
      throws IllegalArgumentException {
    throw new IllegalArgumentException("Invalid game start!");
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    try {
      log.append("row1: ").append(String.valueOf(row1)).append("\n");
      log.append("card1: ").append(String.valueOf(card1)).append("\n");
      log.append("row2: ").append(String.valueOf(row2)).append("\n");
      log.append("card2: ").append(String.valueOf(card2));
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }

  }

  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {
    try {
      log.append("row: ").append(String.valueOf(row)).append("\n");
      log.append("card: ").append(String.valueOf(card));
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }

  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    try {
      log.append("drawIndex: ").append(String.valueOf(drawIndex)).append("\n");
      log.append("row: ").append(String.valueOf(row)).append("\n");
      log.append("card: ").append(String.valueOf(card));
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }


  }

  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {
    try {
      log.append("drawIndex: ").append(String.valueOf(drawIndex));
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }

  }

  @Override
  public int getNumRows() {
    return 0;
  }

  @Override
  public int getNumDraw() {
    return 0;
  }

  @Override
  public int getRowWidth(int row) {
    return 0;
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    return false;
  }

  @Override
  public int getScore() throws IllegalStateException {
    return 0;
  }

  @Override
  public Object getCardAt(int row, int card) throws IllegalStateException {
    return new Object();
  }

  @Override
  public List<Object> getDrawCards() throws IllegalStateException {
    return new ArrayList<>();
  }
}
