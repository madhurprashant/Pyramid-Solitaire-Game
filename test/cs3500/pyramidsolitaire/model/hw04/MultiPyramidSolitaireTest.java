package cs3500.pyramidsolitaire.model.hw04;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Suite;
import cs3500.pyramidsolitaire.model.hw02.Values;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents the tests for the MultiPyramidSolitaire class.
 */
public class MultiPyramidSolitaireTest {


  private PyramidSolitaireModel<Card> firstValidModel;
  private PyramidSolitaireModel<Card> firstValidModelGameOver;
  private PyramidSolitaireTextualView viewModel;
  private PyramidSolitaireTextualView viewModelGameOver;
  private List<Card> validDeck;
  private List<Card> invalidDeck;
  private int sizeOfDeck;

  /**
   * Represents the init data with the examples of the class to be used for testing purposes.
   */

  @Before
  public void initTests() {

    // Represents the example of a working valid pyramid solitaire list game model
    firstValidModel = new MultiPyramidSolitaire();

    // Represents the textual view of the given working firstValidModel game state
    viewModel = new PyramidSolitaireTextualView(
        firstValidModel);

    // Represents the example of a working valid pyramid solitaire list game model
    // used to help in the tests of the isGameOver() function
    firstValidModelGameOver = new MultiPyramidSolitaire();

    // Represents the textual view of the given working firstValidModelGameOver game state
    viewModelGameOver = new PyramidSolitaireTextualView(
        firstValidModelGameOver);

    // Represents the valid deck used for examples with 104 cards with 4 different suites
    // and 13 different cards in each suite with each unique duplicate
    validDeck = new ArrayList<Card>();

    // Represents the deck which is modified to have the king at the top instead of the ace
    // to test if the game wins
    // modifiedDeck = new ArrayList<Card>(

    // Represents the invalid deck example used for the exceptions in the game that throw
    // IllegalArgumentExceptions for example when the deck does not have 104 cards, 4 suites or
    // 13 different cards in each
    invalidDeck = new ArrayList<Card>();

    // Represents the size of the Invalid deck
    sizeOfDeck = invalidDeck.size();

    // Represents the boolean field which determines whether the game has started or not and hence
    // is false by default until startGame function is called on it
    boolean hasGameStarted = false;
  }

  /**
   * Represents the tests for the getDeck function taking into consideration the validity of the
   * deck in the case of the valid deck being returned when getDeck is called on the model in the
   * case of a multi pyramid model.
   */
  @Test
  public void getMultiDeckTest() {
    initTests();
    // Represents the formation of a valid deck
    for (Suite i : Suite.values()) {
      // For each loops go through the values of the Value
      // and the cs3500.pyramidSolitaire.model.hw04.Suite of the Cards
      for (Values j : Values.values()) {
        Card currentCardInDeck = new Card(i, j);
        validDeck.add(currentCardInDeck); // Adding new cards into the ValidDeck
        // returns the given deck of cards (52) of all types in any given order
        // No validity as the cards given in the card class are in the enum format
      }
    }

    // The function cannot return a deck with an invalid card since the type of the cards
    // is controlled by the enum classes and so only the size is checked whether it sums up
    // to 104 while checking the the test for the getDeck function called on the firstValidModel

    // Represents the test for the valid deck when it is called on the firstValidModel
    // which then returns a valid deck with all the 52 cards and 4 different suites with
    // 13 different cards in each different suite

    // Represents multipyling the valid deck's size by 2 in order to get the correct size for the
    // multipyramid solitaire model that is (52 * 2 = 104)
    assertEquals(validDeck.size() * 2, firstValidModel.getDeck().size());
  }

  /**
   * Represents the tests for the start game function to check whether the game has started in the
   * case of having different parameters like checking if a valid deck is given in and if not,
   * throws IllegalArgumentExceptions for different number of rows, draw cards or the type of the
   * deck or if it is shuffled or not in the case of when a MultiPyramid is dealt with.
   */

  // Represents the game which is shuffled its deck in the starting of the game in the case of a
  // MultiPyramid
  @Test
  public void startMultiGameShuffledDeck() {
    initTests();
    // Testing a valid deck, valid number of rows, draw cards and the number of cards
    // leading to a game to be properly started which is shuffled

    // Represents a model which is not shuffled
    PyramidSolitaireModel<Card> gameFalseShuffle = new MultiPyramidSolitaire();
    // Starting the game for the firstValidModel
    firstValidModel.startGame(firstValidModel.getDeck(), true, 7, 3);

    assertNotEquals(firstValidModel.getCardAt(0, 0), firstValidModel.getDeck().get(0));
  }

  /**
   * Represents the game which is does not shuffle its deck in the starting of the game in the case
   * of when a MultiPyramidSolitaire model is dealt with.
   */
  @Test
  public void startMutliGameNonShuffledDeck() {
    initTests();
    // Testing a valid deck, valid number of rows, draw cards and the number of cards
    // leading to a game to be properly started which is not shuffled

    // Represents a model which is not shuffled
    PyramidSolitaireModel<Card> gameFalseShuffle = new BasicPyramidSolitaire();
    // Starting the game for the firstValidModel with no shuffling
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);

