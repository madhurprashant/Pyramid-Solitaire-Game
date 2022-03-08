package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents the enum Value class which contains the values and restrictions of the given types of
 * cards.
 */
// Class enum Value to demonstrate how values can be assigned to the enums of the types of cards
public enum Values {
  ACE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5),
  SIX(6),
  SEVEN(7),
  EIGHT(8),
  NINE(9),
  TEN(10),
  JACK(11),
  QUEEN(12),
  KING(13);

  // declaring private variable in order to get the integer values of the cards
  private final int value;

  // Represents the getter method for the given card types in this enum class

  // Represents the enum constructor - cannot be public or protected specifying the
  // restriction of the cards and their values
  private Values(int value) {
    if (value > 0 && value < 14) {
      this.value = value;
    } else {
      throw new IllegalArgumentException("Value is invalid!");
    }
  }

  /**
   * Represents the getter method in order to get the integer value of the card.
   */
  public int getAction() {
    return this.value;
  }
}
