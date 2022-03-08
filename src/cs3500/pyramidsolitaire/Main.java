package cs3500.pyramidsolitaire;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.InputStreamReader;

/**
 * Represents the main method that takes in the inputs as the command-line arguments that are
 * available through the program through the argument args to check whether the user needs to input
 * the pyramids in the form of either RELAXED, BASIC, or MULTIPYRAMID and the number of the rows the
 * the draw cards to be inputted by the user.
 */
public final class Main {

  /**
   * Represents the main function in order to run the program and take inputs form the user as
   * command-line arguments.
   *
   * @param args Represents the field args in order to take the given specific inputs from the user
   *             of whether pyramid to be inputted needs to be RELAXED, BASIC, or MULTIPYRAMID as
   *             well as the number of rows in the given pyramid and the number of draw cards
   *             available
   */
  public static void main(String[] args) {
    // Represents the number of rows in the given pyramid
    int inputtedRows = 0;
    // Represents the number of draw cards inputted by the user
    int inputtedDraw = 0;
    // Represents a new PyramidCreator model to allow the user to enter type of pyramid
    // out of the three different types of pyramids
    PyramidSolitaireCreator pyramidType = new PyramidSolitaireCreator();
    // Represents the pyramid model field in order to take in and output the new PyramidModel
    // that the user has inputted
    PyramidSolitaireModel inputtedModel = null;
    // Represents the controller in order to display the model and play the game
    PyramidSolitaireController controllerModel;

    // Represents the try catch in order to display the given inputs
    try {
      if (args.length == 3) {
        // Represents inputting the number of rows in the given PyramidModel
        inputtedRows = Integer.parseInt(args[1]);

        // Represents inputting the number of draw cards in the given PyramidModel
        inputtedDraw = Integer.parseInt(args[2]);

        // Represents the switch case in order to take the different inputs based on the
        // user input
        switch (args[0]) {
          // Represents the case of when the pyramid inputted is a basic pyramid
          case "BASIC":
            if (inputtedRows > 9 || inputtedDraw > 104
                || inputtedRows < 0) {
              throw new IllegalArgumentException("Invalid number of rows or draw cards!");
            }
            // Represents the inputting of the model in the case of the basic pyramid
            inputtedModel = pyramidType.create(GameType.BASIC);
            break;

          // Represents the case of when the pyramid inputted is a relaxed pyramid
          case "RELAXED":
            if (inputtedRows > 9 || inputtedDraw > 104
                || inputtedRows < 0) {
              throw new IllegalArgumentException("Invalid number of rows or draw cards!");
            }
            // Represents the inputting of the model in the case of the relaxed pyramid
            inputtedModel = pyramidType.create(GameType.RELAXED);
            break;

          // Represents the case of when the pyramid inputted is a  MultiPyramid
          case "MULTIPYRAMID":
            if (inputtedRows > 9 || inputtedDraw > 104
                || inputtedRows < 0) {
              throw new IllegalArgumentException("Invalid number of rows or draw cards!");
            }
            // Represents the inputting of the model in the case of the MutliPyramid
            inputtedModel = pyramidType.create(GameType.MULTIPYRAMID);
            break;

          // Represents the default case of when the game has none of the pyramids available at that
          // point
          default:
            throw new IllegalArgumentException("No version of the pyramid is inputted!");
        }
      }

      // Represents the play of the game using the controllerModel
      controllerModel = new
          PyramidSolitaireTextualController(new InputStreamReader(System.in), System.out);
      // Represents playing the game
      controllerModel.playGame(inputtedModel, inputtedModel.getDeck(), false, inputtedRows
          , inputtedDraw);
    } catch (NumberFormatException e) {
      // No exception needed here
    }
  }
}
