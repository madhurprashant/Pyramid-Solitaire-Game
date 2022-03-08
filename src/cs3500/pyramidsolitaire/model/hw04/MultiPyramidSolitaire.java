package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents the MultiPyramidSolitaire class which extends the BasicPyramidSolitaire class with the
 * same functionalities except from when the game is played with a larger board anf a larger deck
 * and so the start game function in this class is modified and therefore, after extending it
 * implements the PyramidSolitaireModel which functions as a new functionality or modification added
 * to the PyramidSolitaire game where the model uses a larger board and a larger deck of cards with
 * the elements of the number of models merged from half the height of the models and rounded up.
 */
public class MultiPyramidSolitaire extends BasicPyramidSolitaire
    implements PyramidSolitaireModel<Card> {

  /**
   * Represents the public constructor for the class MultiPyramidSolitaire which deals a game with a
   * larger board and a larger deck of cards with a super to inherit the fields from the original
   * BasicPyramidSolitaire class.
   */
  // Represents the public constructor for this class to initialize all the instances and global
  // variables or fields in the BasicPyramidSolitaire class using the super() keyword
  public MultiPyramidSolitaire() {
    super();
  }

  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numRows, int numDraw)
      throws IllegalArgumentException {
    if (deck == null && deck.size() != 104) {
      throw new IllegalArgumentException("The deck is null or Invalid!");
    }
    if (numRows <= 0) {
      throw new IllegalArgumentException("The number of pyramid rows is non-positive!" + numRows
          + numDraw);
    }
    // Represents the condition when there are too many rows for the deck, that is, the maximum
    // should be 9 rows or the deck will need more than 104 cards which would be invalid
    else if (numRows > 9) {
      throw new IllegalArgumentException(
          "A full pyramid and draw pile cannot be dealt with the number of given cards in deck!");
    } else if (numDraw < 0) {
      throw new IllegalArgumentException(
          "The number of draw cards available at a time is negative!");
    }

    List<Card> cardCopy = new ArrayList<Card>(deck);
    // This above already creates a deck of valid cards
    if (this.checkDeckValidity(cardCopy)) { // Checks the condition of the validity of the deck
      // deck is always going to be valid because of the enum suite and the values already given

      // Checks the condition of whether the deck should be shuffled or not
      // to take care of the ordering of the cards in the ArrayList for shuffling
      if (shuffle) {
        Collections.shuffle(cardCopy);
      }
      this.drawPileLength = numDraw;
      // Represents the number of cards in the pyramid
      int pyramidContentValue = 0;
      this.hasGameStarted = true;
      this.pyramidSolitaireList = new ArrayList<List<Card>>();
      // Represents the number of spaces between the card clusters
      int spaces = 0;
      // Represents the number of non-overlapping rows
      int numberOfNonOverlappingRows = 0;
      // Represents the value of the number of cards in each of the three clusters in the
      // non-overlapping rows
      int clusterCount = 0;
      // Represents the number of cards present in each of the row
      int cardCount = 0;
      // Represents the overlapping index
      int overlapIndex = 0;
      if (numRows % 2 != 0) {
        overlapIndex = (numRows / 2) + 1;
      } else {
        overlapIndex = numRows / 2;
      }
      numberOfNonOverlappingRows = numRows - overlapIndex;

      // Represents the for loops in order to get into the rows and the columns of the MultiPyramid
      for (int i = 0; i < numRows; i++) {
        // Represents the total number of spaces between the card clusters
        spaces = (int) Math.max(0, Math.floor(numRows / 2) - 1 - i);

        // Represents the number of cards in each of the given cluster
        cardCount = getRowWidthGame(i, numRows) - (spaces * 2);
        clusterCount = cardCount / 3;

        List<Card> cardsInRows = new ArrayList<>();
        for (int j = 0; j < getRowWidthGame(i, numRows); j++) {

          // Represents adding the null areas to the coordinates where no cards are supposed to be
          // present in the given MultiPyramidSolitaire list
          if ((j >= clusterCount && j < (clusterCount + spaces)) ||
              (j >= (clusterCount * 2) + spaces && j < (clusterCount * 2) + (spaces * 2))) {
            cardsInRows.add(null);
          } else {
            cardsInRows.add(cardCopy.get(pyramidContentValue));
            pyramidContentValue++;
          }

        }
        pyramidSolitaireList.add(cardsInRows);
      }
      if (numDraw > (104 - pyramidContentValue)) {
        throw new IllegalArgumentException(
            "A full pyramid and draw pile cannot be dealt with the number of given cards in deck!");
      }

      while (pyramidContentValue < 104) {
        if (this.drawPile.size() < numDraw) {
          this.drawPile.add(cardCopy.get(pyramidContentValue));
        } else {
          this.stockPile.add(cardCopy.get(pyramidContentValue));
        }
        pyramidContentValue++;
      }
    }
  }

  /**
   * Represents the index check for the remove function for the MultiPyramidSolitaire game.
   *
   * @param row1  Represents the index of the first row
   * @param card1 Represents the index of the first card
   * @param row2  Represents the index of the second row
   * @param card2 Represents the index of the second card
   */
  @Override
  protected void removeIndexCheck(int row1, int card1, int row2, int card2) {
    if (row1 < 0 || card1 < 0 || row2 < 0 || card2 < 0 ||
        card2 > 15 || row1 > 9 || card1 > 15 || row2 > 9) {
      throw new IllegalArgumentException("Index is invalid!");
    }
  }

  /**
   * Represents the protected helper for the index check of the removeUsingDraw function.
   *
   * @param drawIndex Represents the draw index
   * @param row       Represents the index of the row
   * @param card      Represents the index of the card
   */
  @Override
  protected void removeDraw(int drawIndex, int row, int card) {
    if (drawIndex < 0 || row < 0 || card < 0 || row > 9 || card > 15 || drawIndex >= getNumDraw()) {
      throw new IllegalArgumentException("Index is Invalid!");
    }
  }


  /**
   * Represents the function getDeck that obtains the combined deck of cards containing the two deck
   * of cards used for playing the MultiPyramidSolitaire game.
   *
   * @return the combined deck of cards as a list
   */
  @Override
  public List<Card> getDeck() {
    // Represents the first valid deck with 52 cards of each card appearing once in the deck
    List<Card> validFirstDeck = super.getDeck();
    // Represents the total valid deck with 104 cards of each unique card appearing twice in the
    // combined deck of two separate deck of cards
    List<Card> totalValidDeck = super.getDeck();

    // Represents adding the first valid deck in the totalValidDeck in order to contain two valid
    // decks to contain 104 cards and a unique card to appear twice
    totalValidDeck.addAll(validFirstDeck);
    return totalValidDeck;
  }

  // Represents a private helper method checking the whether a deck is valid or not in the case of
  // this MultiPyramidSolitaire game model

  /**
   * Represents the helper function determining the validity of the deck for the case of this
   * MultiPyramidSolitaire game model.
   *
   * @param givenDeck Represents the deck being passed in compared to the original deck inside
   * @return Boolean true if the deck is valid based on the rules and the specifications else false
   */

  @Override
  protected boolean checkDeckValidity(List<Card> givenDeck) {
    Set<Card> cardSetDeck = new HashSet<>(this.getDeck());
    // Represents the conversion of the HashSet of the first deck into an ArrayList of Cards
    List<Card> firstGivenDeck = new ArrayList<Card>(cardSetDeck);
    Set<Card> cardSetDeck2 = new HashSet<>(this.getDeck());
    // Represents the conversion of the HashSet of the second deck into an ArrayList of Cards
    List<Card> secondGivenDeck = new ArrayList<Card>(cardSetDeck2);
    // Represents the deck of the two deck of cards combined with two copies of each unique card in
    // it
    List<Card> combinedDeck = new ArrayList<Card>();
    // Represents adding the first deck into the combined deck of cards
    combinedDeck.addAll(firstGivenDeck);
    // Represents adding the second deck into the combined deck of cards already containing the
    // first deck of cards
    combinedDeck.addAll(secondGivenDeck);

    if (givenDeck.size() == 104 && combinedDeck.containsAll(givenDeck)) {
      return true;
    } else {
      throw new IllegalArgumentException("The deck is null or Invalid!");
    }
  }

  /**
   * Represents the helper function for getting the row width for the startGame function.
   *
   * @param row     Represents the row index
   * @param numRows Represents the number of rows in the MultiPyramidSolitaire game model
   * @return Integer   Represents the returned row width
   */
  private int getRowWidthGame(int row, int numRows) {
    // Checks whether the game has started or not
    if (!this.hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    if (numRows > 9 || numRows < 0) {
      throw new IllegalArgumentException("Invalid amount of rows!");
    }
    if (row < 0 || row > 9) {
      throw new IllegalArgumentException("The row is invalid!");
    } else {
      int rowWidth = ((numRows / 2) * 2) + (row + 1);
      return rowWidth;
    }
  }

  /**
   * Represents the width of the row in the case of when a MultiPyramidSolitaire game model is dealt
   * with.
   *
   * @param row the desired row (0-indexed)
   * @return Integer the desired row width of the row
   * @throws IllegalArgumentException When the indexes are invalid
   * @throws IllegalStateException    When the game has not been started
   */
  @Override
  public int getRowWidth(int row) throws IllegalArgumentException, IllegalStateException {
    if (!this.hasGameStarted) {
      throw new IllegalStateException("Game has not been started!");
    }
    if (row < 0 || row > 9) {
      throw new IllegalArgumentException("Invalid rows!");
    }
    return getRowWidthGame(row, getNumRows());
  }

  @Override
  public Card getCardAt(int row, int card) throws IllegalArgumentException, IllegalStateException {
    // Checks whether the game has started or not
    if (!this.hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    if (row < 0 || card < 0 || row > 9 || card > 15) {
      throw new IllegalArgumentException("The index is invalid!");
    }
    if (this.pyramidSolitaireList.get(row).get(card) == null) {
      return null;
    } else {
      return this.pyramidSolitaireList.get(row).get(card);
    }
  }
}