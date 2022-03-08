package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents the enum cs3500.pyramidSolitaire.model.hw04.Suite class which contains the values and
 * restrictions of the given types of cards.
 */
// Class enum cs3500.pyramidSolitaire.model.hw04.Suite to demonstrate how values
// can be assigned to the enums of the types of cards
public enum Suite {
  HEARTS("♥"),
  DIAMONDS("♦"),
  SPADES("♠"),
  CLUBS("♣");


  // declaring private variable in order to get the values of the cards
  private final String suite;

  // Represents the getter method for the given card types in this enum class

  /**
   * Represents the getter method in order to get the value of the card.
   */
  public String getAction() {
    return this.suite;
  }

  // Represents the enum constructor - cannot be public or protected specifying the
  // restriction of the cards and their values
  private Suite(String suite) {
    this.suite = suite;
  }
}