    assertEquals(firstValidModel.getCardAt(0, 0), firstValidModel.getDeck().get(0));
  }

  /**
   * Testing a deck which is either null or invalid when a multi pyramid is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startGameWithMultiNullDeck() {
    initTests();
    // Representing the creation of an invalid deck
    // Represents the invalid deck example used for the exceptions in the game that throw
    // IllegalArgumentExceptions for example when the deck does not have 104 cards, 4 suites or
    // 13 different cards in each with a duplicate for each one of the card in the double deck
    invalidDeck = null;
    firstValidModel.startGame(invalidDeck, true, 7, 1);
  }

  /**
   * Testing a deck which is null and hence throws an IllegalArgumentException when a multi pyramid
   * is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithNullDeck() {
    initTests();
    // Represents the invalid deck example used for the exceptions in the game that throw
    // IllegalArgumentExceptions for example when the deck does not have 104 cards, 4 suites or
    // 13 different cards in each
    sizeOfDeck = 10;
    // Represents when the deck is invalid and is not the size of 52
    firstValidModel.startGame(invalidDeck, true, 9, 2);
  }

  /**
   * Testing a deck which is contains non-positive amount of rows which hence throws an
   * IllegalArgumentException when a multi pyramid is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithNonPositiveRows() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), true, -10, 1);
  }

  /**
   * Testing a deck which is contains non-positive amount of rows which hence throws an
   * IllegalArgumentException when a multi pyramid is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithNonPositiveRows1() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), true, -12, 1);
  }

  /**
   * Testing a deck which is at that time contains the number of draw cards that is negative when a
   * multi pyramid is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithNegativeDrawCards() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), true, 6, -5);
  }

  /**
   * Testing a deck which is at that time contains the number of draw cards that is negative when a
   * multi pyramid is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithNegativeDrawCards1() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), true, 9, -1);
  }

  /**
   * Testing a full pyramid and draw pile cannot be dealt with the number of given cards in deck
   * where the number of rows might exceed the maximum limit when a multi pyramid is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithExceedingRows() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), true, 13, 5);
  }

  /**
   * Testing a full pyramid and draw pile cannot be dealt with the number of given cards in deck
   * where the number of draw cards might exceed the maximum limit when a multi pyramid is dealt
   * with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithExceedingDrawCards() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), true, 7, 60);
  }

  /**
   * Testing a full pyramid and draw pile cannot be dealt with the number of given cards in deck
   * where the all the values are invalid when a multi pyramid is dealt with.
   */
  @Test(expected = IllegalArgumentException.class)
  public void startMultiGameWithAllInvalidValues() {
    initTests();
    sizeOfDeck = -2;
    firstValidModel.startGame(invalidDeck, true, -3, 51);
  }

  /**
   * Represents the tests for the remove function that removes two exposed cards from the deck that
   * add up to 13 when a multi pyramid is dealt with.
   */
  @Test
  public void removeTwoCardsMultiSuccess() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);
    PyramidSolitaireTextualView viewModel = new PyramidSolitaireTextualView(firstValidModel);
    System.out.println(viewModel.toString());

    assertEquals("2♥", firstValidModel.getCardAt(6, 2).toString());

    assertEquals("J♥", firstValidModel.getCardAt(6, 11).toString());

    // Representing starting the game
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(6, 2, 6, 11);
    // Represents returning null in the case of getting a card from that given index after
    // the card has been removed which then returns a null
    // Case 1:
    assertEquals(null, firstValidModel.getCardAt(6, 2));

    // Case 2:
    assertEquals(null, firstValidModel.getCardAt(6, 11));

    assertEquals("3♥", firstValidModel.getCardAt(6, 3).toString());

    assertEquals("10♥", firstValidModel.getCardAt(6, 10).toString());

    // Represents another case of when two valid exposed cards adding up to 13 are removed
    // from the deck
    firstValidModel.remove(6, 3, 6, 10);

    // Case 1:
    assertEquals(null, firstValidModel.getCardAt(6, 3));

    // Case 2:
    assertEquals(null, firstValidModel.getCardAt(6, 10));
  }

  /**
   * Represents the case of when the remove function of removing two exposed cards adding up to 13
   * is invalid due to some reasons and hence, throws an IllegalArgumentException in the case of a
   * MultiPyramidSolitaire model.
   */

  // Represents the test of which throws an IllegalStateException since the game was never started
  // and a remove was attempted
  @Test(expected = IllegalStateException.class)
  public void removeMultiTwoCardsGameNotStarted() {
    initTests();
    PyramidSolitaireTextualView viewModel = new PyramidSolitaireTextualView(firstValidModel);
    System.out.println(viewModel.toString());

    assertEquals("2♥", firstValidModel.getCardAt(6, 2).toString());

    assertEquals("J♥", firstValidModel.getCardAt(6, 11).toString());

    // Representing starting the game
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(6, 2, 6, 11);
    // Represents returning null in the case of getting a card from that given index after
    // the card has been removed which then returns a null
    // Case 1:
    assertEquals(null, firstValidModel.getCardAt(6, 2));

    // Case 2:
    assertEquals(null, firstValidModel.getCardAt(6, 11));

    assertEquals("3♥", firstValidModel.getCardAt(6, 3).toString());

    assertEquals("10♥", firstValidModel.getCardAt(6, 10).toString());

    // Represents another case of when two valid exposed cards adding up to 13 are removed
    // from the deck
    firstValidModel.remove(6, 3, 6, 10);
  }

  // Represents the test of which throws an IllegalArgumentException since the
  // remove is invalid because the given card being taken in is not exposed or
  // does not have a combination with the other card to add up to 13 in the case of a multipyramid
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiTwoCardsInvalidRemove() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);
    PyramidSolitaireTextualView viewModel = new PyramidSolitaireTextualView(firstValidModel);
    System.out.println(viewModel.toString());
    // Representing starting the game
    // Represents the test for the remove function for this gameRemoveCard model
    // Represents the test for the remove function for this gameRemoveCard model
    // Represents the cards that are not exposed
    firstValidModel.remove(2, 1, 3, 2);
    // The above remove calling will throw an IllegalArgumentException due to the
    // cards not being exposed and not being able to add up to 13
  }

  // Represents the test of which throws an IllegalArgumentException since the
  // remove is invalid because the given card being taken in is attempted to
  // be taken from an index of a card that has already been removed, that is, from
  // a null area, throwing an IllegalArgumentException in the case of a multipyramid
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiTwoCardsInvalidRemoveFromNullArea() {
    initTests();
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);
    PyramidSolitaireTextualView viewModel = new PyramidSolitaireTextualView(firstValidModel);
    System.out.println(viewModel.toString());
    // Representing starting the game

    // Representing starting the game

    assertEquals("2♥", firstValidModel.getCardAt(6, 2).toString());

    assertEquals("J♥", firstValidModel.getCardAt(6, 11).toString());

    // Representing starting the game
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(6, 2, 6, 11);
    // Represents returning null in the case of getting a card from that given index after
    // the card has been removed which then returns a null
    // Case 1:
    firstValidModel.remove(6, 2, 6, 11);
  }


  /**
   * Represents the case of when the remove function of removing two exposed cards adding up to 13
   * is invalid due to some reasons and hence, throws an IllegalArgumentException in the case of a
   * multipyramid.
   */

  // Represents the case of when the cards are not exposed but add to 13
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiTwoCardsNotExposed() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Represents the test for the remove function for this gameRemoveCard model

    // Remove attempted for cards that are not exposed but still add up to thirteen should
    // give an IllegalArgumentException
    firstValidModel.remove(1, 1, 3, 3);
  }

  // Represents the case of when the cards are exposed but do not add up to 13 in the case of a
  // multipyramid
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiTwoCardsNotThirteen() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Represents the test for the remove function for this gameRemoveCard model

    // Remove attempted for cards that are not exposed but still add up to thirteen should
    // give an IllegalArgumentException
    firstValidModel.remove(6, 0, 6, 1);
    // The above cards are exposed but add up to be (10 + 9 != 13)
  }

  // Represents the case of when the cards are not exposed as well as do not add up to be 13
  // in the case of a multipyramid
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiTwoCardsNotThirteenOrExposed() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Represents the test for the remove function for this gameRemoveCard model

    // Remove attempted for cards that are not exposed but still add up to thirteen should
    // give an IllegalArgumentException
    firstValidModel.remove(3, 2, 5, 5);
    // The above cards are not exposed and add up to be (9 + 8 != 13)
  }

  // Represents the case of when the cards from the null positions are attempted to be removed
  // in the case of a multipyramid
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiTwoCardsFromNullAreas() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Removing the pair of exposed and sum of 13 cards from the pyramid
    firstValidModel.remove(6, 2, 6, 6);
    // Represents the test for the remove function for this gameRemoveCard model

    // Remove attempted for cards that are not exposed but still add up to thirteen should
    // give an IllegalArgumentException
    // Representing removing from null areas
    firstValidModel.remove(6, 2, 6, 6);
    // The above cards are not exposed and add up to be (9 + 8 != 13)
  }

  /**
   * Represents the tests for the remove function when the game has started and the card to be
   * removed is a king and it is exposed in the case of a multipyramid.
   */
  @Test
  public void removeSingleCardKingExposed() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    // Represents getting the card before it was removed
    assertEquals("K♣", firstValidModel.getCardAt(6, 0).toString());
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(6, 0);

    // Represents returning null in the case of getting a card from that given index after
    // the card has been removed which then returns a null
    assertEquals(null, firstValidModel.getCardAt(6, 0));
  }

  /**
   * Represents the tests for the remove function when the game has not started.
   */
  @Test(expected = IllegalStateException.class)
  public void removeSingleCardGameNotStarted() {
    initTests();
    // The game is not started since the function startGame was never called on the model

    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(6, 4);

    // Represents returning null in the case of getting a card from that given index after
    // the card has been removed which then returns a null
    assertEquals(null, firstValidModel.getCardAt(6, 4));
  }

  /**
   * Represents the tests for the remove function when the card being removed is not exposed or adds
   * up to thirteen or is null, and hence, gives an IllegalArgumentException in the case of a
   * multipyramid.
   */

  // Represents when the card is not exposed
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiSingleCardInvalidRemoveNotExposed() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(2, 1);
  }

  /**
   * Represents the tests for the remove function when the card being removed is not exposed or adds
   * up to thirteen or is null, and hence, gives an IllegalArgumentException in the case of a
   * multipyramid.
   */

  // Represents when the card does not add up to thirteen or is not a King
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiSingleCardInvalidRemoveNotKing() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(4, 2);
  }

  /**
   * Represents the tests for the remove function when the card being removed is not exposed or adds
   * up to thirteen or is null, and hence, gives an IllegalArgumentException in the case of a
   * multipyramid.
   */
  // Represents all three cases: When the card is not exposed and the sum is not 13 or the card is
  // null
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiSingleCardInvalidRemove() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.remove(2, 1); // Not exposed and not equals to 13

    // Another example
    firstValidModel.remove(0, 0);

  }

  // Represents the case when a king is attempted to be removed from a place form where it already
  // has been removed in the case of a multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiSingleCardNullAttempt() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    // Represents removing the exposed king from the pyramid
    firstValidModel.remove(6, 0);

    // Now representing the attempt to again remove the card from the place from where the king
    // was removed already
    firstValidModel.remove(6, 0); // Represents a null card since a king was removed from
    // this position

  }

  /**
   * Represents the testing of the function removeUsingDraw that removes the exposed card from the
   * pyramid that sums up to be 13 from one of the cards in the draw pile which is then paired up
   * and removed as well in the case of a multipyramid.
   */
  @Test
  public void removeMultiUsingDrawTest() {
    initTests();
    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());
    // Case 1:
    assertEquals("Q♥", firstValidModel.getCardAt(6, 12).toString());
    System.out.println(viewModel.toString());
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.removeUsingDraw(1, 6, 12);
    System.out.println(viewModel.toString());
    // Represents returning null in the case of getting a card from that given index after
    // the card has been removed which then returns a null
    // Case 1:
    assertEquals(null, firstValidModel.getCardAt(6, 12));
    // This will return null because 10 of diamonds will be removed along with
    // 3 of spades from the draw pile

  }

  // Represents the test when the remove is attempted from the draw pile and the pyramid
  // when the game has not started leading to throw an IllegalStateException in the case of a
  // multi pyramid
  @Test(expected = IllegalStateException.class)
  public void removeMultiUsingDrawTestGameNotStarted() {
    initTests();
    // Represents the test for the remove function for this gameRemoveCard model
    firstValidModel.removeUsingDraw(0, 3, 1);

    // Represents another case of when two valid exposed cards adding up to 13 are removed
    // from the deck
    firstValidModel.removeUsingDraw(1, 4, 3);

  }

  // Represents the test when the remove is attempted and it is invalid because the card
  // in the pyramid is not exposed or does not add up to be thirteen with the draw card
  // or the draw pile card does not add up with in the case of a multipyramid
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardNotExposed() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);

    // Represents the test for the remove function for this gameRemoveCard model
    // with a card in the pyramid that is being attempted to get removed but it is
    // not exposed
    firstValidModel.removeUsingDraw(0, 4, 2);

    // Another example of when the card in the pyramid is not exposed
    firstValidModel.removeUsingDraw(1, 0, 0);

  }

  // Represents the test when the remove is attempted and it is invalid because the exposed card
  // and the card from the draw pile do not add up to be 13 in the case of a multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardsNotThirteen() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);

    // Represents the test for the remove function for this gameRemoveCard model
    // with a card in the pyramid that is being attempted to get removed but it is
    // not adding up to be 13
    firstValidModel.removeUsingDraw(1, 6, 3);

    // Another example of when the card in the pyramid is exposed but not adding up to be thirteen
    // with the card from the draw pile
    firstValidModel.removeUsingDraw(1, 6, 4);

  }

  // Represents the test when the remove is attempted and it is invalid because the either or
  // both of the cards being attempted to be removed is from a null area in the case of a
  // multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardsFromNullAreas() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    // Representing the removal of the cards first
    firstValidModel.removeUsingDraw(1, 6, 12);

    // Representing the invalid removal of the pair of cards from null areas
    firstValidModel.removeUsingDraw(1, 6, 12);
    // discard draws , removes, remove draws

  }

  // Represents the test when the remove is attempted and it is invalid because the index is
  // invalid in the case of a multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardsInvalidIndex() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    // Representing the removal of the cards first
    firstValidModel.removeUsingDraw(0, 10, 1);
  }

  // Represents the test when the remove is attempted and it is invalid because the index is
  // invalid in the case of a multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardsInvalidIndex1() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    // Representing the removal of the cards first
    firstValidModel.removeUsingDraw(-1, 7, 1);
  }

  // Represents the test when the remove is attempted and it is invalid because the index is
  // invalid in the case of a multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardsInvalidIndex3() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    // Representing the removal of the cards first
    firstValidModel.removeUsingDraw(55, -3, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiComplexGameState() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    try {
      firstValidModel.removeUsingDraw(0, 6, 1);
      System.out.println(viewModel.toString());
      firstValidModel.removeUsingDraw(1, 6, 0);
      System.out.println(viewModel.toString());
      firstValidModel.remove(6, 4);
      System.out.println(viewModel.toString());
      firstValidModel.remove(6, 2, 6, 6);
      System.out.println(viewModel.toString());
      firstValidModel.remove(6, 3, 6, 5);
      System.out.println(viewModel.toString());
      firstValidModel.remove(5, 2, 5, 5);
      System.out.println(viewModel.toString());
      firstValidModel.removeUsingDraw(1, 5, 3);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(2);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(1);
      System.out.println(viewModel.toString());
      firstValidModel.removeUsingDraw(0, 5, 0);
      System.out.println(viewModel.toString());
      firstValidModel.removeUsingDraw(2, 5, 1);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(2);
      System.out.println(viewModel.toString());
    } catch (Exception e) {
      fail();
    }
    // Will not work since the pyramid card is a null
    firstValidModel.removeUsingDraw(0, 6, 1);

    // Will not work since the pyramid card is a null
    firstValidModel.removeUsingDraw(2, 5, 1);

    for (int i = 0; i < 5; i++) {
      firstValidModel.discardDraw(i);
    }
    // Not possible since it will throw an exception
    firstValidModel.discardDraw(2);
  }

  // Represents the test when the remove is attempted and it is invalid because the either or
  // both of the cards being attempted to be removed is from a null area in the case of a
  // multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardsFromNullAreasOtherCard() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    // Representing the removal of another pair of cards
    firstValidModel.removeUsingDraw(1, 6, 12);

    // Representing the invalid removal of the pair of cards from null areas
    firstValidModel.removeUsingDraw(1, 6, 12);

  }

  // Represents the test of when the cards cannot be removed from a null area in the case of a
  // multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void removeMultiUsingDrawTestCardsFromNullAreas1() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    firstValidModel.remove(6, 2, 6, 12);

    // Representing the removal of the cards first
    firstValidModel.removeUsingDraw(0, 6, 2);

  }

  /**
   * Represents the function discardDraw that discards an individual card from the draw pile in the
   * case of a multipyramid.
   */

  // Represents the case of when the individual card is discarded from the draw pile
  @Test
  public void discardMultiDrawValidTest() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    assertEquals("K♥", firstValidModel.getDrawCards().get(0).toString());
    // Discarding the card at draw index of 0
    firstValidModel.discardDraw(0);
    System.out.println(viewModel.toString());
    // Represents the test of when the draw card is discarded from the draw pile
    assertNotEquals("K♥", firstValidModel.getDrawCards().get(0).toString());
  }

  // Represents the case of when the individual card cannot be discarded since the game has
  // not started yet in the case of a multipyramid.
  @Test(expected = IllegalStateException.class)
  public void discardMultiDrawGameNotStarted() {
    initTests();

    // Game not started using the startGame method and hence leads to throwing a new
    // IllegalStateExpression
    firstValidModel.discardDraw(1);
  }

  // Represents the case of when the individual card cannot be discarded since the draw index is not
  // valid because of being negative in the case of a multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void discardMultiDrawIndexNegativeInvalid() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);

    // Represents draw index value being negative and hence, throwing a new IllegalArgumentException
    firstValidModel.discardDraw(-10);
  }

  // Represents the case of when the individual card cannot be discarded since the draw index is not
  // valid because of exceeding the limit of cards in the stock pile in the case of a
  // multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void discardMultiDrawIndexExceedsInvalid() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);

    // Represents draw index value being negative and hence, throwing a new IllegalArgumentException
    firstValidModel.discardDraw(2100);
  }

  // Represents the case of when the individual card cannot be discarded since the game is over
  // and that there is nothing left in the stock pile anymore or the draw pile or nothing to replace
  // the draw card with in the case of a multipyramid.
  @Test(expected = IllegalArgumentException.class)
  public void discardMultiDrawNothingToReplaceWhenGameOver() {
    initTests();

    // Represents the starting of the game as given below
    firstValidModelGameOver.startGame(firstValidModelGameOver.getDeck(),
        false, 2, 3);
    System.out.println(viewModelGameOver.toString());
    // Discarding the 4 of hearts in the draw pile to check for any combination pairing
    firstValidModelGameOver.discardDraw(2);
    firstValidModelGameOver.discardDraw(1);
    firstValidModelGameOver.discardDraw(0);

    // For loop to go through the cards while discarding the ones from the draw pile until
    // there is no card left in the draw pile as well as in the stock pile
    for (int i = 0; i < 95; i++) {
      // Since the following game has no possible removes and no possible discards, we can
      // check from remaining cards in the stock pile
      firstValidModelGameOver.discardDraw(i);
    }
    firstValidModelGameOver.getDrawCards().get(0);
    firstValidModelGameOver.getDrawCards().get(1);
    firstValidModelGameOver.getDrawCards().get(2);

  }

  /**
   * Represents the tests for the getNumRows function which returns the number of rows originally in
   * the pyramid, or -1 if the game has not started yet in the case of a multipyramid.
   */

  // Represents the test for when the game has not started and the function should return -1
  @Test
  public void getMultiNumRowsValidGameNotStarted() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetNumRowsFrom = new MultiPyramidSolitaire();
    // Represents the fact that when the game has not started, returns -1
    assertEquals(-1, gameGetNumRowsFrom.getNumRows());
  }

  /**
   * Represents the test for when the game has started and the function should return the original
   * height or the total number of rows of the pyramid solitaire model in the game.
   */
  @Test
  public void getMultiNumRowsValidGameStarted() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetNumRowsFrom = new MultiPyramidSolitaire();
    // starts the game for the model
    gameGetNumRowsFrom.startGame(gameGetNumRowsFrom.getDeck(), true, 8, 5);
    // Represents the fact that when the game returns the total number of rows of the pyramid or its
    // height
    assertEquals(8, gameGetNumRowsFrom.getNumRows());
  }

  /**
   * Represents the test for when the game has started and the function should return the original
   * height or the total number of rows of the pyramid solitaire model in the game in the case of a
   * multipyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void getMultiNumRowsValidGameStarted1() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetNumRowsFrom = new MultiPyramidSolitaire();
    // starts the game for the model
    gameGetNumRowsFrom.startGame(gameGetNumRowsFrom.getDeck(), true, 0, 3);
    // Represents the fact that when the game returns the total number of rows of the pyramid or its
    // height
    assertEquals(0, gameGetNumRowsFrom.getNumRows());
  }

  /**
   * Represents the test for when the game has negative number of rows in the case of a
   * multipyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void getMultiNumRowsInvalidGameStarted() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetNumRowsFrom = new MultiPyramidSolitaire();
    // starts the game for the model
    gameGetNumRowsFrom.startGame(gameGetNumRowsFrom.getDeck(),
        true, -23, -2);
    // Represents the fact that when the game returns an IllegalArgumentException
    gameGetNumRowsFrom.getNumRows();
  }

  /**
   * Represents the test for when the game has the number of rows that exceed their maximum amount
   * in the case of a multipyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void getMultiNumRowsInvalidGameRowsExceeded() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetNumRowsFrom = new MultiPyramidSolitaire();
    // starts the game for the model
    gameGetNumRowsFrom.startGame(gameGetNumRowsFrom.getDeck(),
        true, 40, -2);
    // Represents the fact that when the game returns an IllegalArgumentException
    gameGetNumRowsFrom.getNumRows();
  }

  /**
   * Represents the tests for the function getNumDraw when the game has not been started in the case
   * of a multipyramid.
   */
  @Test
  public void getMultiNumDrawGameNotStarted() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetNumRowsFrom = new MultiPyramidSolitaire();
    assertEquals(-1, gameGetNumRowsFrom.getNumRows());
  }

  /**
   * Represents the tests for the function getNumDraw when the game has been started in the case of
   * a multipyramid.
   */
  @Test
  public void getMultiNumDrawGameStarted() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetDrawsFrom = new MultiPyramidSolitaire();
    // starts the game for the model
    gameGetDrawsFrom.startGame(gameGetDrawsFrom.getDeck(), true, 7, 4);
    assertEquals(4, gameGetDrawsFrom.getNumDraw());
  }

  /**
   * Represents the tests for the function getNumDraw when the game has been started but the value
   * of draw cards is negative or too much in the case of a multipyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void getMultiNumDrawGameStartedNegative() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetDrawsFrom = new MultiPyramidSolitaire();
    // starts the game for the model
    gameGetDrawsFrom.startGame(gameGetDrawsFrom.getDeck(), true, 7, -2);
    gameGetDrawsFrom.getNumDraw();
  }

  /**
   * Represents the tests for the function getNumDraw when the game has been started and the value
   * of the number of draw cards is valid in the case of a multipyramid.
   */
  @Test
  public void getMultiNumDrawGameStarted1() {
    initTests();
    // Represents a model
    PyramidSolitaireModel<Card> gameGetDrawsFrom = new MultiPyramidSolitaire();
    // starts the game for the model
    gameGetDrawsFrom.startGame(gameGetDrawsFrom.getDeck(), true, 7, 2);
    assertEquals(2, gameGetDrawsFrom.getNumDraw());
  }

  /**
   * Represents the test for getting the number of elements in the given row when the game has
   * started in the case of a multipyramid.
   */

  // Represents the working valid test cases for the getRowWidth function
  @Test
  public void getMultiRowWidthValidCases() {
    initTests();
    // Represents a model
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    // Represents the test taking into consideration the firstValidModel pyramid solitaire game
    assertEquals(14, firstValidModel.getRowWidth(7));

    // Represents the test taking into consideration the firstValidModel pyramid solitaire game
    assertEquals(11, firstValidModel.getRowWidth(3));

    // Represents the test taking into consideration the firstValidModel pyramid solitaire game
    assertEquals(9, firstValidModel.getRowWidth(1));

  }

  /**
   * Represents the test for getting the number of elements in the given row when the game has not
   * started in the case of a multipyramid.
   */

  @Test(expected = IllegalStateException.class)
  public void getMultiRowWidthGameNotStarted() {
    initTests();
    // Represents the calling of the function on the firstValidModel pyramid solitaire game
    firstValidModel.getRowWidth(5);
  }

  // Represents a test that checks the game being over when it has not been started yet
  @Test(expected = IllegalStateException.class)
  public void testGameOverWhenNotStarted() {
    initTests();

    // The game is never started

    firstValidModel.isGameOver();
  }

  // Representing the test when the game is over
  @Test
  public void testComplexGameStateGameIsOver() {
    initTests();

    // Representing starting the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 3);
    System.out.println(viewModel.toString());

    assertEquals(false, firstValidModel.isGameOver());

    try {
      firstValidModel.removeUsingDraw(0, 6, 1);
      System.out.println(viewModel.toString());
      firstValidModel.removeUsingDraw(1, 6, 0);
      System.out.println(viewModel.toString());
      firstValidModel.remove(6, 4);
      System.out.println(viewModel.toString());
      firstValidModel.remove(6, 2, 6, 6);
      System.out.println(viewModel.toString());
      firstValidModel.remove(6, 3, 6, 5);
      System.out.println(viewModel.toString());
      firstValidModel.remove(5, 2, 5, 5);
      System.out.println(viewModel.toString());
      firstValidModel.removeUsingDraw(1, 5, 3);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(2);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(1);
      System.out.println(viewModel.toString());
      assertEquals(false, firstValidModel.isGameOver());
      firstValidModel.removeUsingDraw(0, 5, 0);
      System.out.println(viewModel.toString());
      firstValidModel.removeUsingDraw(2, 5, 1);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(2);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(1);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(1);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(2);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(2);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      assertEquals(false, firstValidModel.isGameOver());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      assertEquals(false, firstValidModel.isGameOver());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      assertEquals(false, firstValidModel.isGameOver());
      firstValidModel.discardDraw(0);
      System.out.println(viewModel.toString());
      assertEquals(false, firstValidModel.isGameOver());
      System.out.println(viewModel.toString());
      firstValidModel.remove(4, 2);
      System.out.println(viewModel.toString());

    } catch (Exception e) {
      fail();
    }

    // assertEquals(true, firstValidModel.isGameOver());
  }


  /**
   * Represents the tests for the function that returns the current score, which is the sum of the
   * remaining cards in the pyramid.
   */
  // Represents the function that correctly gets the current score that is the sum of the value of
  // the remaining cards left in the pyramid
  @Test
  public void getScoreValidTestRemainingCards() {
    initTests();

    // Represents the starting of the game
    firstValidModelGameOver.startGame(firstValidModelGameOver.getDeck(),
        false, 2, 1);

    // Represents the test that gives the current score of the game at that time
    assertEquals(6, firstValidModelGameOver.getScore());
  }

  // Represents the function that correctly gets the current score that is the sum of the value of
  // the remaining cards left in the pyramid
  @Test
  public void getScoreValidTestRemainingCards1() {
    initTests();

    // Represents the starting of the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    // Represents the test that gives the current score of the game at that time
    assertEquals(185, firstValidModel.getScore());

    // Removing a pair of cards from the pyramid leading to the score decreasing
    firstValidModel.remove(6, 2, 6, 6);

    // Removing another pair of cards having one card removed from the pyramid and the other one
    // from the draw pile
    firstValidModel.removeUsingDraw(0, 6, 1);

    // Removing another pair of cards having one card removed from the pyramid and the other one
    // from the draw pile
    firstValidModel.removeUsingDraw(1, 6, 0);

    // Represents the returning of the current score after removing the cards that would have been
    // decreased
    assertEquals(153, firstValidModel.getScore());
  }

  // Represents the test that attempts to get the score when the game has not been started
  @Test(expected = IllegalStateException.class)
  public void testGetScoreGameNotStarted() {
    initTests();

    // Represents the calling of the function getScore on the pyramid game model when the game has
    // not been started which leads to throwing an IllegalStateException
    firstValidModel.getScore();
    firstValidModelGameOver.getScore();
  }

  // --------------- ^^^^^^^^^^^^^^^^ASK^^^^^^^^^^^^^^^ ---------------------

  // Represents the function that correctly gets the current score that is the sum of the value of
  // the remaining cards left in the pyramid but the game has not been started yet
  @Test(expected = IllegalStateException.class)
  public void getScoreGameNotStarted() {
    initTests();

    // Represents the testing without the game being started which leads to throwing of an error
    firstValidModelGameOver.getScore();
  }

  // Represents the function that correctly gets the current score that is the sum of the value of
  // the remaining cards left in the pyramid but the game has not been started yet
  @Test(expected = IllegalStateException.class)
  public void getScoreGameNotStarted1() {
    initTests();

    // Represents the testing without the game being started which leads to throwing of an error
    firstValidModel.getScore();
  }

  /**
   * Represents the tests for the function getCardAt(int row, int card) that returns the card from
   * that given specified position.
   */

  // Represents the valid test of when a card is returned from the given specific index of the
  // row and the card place
  @Test
  public void getCardAtValidTest() {
    initTests();

    // Representing the starting of the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    // Represents the test for when the given card is taken from the pyramid using the
    // getCardAt function and its index of the row and the card or the card index in that row
    assertEquals("K♥", firstValidModel.getCardAt(4, 2).toString());

    // Represents the test for when the given card is taken from the pyramid using the
    // getCardAt function and its index of the row and the card or the card index in that row
    assertEquals("2♠", firstValidModel.getCardAt(6, 6).toString());

    // Represents the test for when the given card is taken from the pyramid using the
    // getCardAt function and its index of the row and the card or the card index in that row
    assertEquals("J♥", firstValidModel.getCardAt(4, 0).toString());

  }

  // Represents the valid test of when a card is returned from the given specific index of the
  // row and the card place however the place is null since the card is already removed
  // hence it returns null
  @Test
  public void getCardAtNullAreas() {
    initTests();

    // Representing the starting of the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    // Represents the test for when the given card is taken from the pyramid using the
    // getCardAt function and its index of the row and the card or the card index in that row
    assertEquals("K♦", firstValidModel.getCardAt(6, 4).toString());

    // Represents the removal of the card above
    firstValidModel.remove(6, 4);

    // Represents the test for the getCardAt function which tries to get the King however,
    // because the king is removed, it returns null in the place of returning the string of the
    // King of Diamonds
    assertEquals(null, firstValidModel.getCardAt(6, 4));

    // Represents the test for when the given card is taken from the pyramid using the
    // getCardAt function and its index of the row and the card or the card index in that row
    assertEquals("2♠", firstValidModel.getCardAt(6, 6).toString());
    assertEquals("J♦", firstValidModel.getCardAt(6, 2).toString());

    // Represents the removal of the card above
    firstValidModel.remove(6, 2, 6, 6);

    // Represents the test for the getCardAt function which tries to get the Two however,
    // because the Two is removed, it returns null in the place of returning the string of the
    // Two of Spades as well as the Jack of Diamonds
    assertEquals(null, firstValidModel.getCardAt(6, 6));
    assertEquals(null, firstValidModel.getCardAt(6, 2));

  }

  // Represents the tests that are testing the getCardAt function when the game has not started
  @Test(expected = IllegalStateException.class)
  public void getCardAtTestingGameNotStarted() {
    initTests();

    // Representing not calling the startGame function oin the model due to which it throws an
    // IllegalStateException
    firstValidModel.getCardAt(4, 1);
  }

  // Represents the tests that are testing the getCardAt function when the game has not started
  @Test(expected = IllegalStateException.class)
  public void getCardAtTestingGameNotStarted1() {
    initTests();

    // Representing not calling the startGame function oin the model due to which it throws an
    // IllegalStateException
    firstValidModel.getCardAt(6, 6);
  }

  // Represents the tests that are testing when the index of the card is invalid
  @Test(expected = IllegalArgumentException.class)
  public void getCardAtTestingNegativeIndex() {
    initTests();

    // Represents the starting of the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    // Representing the index of the card that are negative
    firstValidModel.getCardAt(-6, -6);
  }

  // Represents the tests that are testing when the index of the card is invalid
  @Test(expected = IllegalArgumentException.class)
  public void getCardAtTestingExceedingMaximumIndex() {
    initTests();

    // Represents the starting of the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    // Representing the index of the card that are negative
    firstValidModel.getCardAt(10, 12);
  }

  /**
   * Represents the tests of the function getDrawCards when the game has not been started yet.
   */
  @Test(expected = IllegalStateException.class)
  public void getDrawCardsGameNotStarted() {
    initTests();
    // Representing the game model
    PyramidSolitaireModel<Card> gameToGetDrawCards = new BasicPyramidSolitaire();
    gameToGetDrawCards.getDrawCards();
  }

  /**
   * Represents the tests of the function getDrawCards when the game has been started.
   */
  @Test
  public void getDrawCardsGameStarted() {
    initTests();

    // Representing the starting of game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    // Representing the cards in the draw pile in the form of a new card to use in the
    // tests

    // Represents the draw card in the draw pile at index 0
    Card cardAtZero = new Card(Suite.SPADES, Values.THREE);

    // Represents the draw card in the draw pile at index 1
    Card cardAtOne = new Card(Suite.SPADES, Values.FOUR);

    // Representing the test for when the two draw cards are returned from the available
    // draw card pile
    assertEquals(new ArrayList<Card>(List.of(cardAtZero, cardAtOne)),
        firstValidModel.getDrawCards());
  }

  // Represents the test for the toString function which checks that after getting called
  // on the model, it returns the pyramid in the form of a list
  @Test
  public void testToString() {
    initTests();

    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);
    firstValidModel.removeUsingDraw(0, 6, 1);
    System.out.println(viewModel.toString());

    // Printing the model for being used in the isGameOver() function
    firstValidModelGameOver
        .startGame(firstValidModelGameOver.getDeck(), false, 2, 1);
    System.out.println(viewModelGameOver.toString());
    assertEquals("  A♥\n2♥  3♥\nDraw: 4♥", viewModelGameOver.toString());

    PyramidSolitaireModel<Card> toStringGameOver = new MultiPyramidSolitaire();
    PyramidSolitaireTextualView viewToString = new PyramidSolitaireTextualView(toStringGameOver);

    // Representing the tests for a bigger pyramid
    assertEquals("            A♥\n          2♥  3♥\n        4♥  5♥  6♥\n"
            + "      7♥  8♥  9♥  10♥\n    J♥  Q♥  K♥  A♦  2♦\n"
            + "  3♦  4♦  5♦  6♦  7♦  8♦\n9♦  .   J♦  Q♦  K♦  A♠  2♠\nDraw: 5♠, 4♠",
        viewModel.toString());
  }

  // Represents the tests for the getter function getCardValues of the card
  // which is aimed at getting either or both the suite of the card and the value
  // of the given card as well as including the getAction functions
  @Test
  public void getAllCardValuesTest() {
    initTests();

    // Representing the starting of the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    assertEquals(3,
        firstValidModel.getCardAt(1, 1).getCardValues().getAction());
  }

  // Represents the tests for the suite getter function in the suite class
  @Test
  public void getAllCardValuesSuiteTest() {
    initTests();

    // Representing the starting of the game
    firstValidModel.startGame(firstValidModel.getDeck(), false, 7, 2);

    assertEquals("♦",
        firstValidModel.getCardAt(4, 3).getCardSuite().getAction().toString());
  }

  // Represents the tests for the equal function in the card class
  @Test
  public void equalsWorks() {
    initTests();

    // Represents the test cases for the equals function to check whether the cards are equal or not
    assertEquals(new Card(Suite.HEARTS, Values.ACE), new Card(Suite.HEARTS, Values.ACE));
    assertEquals(new Card(Suite.DIAMONDS, Values.TEN), new Card(Suite.DIAMONDS, Values.TEN));

    // Represents the tests for when the equals not does not satisfy the conditions
    assertNotEquals(new Card(Suite.HEARTS, Values.ACE), new Card(Suite.SPADES, Values.ACE));
    assertNotEquals(new Card(Suite.DIAMONDS, Values.TEN), new Card(Suite.DIAMONDS, Values.FIVE));

  }

  // Represents the tests for the hashcode function from the card class
  @Test
  public void hashCodeWorks() {
    initTests();

    // Representing two card examples with the same fields that would have the same
    // hashCode
    // Similar card 1:
    Card cardToCheckHashCodeSimilar = new Card(Suite.DIAMONDS, Values.TEN);

    // Similar card 2:
    Card cardToCheckHashCodeSimilar1 = new Card(Suite.DIAMONDS, Values.TEN);

    // Representing the example of the card that is not similar with the fields compared to the
    // above two given cards
    Card cardToCheckHashCodeNotSimilar = new Card(Suite.SPADES, Values.EIGHT);

    // Represents the tests for the hashCode function in the card class checking the placement
    // or the hashCode of the given cards
    assertEquals(cardToCheckHashCodeSimilar.hashCode(),
        cardToCheckHashCodeSimilar1.hashCode());

    // Represents the test when the two cards do not have the same fields
    assertNotEquals(cardToCheckHashCodeNotSimilar.hashCode(),
        cardToCheckHashCodeSimilar.hashCode());

    // Represents the test when the two cards do not have the same fields
    assertNotEquals(cardToCheckHashCodeSimilar1.hashCode(),
        cardToCheckHashCodeNotSimilar.hashCode());

  }
}
