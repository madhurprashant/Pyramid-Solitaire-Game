package cs3500.pyramidsolitaire.view;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.IOException;

/**
 * Represents the class PyramidSolitaireTextualView which renders the model based on the the case of
 * the function of the game or the score and hence, prints and displays the model.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {

  private final PyramidSolitaireModel<?> model;
  // Not specifying any other fields

  // Represents the Appendable ap that transmits the output to the user and so
  // this is used in the second constructor have the function toString() to be used in
  // other scenarios in the controller to play the game
  private Appendable ap;

  /**
   * Represents the public constructor for the PyramidSolitaireTextualView with the field model in
   * order to display and render the model.
   *
   * @param model Represents the model to be viewed.
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
  }

  // Represents the second public constructor that takes in both a model and an Appendable, and
  // implement render such that it appends the current textual output to that Appendable.
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable ap) {
    this.model = model;
    this.ap = ap;
  }

  /**
   * Represents the function toString which converts the given pyramidModel into the string in order
   * to render the model.
   *
   * @return String       Represents the rendering of the pyramid model based on the game state.
   */
  @Override
  public String toString() {
    // Represents the empty string with all the cards added to it
    String modelCopy = "";
    // Represents the case of the string returned when the game has not started
    try {
      this.model.getScore();
    } catch (IllegalStateException e) {
      // Returns the empty string while rendering the model when the game has not started and when
      // the current score of the model returns -1 which shows that the game has not started
      return "";
    }
    if (this.model.getScore() == 0 && this.model.isGameOver()) {
      // Returns the empty string while rendering the model when the game has been won
      // and the score is finally 0
      return "You win!";
    } else if (this.model.isGameOver() && this.model.getScore() != 0) {
      // Represents the score of the model at that given time
      int currentScoreOfModel = 0;
      currentScoreOfModel = this.model.getScore();
      // Returns the string when the case of the pyramid solitaire game being over is true
      return "Game over. Score: " + String.valueOf(currentScoreOfModel);
    } else {
      for (int i = 0; i < this.model.getNumRows(); i++) {
        String emptyCard = " ";
        modelCopy += emptyCard.repeat((this.model.getNumRows() - i - 1) * 2);
        for (int j = 0; j < this.model.getRowWidth(i); j++) {
          String cardInString = "";
          if (this.model.getCardAt(i, j) != null) {
            cardInString = this.model.getCardAt(i, j).toString();
          }
          // Representing all the cases of the cards in the pyramid solitaire game model
          modelCopy = modelCopy + cardInString;
          if (this.model.getCardAt(i, j) == null && j == this.model.getRowWidth(i) - 1) {
            modelCopy += ".";
          } else if (cardInString.length() == 2 && j == this.model.getRowWidth(i) - 1) {
            modelCopy += "";
          } else if (cardInString.length() == 3 && j == this.model.getRowWidth(i) - 1) {
            modelCopy += "";
          } else if (cardInString.length() == 2) {
            modelCopy += "  ";
          } else if (cardInString.length() == 3) {
            modelCopy += " ";
          } else if (j == this.model.getRowWidth(i) - 1 && this.model.getCardAt(i, j) == null) {
            modelCopy += ".";
          } else if (this.model.getCardAt(i, j) == null) {
            modelCopy += ".   ";
          }
        }
        modelCopy += "\n";
      }
      if (this.model.getDrawCards().size() == 0) {
        modelCopy += "Draw:";
      }
      if (this.model.getDrawCards().size() > 0) {
        modelCopy += "Draw: ";
        for (int i = 0; i < this.model.getDrawCards().size(); i++) {
          String drawCardIntoString = "";
          // make sure that the card is not null
          if (i != this.model.getDrawCards().size() - 1) {
            drawCardIntoString = this.model.getDrawCards().get(i).toString() + ", ";
          } else {
            drawCardIntoString = this.model.getDrawCards().get(i).toString();
          }
          modelCopy += drawCardIntoString;
        }
      }
      return modelCopy;
    }
  }

  @Override
  public void render() throws IOException {
    // Represents rendering the model in the for of appending it to transmit the
    // output to the user
    this.ap.append(this.toString());
  }
}


