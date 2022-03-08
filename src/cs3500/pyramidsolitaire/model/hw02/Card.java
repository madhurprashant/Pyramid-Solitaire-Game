package cs3500.pyramidsolitaire.model.hw02;

import java.util.Objects;

/**
 * Represents the card class that designs the model of the cards in the deck.
 */
public class Card { // Where <K> represents the type of the card

  private final Suite cardSuite; // Represents the cs3500.pyramidSolitaire.model.hw04.Suite
  // of the given card
  private final Values cardValue; // Represents the Value of the given card

  /**
   * Represents the public constructor for this class cs3500.pyramidSolitaire.model.hw04.Card.
   *
   * @param cardSuite Represents the type of the four card suites in a deck
   * @param cardValue Represents the values of the cards in a deck
   */
  public Card(Suite cardSuite, Values cardValue) {
    this.cardSuite = cardSuite;
    this.cardValue = cardValue;
  }

  @Override
  public String toString() {
    if (cardValue.getAction() == 1) {
      return "A" + cardSuite.getAction();
    }
    if (cardValue.getAction() == 11) {
      return "J" + cardSuite.getAction();
    }
    if (cardValue.getAction() == 12) {
      return "Q" + cardSuite.getAction();
    }
    if (cardValue.getAction() == 13) {
      return "K" + cardSuite.getAction();
    }
    return cardValue.getAction() + cardSuite.getAction();
  }

  /**
   * Represents the getter method in order to get the integer value of the card.
   */
  public Values getCardValues() {
    return this.cardValue;
  }

  /**
   * Represents the getter method in order to get the integer value of the card.
   */
  public Suite getCardSuite() {
    return this.cardSuite;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return cardSuite == card.cardSuite && cardValue == card.cardValue;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardSuite, cardValue);
  }
}
