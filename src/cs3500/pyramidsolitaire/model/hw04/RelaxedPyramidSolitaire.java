package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the class cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire which implements
 * the interface PyramidSolitaireModel which contains the working, functioning and modelling of the
 * interface functions of the Pyramid Solitaire game with one difference and exception as compared
 * to the original BasicPyramidSolitaire model. The RelaxedPyramidSolitaire model can remove not
 * only the pair of cards that are fully exposed and add up to thirteen, but also the ones when one
 * card is covered by another exposed card but add up to thirteen.
 */
public class RelaxedPyramidSolitaire extends BasicPyramidSolitaire
    implements PyramidSolitaireModel<Card> {


  // Represents the public constructor for this class to initialize all the instances and global
  // variables or fields in the BasicPyramidSolitaire class using the super() keyword
  public RelaxedPyramidSolitaire() {
    super();
    this.pyramidSolitaireList = new ArrayList<List<Card>>();
  }

  // Represents a private helper function to check whether both the given cards are exposed or not,
  // that is, if they have a row or two cards under it covering it up or not

  /**
   * Represents checking whether the cards are exposed or not with the exception of the
   * RelaxedPyramidSolitaire case when the pair of cards with a card being covered by only a single
   * card pairs up with that card to add up to a sum of thirteen, the two cards card be removed.
   *
   * @param row  Represents the index of the row of the card
   * @param card Represents the index of the given card
   * @return Boolean  Returns true if the cards are exposed, else false
   */

  @Override
  protected boolean isCardExposed(int row, int card) {
    if (row == this.pyramidSolitaireList.size() - 1) {
      return true;
    } else {
      return (this.pyramidSolitaireList.get(row + 1).get(card + 1) == null)
          || (this.pyramidSolitaireList.get(row + 1).get(card) == null);
    }
  }
}
