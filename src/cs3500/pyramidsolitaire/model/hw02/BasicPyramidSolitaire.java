package cs3500.pyramidsolitaire.model.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents the class cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire which implements
 * the interface PyramidSolitaireModel which contains the working, functioning and modelling of the
 * interface functions of the Pyramid Solitaire game
 */
public class BasicPyramidSolitaire implements PyramidSolitaireModel<Card> {

  // Represents the pyramidSolitaire list of list of cards
  protected List<List<Card>> pyramidSolitaireList;
  // Represents the stock pile
  protected List<Card> stockPile;
  // Represents the draw pile
  protected List<Card> drawPile;
  // Represents the length of the draw pile
  protected int drawPileLength;
  // Represents whether the game has started or not
  protected boolean hasGameStarted;

  /**
   * Represents the BasicPyramidSolitaire public default constructor.
   */
  public BasicPyramidSolitaire() {
    this.pyramidSolitaireList = new ArrayList<List<Card>>();
    this.stockPile = new ArrayList<Card>();
    this.drawPile = new ArrayList<Card>();
    this.drawPileLength = Integer.MIN_VALUE;
    this.hasGameStarted = false;
  }

  @Override
  public List<Card> getDeck() {
    List<Card> validDeck = new ArrayList<>();
    for (Suite i : Suite.values()) {
      // For each loops go through the values of the Value
      // and the cs3500.pyramidSolitaire.model.hw04.Suite of the Cards
      for (Values j : Values.values()) {
        Card currentCardInDeck = new Card(i, j);
        validDeck.add(currentCardInDeck); // Adding new cards into the ValidDeck
      }
      // returns the given deck of cards (52) of all types in any given order
      // NO validity as the cards given in the card class are in the enum format
    }
    return validDeck;
  }
  // Represents a private helper method checking the whether a deck is valid or not

  /**
   * Represents the helper function determining the validity of the deck.
   *
   * @param givenDeck Represents the deck being passed in compared to the original deck inside
   * @return Boolean true if the deck is valid based on the rules and the specifications else false
   */

  protected boolean checkDeckValidity(List<Card> givenDeck) {
    Set<Card> cardSetDeck = new HashSet<>(this.getDeck());
    Set<Card> cardSetGivenDeck = new HashSet<>(givenDeck);

    if (cardSetGivenDeck.size() == 52 && cardSetDeck.containsAll(cardSetGivenDeck)) {
      return true;
    } else {
      throw new IllegalArgumentException("The deck is null or Invalid!");
    }
  }


  @Override
  public void startGame(List<Card> deck, boolean shuffle, int numRows, int numDraw)
      throws IllegalArgumentException {
    if (deck == null) {
      throw new IllegalArgumentException("The deck is null or Invalid!");
    }
    if (numRows <= 0) {
      throw new IllegalArgumentException("The number of pyramid rows is non-positive!" + numRows
          + numDraw);
    }
    // Represents the condition when there are too many rows for the deck, that is, the maximum
    // should be 9 rows or the deck will need more than 52 cards which would be invalid
    else if (numRows > 9) {
      throw new IllegalArgumentException(
          "A full pyramid and draw pile cannot be dealt with the number of given cards in deck!");
    } else if (numDraw > (52 - numRows) + 1) {
      throw new IllegalArgumentException(
          "A full pyramid and draw pile cannot be dealt with the number of given cards in deck!");
    } else if (numDraw < 0) {
      throw new IllegalArgumentException(
          "The number of draw cards available at a time is negative!");
    }

    List<Card> cardCopy = new ArrayList<Card>(deck);
    // This above already creates a deck of valid cards since cards cannot be duplicated
    // in this set
    if (this.checkDeckValidity(cardCopy)) { // Checks the condition of the validity of the deck
      // deck is always going to be valid because of the enum suite and the values already given

      // Checks the condition of whether the deck should be shuffled or not
      // to take care of the ordering of the cards in the ArrayList for shuffling
      if (shuffle) {
        Collections.shuffle(cardCopy);
      }
      drawPileLength = numDraw;
      // Represents the number of cards in the pyramid
      int pyramidContentValue = 0;
      hasGameStarted = true;
      pyramidSolitaireList = new ArrayList<List<Card>>();

      for (int i = 0; i < numRows; i++) { // for loop for the outer list or the rows in the pyramid
        // Represents the empty list with the rows of the pyramid being added to it
        List<Card> cardsInRows = new ArrayList<>();

        for (int j = 0; j < i + 1; j++) { // for loop for the inner list or the cards in each row
          // Represents the empty row with the cards being added to it based on the rank of the row
          cardsInRows.add(cardCopy.get(pyramidContentValue)); // Adding the cards in the row
          pyramidContentValue++;
        }
        pyramidSolitaireList.add(cardsInRows);
      }
      while (pyramidContentValue < 52) {
        if (drawPile.size() < numDraw) {
          drawPile.add(cardCopy.get(pyramidContentValue));
        } else {
          stockPile.add(cardCopy.get(pyramidContentValue));
        }
        pyramidContentValue++;
      }
    }
  }


