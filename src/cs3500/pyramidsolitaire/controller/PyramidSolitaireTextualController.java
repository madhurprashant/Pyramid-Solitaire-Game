package cs3500.pyramidsolitaire.controller;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Represents the public class PyramidSolitaireTextualController that implements the interface
 * PyramidSolitaireController with the method of playGame that plays a new game of Pyramid Solitaire
 * using the provided model, using the startGame method on the model. It should throw an
 * IllegalArgumentException if the provided model is null . It should throw an IllegalStateException
 * only if the controller is unable to successfully receive input or transmit output, or if the game
 * cannot be started. The nature of input/output will be an implementation detail. Hence, this class
 * represents a controller which effectively interacts with the model of the game in order to play
 * the game successfully based on the rules an the specifications given.
 */

public class PyramidSolitaireTextualController implements PyramidSolitaireController {

  // Represents the Readable object 'rd' that receives the input from the user for the game to be
  // played
  private final Readable rd;

  // Represents the Appendable object 'ap' that transmits the output to the user by way of a
  // PyramidSolitaireTextualView
  private final Appendable ap;

  /**
   * Represents the public constructor for the class PyramidSolitaireTextualController that
   * implements the controller class PyramidSolitaireController. This constructor contains two
   * existing interfaces in Java that abstract input and output respectively. The constructor should
   * throw the IllegalArgumentException if and only if either of its arguments are null . Your
   * controller should accept and store these objects for doing input and output. Any input coming
   * from the user will be received via the Readable object, and any output sent to the user should
   * be written to the Appendable object by way of a PyramidSolitaireTextualView.
   *
   * @param rd Represents the Readable object that receives the input from the user for the game to
   *           be played
   * @param ap Represents the Appendable object that transmits the output to the user by way of a
   *           PyramidSolitaireTextualView
   * @throws IllegalArgumentException Throws an IllegalArgumentException if and only if either of of
   *                                  the readable or appendable arguments are null
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap)
      throws IllegalArgumentException {
    // Represents the case of when an IllegalArgumentException is thrown when either of the
    // readable or the appendable objects are null
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Invalid because either of the fields are null!");
    }

    // Represents accepting, storing and initializing the Readable object rd for the purpose of
    // storing the input from the user for the Pyramid Solitaire list game to be played.
    this.rd = rd;

    // Represents accepting, storing and initializing the Appendable object rd for the purpose of
    // transmitting the output to the user for the Pyramid Solitaire list game to be played.
    this.ap = ap;
  }

  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck, boolean shuffle,
      int numRows, int numDraw) {

    // Representing the view of the model to be used in order to print the model
    PyramidSolitaireTextualView view;

    // Represents the throwing of an IllegalArgumentException when the provided model is null
    if (model == null || deck == null) {
      throw new IllegalArgumentException("The given model is null and hence, invalid!");
    }

    // Represents the starting of the game
    try {
      model.startGame(deck, shuffle, numRows, numDraw);
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException(e.getMessage());
    }

    // Represents the initialization of the view of the model
    view = new PyramidSolitaireTextualView(model, ap);

    // Represents the Readable object for the input to be taken in from the user
    Scanner sc = new Scanner(this.rd);
    // Represents the string command which stores the next value of the Readable and
    // based on that takes the inputs and performs the functions on the model
    // Represents storing the command string as an empty string
    String command = "";

    // Representing the condition of whether the sc Scanner has another next element for user input
    while (!model.isGameOver()) {
      // Represents the current score of the model in the form of a string
      String currScore = String.valueOf(model.getScore());
      // Represents transmitting the game state to an appendable object exactly as the view of the
      // model provides it
      // Represents the game state being rendered using the Appendable object
      transmitGameState(view, model.getScore(), model);

      // Representing assigning the value of the sc.next() or the next element of user input from
      // the scanner to the command

      if (sc.hasNext()) {
        command = sc.next();
      } else {
        throw new IllegalStateException("There is no next available input in the Readable object!");
      }

      try {

        switch (command) {

          // Represents the first condition of when the command or the sc.next() is "rm1", it
          // should cause the controller to call the 2-argument remove method on the model with
          // appropriate inputs
          case "rm1":
            // Represents the index of the row
            int rowIndex = checkForBadInputs(sc);
            printQuitGame(rowIndex, view, currScore);
            if (rowIndex == -20) {
              return;
            }
            // Represents the index of the column
            int columnIndex = checkForBadInputs(sc);
            printQuitGame(columnIndex, view, currScore);
            if (columnIndex == -20) {
              return;
            }

            // Represents the removing of the card using the row and the column index inputs using
            // remove function to remove a single exposed card in the pyramid with a value of 13,
            // that is a King
            model.remove(rowIndex - 1, columnIndex - 1);

            break;

          // Represents the second condition of when the command or the sc.next() is "rm2", it
          // should cause the controller to call the 4-argument remove method on the model with
          // appropriate inputs
          case "rm2":

            // Represents the index of the first row
            int rowIndex1 = checkForBadInputs(sc);
            printQuitGame(rowIndex1, view, currScore);
            if (rowIndex1 == -20) {
              return;
            }
            // Represents the index of the first column
            int columnIndex1 = checkForBadInputs(sc);
            printQuitGame(columnIndex1, view, currScore);
            if (columnIndex1 == -20) {
              return;
            }
            // Represents the index of the second row
            int rowIndex2 = checkForBadInputs(sc);
            printQuitGame(rowIndex2, view, currScore);
            if (rowIndex2 == -20) {
              return;
            }
            // Represents the index of the second column
            int columnIndex2 = checkForBadInputs(sc);
            printQuitGame(columnIndex2, view, currScore);
            if (columnIndex2 == -20) {
              return;
            }

            // Represents the removing of the two exposed cards in the pyramid that add up to 13
            // using the index of the row and the column of both the cards using the remove function
            // that removes two cards from the pyramid
            model.remove(rowIndex1 - 1, columnIndex1 - 1, rowIndex2 - 1,
                columnIndex2 - 1);

            break;

          // Represents the third condition of when the command or the sc.next() is "rmwd", it
          // should cause the controller to call the removeWithDraw method on the model with
          // appropriate inputs
          case "rmwd":

            // Represents the draw index of the draw card to be removed in combination with any of
            // the exposed cards in the pyramid
            int drawIndex = checkForBadInputs(sc);
            printQuitGame(drawIndex, view, currScore);
            if (drawIndex == -20) {
              return;
            }
            // Represents the index of the row
            int rowIndexDraw = checkForBadInputs(sc);
            printQuitGame(rowIndexDraw, view, currScore);
            if (rowIndexDraw == -20) {
              return;
            }
            // Represents the index of the column
            int columnIndexDraw = checkForBadInputs(sc);
            printQuitGame(columnIndexDraw, view, currScore);
            if (columnIndexDraw == -20) {
              return;
            }

            // Represents removing the card using a draw card using the removeUsingDraw which takes
            // in the inputted drawIndex of the draw card, and the row and the column index of the
            // exposed card in the pyramid
            model.removeUsingDraw(drawIndex - 1, rowIndexDraw - 1,
                columnIndexDraw - 1);

            break;

          // Represents the fourth condition of when the command or the sc.next() is "dd", it
          //  should cause the controller to call the discardDraw method on the model with an
          //  appropriate input
          case "dd":

            // Represents the index of the draw card to be discarded from the draw pile
            int discardDrawIndex = checkForBadInputs(sc);
            printQuitGame(discardDrawIndex, view, currScore);
            if (discardDrawIndex == -20) {
              return;
            }

            // Represents discarding the draw card of the inputted draw index using the discardDraw
            // function on the model
            model.discardDraw(discardDrawIndex - 1);
            break;

          case "q":
          case "Q":
            printGameState(view, currScore);
            return;

          default:

        }
      } catch (IllegalArgumentException e) {
        try {
          this.ap.append("Invalid move. Play again." + e.getMessage() + "\n");
        } catch (IOException ioException) {
          throw new IllegalStateException("Invalid move!");
        }
      }


    }
    if (model.isGameOver()) {
      transmitGameState(view, model.getScore(), model);
    }
  }


  /**
   * Represents the private helper function transmitGameState which focuses transmitting the game
   * state to the Appendable object exactly as the view of the model provides it.
   *
   * @param viewModel Represents the view model to be rendered and appended to the current game
   *                  state
   */

