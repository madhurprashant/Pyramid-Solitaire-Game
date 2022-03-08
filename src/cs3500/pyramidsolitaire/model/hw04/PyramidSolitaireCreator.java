package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Represents the factory class PyramidSolitaireCreator that takes in an enum class and a static
 * factory method in order to get the specific given sub class called in the parameter of the
 * method.
 */
public class PyramidSolitaireCreator {

  /**
   * Represents the definition of the enum class in this PyramidSolitaireCreator class having three
   * possible values of whether a pyramid is BASIC, RELAXED, or MULTIPYRAMID.
   */
  public enum GameType {
    BASIC("BASIC"),
    RELAXED("RELAXED"),
    MULTIPYRAMID("MULTIPYRAMID");

    // declaring private variable in order to get the type of the Pyramid model
    private final String gameType;

    // Represents the getter method for the given game types in this enum class

    /**
     * Represents the getter method in order to get the type of the given game.
     */
    public String getGameType() {
      return this.gameType;
    }

    // Represents the enum constructor - cannot be public or protected specifying the
    // restriction of the cards and their types
    private GameType(String gameType) {
      this.gameType = gameType;
    }
  }


  /**
   * Represents a static factory method that returns the instance of the subclass of the
   * PyramidSolitaireModel depending on the value of the parameter.
   */
  public static PyramidSolitaireModel create(GameType type) {
    if (type == GameType.BASIC) {
      return new BasicPyramidSolitaire();
    } else if (type == GameType.RELAXED) {
      return new RelaxedPyramidSolitaire();
    } else if (type == GameType.MULTIPYRAMID) {
      return new MultiPyramidSolitaire();
    } else {
      return null;
    }
  }
}