  /**
   * Represents the helper to check the arguments of the card and row indexes.
   *
   * @param row1  Represents the index of the first row
   * @param card1 Represents the index of the first card
   * @param row2  Represents the index of the second row
   * @param card2 Represents the index of the second card
   */
  protected void removeIndexCheck(int row1, int card1, int row2, int card2) {
    if (row1 < 0 || card1 < 0 || row2 < 0 || card2 < 0 ||
        card2 > 9 || row1 > 9 || card1 > 9 || row2 > 9) {
      throw new IllegalArgumentException("Index is invalid!");
    }
  }

  @Override
  public void remove(int row1, int card1, int row2, int card2)
      throws IllegalArgumentException, IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    removeIndexCheck(row1, card1, row2, card2);

    // Represents the cards in those positions
    Card firstCard = pyramidSolitaireList.get(row1).get(card1);
    Card secondCard = pyramidSolitaireList.get(row2).get(card2);

    // Represents the case when either of the attempted removes are attempted from the null areas
    removeIndexCheck(row1, card1, row2, card2);

    // Represents using the helper functions in order to check whether the cards are exposed and
    // that their sum is equal to 13
    if (isCardExposed(row1, card1)
        && isCardExposed(row2, card2)
        && isSumThirteen(firstCard, secondCard)) {
      pyramidSolitaireList.get(row1)
          .set(card1, null);
      pyramidSolitaireList.get(row2).set(card2, null);
    } else {
      throw new IllegalArgumentException("The attempted remove is invalid!");
    }
  }

  @Override
  public void remove(int row, int card) throws IllegalArgumentException, IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    // Represents the case that a card cannot be removed from a null place
    if (row < 0 || card < 0 || row >= pyramidSolitaireList.size()
        || card >= pyramidSolitaireList.get(row).size()) {
      throw new IllegalArgumentException("The attempted remove is invalid!");
    }
    if (pyramidSolitaireList.get(row).get(card) == null) {
      throw new IllegalArgumentException("The attempted remove is invalid!");
    }
    Card givenSingleCard = pyramidSolitaireList.get(row).get(card);
    if (isCardExposed(row, card)
        && givenSingleCard.getCardValues().getAction() == 13) {
      pyramidSolitaireList.get(row).set(card, null);
    } else {
      throw new IllegalArgumentException("The attempted remove is invalid!");
    }
  }

  // Represents a private helper function to check whether both the given cards are exposed or not,
  // that is, if they have a row or two cards under it covering it up or not

  /**
   * Represents checking whether the cards are exposed or not.
   *
   * @param row  Represents the index of the row of the card
   * @param card Represents the index of the given card
   * @return Returns true if the cards are exposed, else false
   */
  protected boolean isCardExposed(int row, int card) {
    if (row == pyramidSolitaireList.size() - 1) {
      return true;
    } else {
      return (pyramidSolitaireList.get(row + 1).get(card + 1) == null)
          && (pyramidSolitaireList.get(row + 1).get(card) == null);
    }
  }

  // Represents a private helper function to check whether the value of both of the given cards add
  // up to 13 and if yes, then returns true for the case of removing both the cards from the
  // pyramid

  /**
   * Represents a function that checks whether both the card values add up to 13.
   *
   * @param card1 Represents the first card in the pyramid
   * @param card2 Represents the second card in the pyramid
   * @return Returns true if the sum of the values of the cards is 13, else false
   */
  private boolean isSumThirteen(Card card1, Card card2) {
    return (card1.getCardValues().getAction() + card2.getCardValues().getAction() == 13);
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    removeDraw(drawIndex, row, card);
    if (row >= pyramidSolitaireList.size() || card >= pyramidSolitaireList.get(row).size()) {
      throw new IllegalArgumentException(
          "Invalid remove because either of the card areas are null!" +
              pyramidSolitaireList.get(row).get(card) + drawPile.get(drawIndex));
    }
    if (pyramidSolitaireList.get(row).get(card) == null
        || drawPile.get(drawIndex) == null) {
      throw new IllegalArgumentException("The attempted remove is invalid!");
    }
    Card drawCard = drawPile.get(drawIndex);
    Card givenPyramidCard = pyramidSolitaireList.get(row).get(card);
    // Represents using the helper functions in order to check whether the cards are exposed and
    // that their sum is equal to 13
    if (isCardExposed(row, card)
        && isSumThirteen(drawCard, givenPyramidCard)) {
      pyramidSolitaireList.get(row).set(card, null);
      this.discardDraw(drawIndex);
    } else {
      throw new IllegalArgumentException("The attempted remove is invalid!");
    }
  }

  /**
   * Represents the protected helper for the index check of the removeUsingDraw function.
   *
   * @param drawIndex Represents the draw index
   * @param row       Represents the index of the row
   * @param card      Represents the index of the card
   */
  protected void removeDraw(int drawIndex, int row, int card) {
    if (drawIndex < 0 || row < 0 || card < 0 || row > 9 || card > 9 || drawIndex >= getNumDraw()) {
      throw new IllegalArgumentException("Index is Invalid!");
    }
  }


  @Override
  public void discardDraw(int drawIndex) throws IllegalArgumentException, IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    if (drawIndex < 0 || drawIndex >= getNumDraw()) {
      throw new IllegalArgumentException("The index is invalid!");
    }
    if (stockPile.size() > 0) {
      drawPile.set(drawIndex, stockPile.remove(0));
    } else {
      drawPile.remove(drawIndex);
    }
  }

  @Override
  public int getNumRows() {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      return -1;
    }
    // Computes the size of the pyramidSolitaireList, which is a list of rows and the number
    // of rows in this returns and helps us to compute the height of the pyramid
    return pyramidSolitaireList.size();
  }

  @Override
  public int getNumDraw() {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      return -1;
    }
    return drawPile.size();
  }

  @Override
  public int getRowWidth(int row) throws IllegalArgumentException, IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    if (row < 0 || row > 9) {
      throw new IllegalArgumentException("The row is invalid!");
    } else {
      List<Card> givenRow = pyramidSolitaireList.get(row);
      int rowWidth = givenRow.size();
      return rowWidth;
    }
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }

    if (this.getScore() == 0) {
      return true;
    }

    List<Card> cardExposedCopy = new ArrayList<Card>();
    // Checking the case when there are no possible removes
    // Nested loop to go through all the elements in the list of the rows in the
    // pyramidSolitaireList
    for (int i = 0; i < pyramidSolitaireList.size(); i++) {
      for (int j = 0; j < getRowWidth(i); j++) {
        if (isCardExposed(i, j)) {
          // Represents the exposed card in the pyramid
          Card exposedCard = pyramidSolitaireList.get(i).get(j);
          if (exposedCard != null) {
            cardExposedCopy.add(exposedCard);
          }
        }
      }
    }
    // Loop to go through all the exposed cards list and check which all add up to 13
    // or if a single card (King) or if there are no discards possible
    for (int k = 0; k < cardExposedCopy.size() - 1; k++) {
      if (cardExposedCopy.get(k).getCardValues().getAction() == 13) {
        return false;
      }
      for (int m = 0; m < cardExposedCopy.size(); m++) {
        if (isSumThirteen(cardExposedCopy.get(k), cardExposedCopy.get(m))) {
          return false;
        }
      }
      if (getDrawCards().size() > 0) {
        return false;
      }
      for (int l = 0; l < drawPile.size() - 1; l++) {
        if (drawPile.get(l) != null) {
          if (isSumThirteen(cardExposedCopy.get(k), drawPile.get(l))) {
            return false;
          }
        }
      }
      // If the stockpile is not empty, the game is not over and the user can use a card as a draw
      // card
      if (stockPile.size() > 0) {
        return false;
      }
    }
    for (int i = 0; i < this.drawPile.size(); i++) {
      if (drawPile.get(i) != null) {
        return false;
      }
    }
    return true; // Returns true if the game is over
  }

  @Override
  public int getScore() throws IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    if (pyramidSolitaireList.size() > -1) {
      int scoreStorage = 0;
      // Checking the case when there are no possible removes
      // Nested loop to go through all the elements in the list of the rows in the
      // pyramidSolitaireList
      Card currCard;
      for (int i = 0; i < pyramidSolitaireList.size(); i++) {
        for (int j = 0; j < getRowWidth(i); j++) {
          currCard = pyramidSolitaireList.get(i).get(j);
          if (currCard != null) {
            scoreStorage += currCard.getCardValues().getAction();
          }
        }
      }
      return scoreStorage;
    } else {
      // The case when the game is won when there are no values left in the pyramidSolitaireList
      return 0;
    }
  }


  @Override
  public Card getCardAt(int row, int card)
      throws IllegalArgumentException, IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }
    if (row < 0 || card < 0 || row > 9 || card > 9) {
      throw new IllegalArgumentException("The index is invalid!");
    }
    if (pyramidSolitaireList.get(row).get(card) == null) {
      return null;
    } else {
      return pyramidSolitaireList.get(row).get(card);
    }
  }


  @Override
  public List getDrawCards() throws IllegalStateException {
    // Checks whether the game has started or not
    if (!hasGameStarted) {
      throw new IllegalStateException("The game hasn't been started yet!");
    }

    // Represents the cards that are available in the draw pile
    List<Card> drawCardCopy = new ArrayList<>();

    // Looping through the draw cards and adding the non null and valid cards in the
    // empty array list
    for (int i = 0; i < drawPile.size(); i++) {
      if (drawPile.get(i) != null) {
        drawCardCopy.add(drawPile.get(i));
      }
    }

    return drawCardCopy;
  }
}