  // Represents the private helper function transmitGameState which focuses transmitting the
  // game state to the Appendable object exactly as the view of the model provides it.
  private void transmitGameState(PyramidSolitaireTextualView viewModel, int score,
      PyramidSolitaireModel model) {
    try {
      if (model.isGameOver() && model.getScore() == 0) {
        viewModel.render();
        this.ap.append("\n").append("You win!");
      } else if (!model.isGameOver()) {
        viewModel.render();
        this.ap.append("\n").append("Score: " + score).append("\n");
      } else {
        viewModel.render();
        this.ap.append("\n");
      }
    } catch (IOException e) {
      // Represents throwing a new IllegalStateExpression when the Appendable object is unable
      // to transmit the output.
      throw new IllegalStateException("The Appendable is unable to transmit the output!");
    }

  }

  /**
   * Represents the helper function checkForBadInputs which checks whether the given string input is
   * a 'q' or a 'Q' or a String which cannot be converted into a valid integer in the case of which,
   * the user is asked to enter the value of the input again to execute the function on the pyramid
   * solitaire list game.
   *
   * @param scan Represents the scanner in order to read the inputted elements that the user
   *             provides
   */

  // Represents a private helper function to check the working of the scanner and reading and
  // inputting a valid input and the case of when a bad input is given due to which the user
  // would enter the value again
  private int checkForBadInputs(Scanner scan) {
    // Represents the Integer returned when the command at any point in between
    // encounters a 'q' or a 'Q'
    int quitInteger = -20;
    while (scan.hasNext()) {
      String inputtedString = scan.next();
      try {
        if (inputtedString.equals("q") || inputtedString.equals("Q")) {
          return quitInteger;
        } else {
          try {
            int check = Integer.parseInt(inputtedString);
            return check;
          } catch (Exception ignored) {

          }
        }
      } catch (NumberFormatException e) {
        try {
          this.ap.append("This is an Invalid input! Please enter again.").append("\n");
        } catch (IOException ioException) {
          throw new IllegalStateException("Invalid. " + e.getMessage());
        }
      }
    }
    throw new IllegalStateException("Invalid input from the user. Try again!");
  }

  /**
   * Represents a helper function printGameState that prints the game state after the game has been
   * quit.
   *
   * @param viewModel Represents the textual view of the pyramid solitaire textual view model
   * @param currScore Represents the current score of the game in the form of a string
   */

  // Represents a private helper function that prints the final game state based based on whether
  // the game has been quit or not
  private void printGameState(PyramidSolitaireTextualView viewModel, String currScore) {
    try {
      this.ap.append("\nGame quit!" + "\nState of game when quit:" + "\n"
          + viewModel.toString() + "\nScore: " + currScore);
    } catch (IOException e) {
      throw new IllegalStateException("Invalid. " + e.getMessage());
    }
  }

  /**
   * Represents a helper function that prints the game out if the game has been quit.
   *
   * @param quitIndex     Represents whether the index is at a point where the game has been quit
   * @param modelQuitView Represents the view of the given model
   * @param currScore     Represents the current score of the game after it has been quit
   */

  // Represents a helper function that prints the game when it has been quit
  private void printQuitGame(int quitIndex, PyramidSolitaireTextualView
      modelQuitView, String currScore) {
    if (quitIndex == -20) {
      printGameState(modelQuitView, currScore);
      return;
    }
  }
}

