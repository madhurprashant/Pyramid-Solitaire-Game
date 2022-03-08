

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.pyramidsolitaire.controller.MockPyramidSolitaireModel;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import java.io.StringReader;
import org.junit.Test;

/**
 * Represents the tests for the PyramidSolitaireTextualController class testing the functions of the
 * controller on the model, that is, the remove functions and the discard function.
 */

// Represents the test class PyramidSolitaireTextualControllerTest for the controller class
// that tests the functions on the pyramid solitaire game model
public class PyramidSolitaireTextualControllerTest {

  // Represents the Readable object rd to read the inputs from the user
  Readable rd;
  // Represents the Appendable object ap in order to transmit the output to the user
  Appendable ap;

  /**
   * Represents the test to test when the Readable object is null and the game is played in the case
   * of which an IllegalArgumentException is thrown in the case of a relaxed pyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGameNullReadableModelRelaxed() {

    rd = null;
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new RelaxedPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the Readable object is null and the game is played in the case
   * of which an IllegalArgumentException is thrown in the case of a multi pyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGameNullReadableModelRelaxedMulti() {

    rd = null;
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new MultiPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameNullReadableModel() {

    rd = null;
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameNullReadableModelRelaxedModel() {

    rd = null;
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new RelaxedPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGameNullReadableModelMulti() {

    rd = null;
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new MultiPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the Readable object is null and the game is played in the case
   * of which an IllegalArgumentException is thrown in the case of a relaxed pyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRelaxedGameNullReadableModel() {

    rd = null;
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new RelaxedPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the Readable object is null and the game is played in the case
   * of which an IllegalArgumentException is thrown in the case of a MultiPyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMultiGameNullReadableModel() {

    rd = null;
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new MultiPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }


  /**
   * Represents the test to test when the Appendable object is null and the game is played in the
   * case of which an IllegalArgumentException is thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGameAppendableModel() {

    rd = new StringReader("rm1 1 q 2");
    ap = null;
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the Appendable object is null and the game is played in the
   * case of which an IllegalArgumentException is thrown in the case of a relaxed pyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRelaxedGameAppendableModel() {

    rd = new StringReader("rm1 1 q 2");
    ap = null;
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new RelaxedPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the Appendable object is null and the game is played in the
   * case of which an IllegalArgumentException is thrown in the case of a MultiPyramid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMultiGameAppendableModel() {

    rd = new StringReader("rm1 1 q 2");
    ap = null;
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new MultiPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the model is null and the game is played in the case of which
   * an IllegalArgumentException is thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGameNullModel() {

    rd = new StringReader("rm1 1 q 2");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the model is null and the game is played in the case of which
   * an IllegalArgumentException is thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGameNullModelRelaxed() {

    rd = new StringReader("rm1 1 q 2");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new RelaxedPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test when the model is null and the game is played in the case of which
   * an IllegalArgumentException is thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGameNullModelMulti() {

    rd = new StringReader("rm1 1 q 2");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new MultiPyramidSolitaire();

    controllerModel.playGame(null,
        modelController.getDeck(), false, 7, 3);
  }

  /**
   * Represents the test to test the game quitting in the case of removing one card.
   */
  @Test
  public void testGameQuitController() {

    rd = new StringReader("rm1 1 q 2");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();

    controllerModel.playGame(modelController, modelController.getDeck(), false, 7, 3);
    assertTrue(ap.toString().contains("Game quit"));
  }

  /**
   * Represents the test to test the game quitting in the case of removing one card.
   */
  @Test
  public void testGameQuitControllerRelaxed() {

    rd = new StringReader("rm1 1 q 2");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new RelaxedPyramidSolitaire();

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    assertTrue(ap.toString().contains("Game quit"));
  }

  /**
   * Represents the test to test the game quitting in the case of removing one card.
   */
  @Test
  public void testGameQuitControllerMulti() {

    rd = new StringReader("rm1 1 q 2");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new MultiPyramidSolitaire();

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    assertTrue(ap.toString().contains("Game quit"));
  }

  /**
   * Represents the test to test the game when a remove for one card is called.
   */
  @Test
  public void testGameRemoveController() {

    rd = new StringReader("rm1 7 5 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController, modelController.getDeck(), false,
        7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    assertEquals("            A♥\n          2♥  3♥\n        4♥  5♥  6♥\n"
            + "      7♥  8♥  9♥  10♥\n    J♥  Q♥  K♥  A♦  2♦\n"
            + "  3♦  4♦  5♦  6♦  7♦  8♦\n9♦  10♦ J♦  Q♦  .   A♠  2♠\nDraw: 3♠, 4♠, 5♠",
        viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove for one card is called.
   */
  @Test
  public void testGameRemove1ControllerRelaxed() {

    rd = new StringReader("rm1 7 5 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new RelaxedPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController, modelController.getDeck(), false,
        7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    assertEquals("            A♥\n          2♥  3♥\n        4♥  5♥  6♥\n"
            + "      7♥  8♥  9♥  10♥\n    J♥  Q♥  K♥  A♦  2♦\n"
            + "  3♦  4♦  5♦  6♦  7♦  8♦\n9♦  10♦ J♦  Q♦  .   A♠  2♠\nDraw: 3♠, 4♠, 5♠",
        viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove for one card is called.
   */
  @Test
  public void testGameRemove1Controller() {

    rd = new StringReader("rm1 7 5 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController, modelController.getDeck(), false,
        7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    assertEquals("            A♥\n          2♥  3♥\n        4♥  5♥  6♥\n"
            + "      7♥  8♥  9♥  10♥\n    J♥  Q♥  K♥  A♦  2♦\n"
            + "  3♦  4♦  5♦  6♦  7♦  8♦\n9♦  10♦ J♦  Q♦  .   A♠  2♠\nDraw: 3♠, 4♠, 5♠",
        viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove for one card is called but any character is
   * inputted in between of the inputs except 'q' or 'Q'.
   */
  @Test
  public void testGameRemove1InvalidCharacterController() {

    rd = new StringReader("rm1 7 c q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController, modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    assertEquals("            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "This is an Invalid input! Please enter again.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "Score: 185", ap.toString());
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove for one card is called but any character is
   * inputted in between of the inputs except 'q' or 'Q'.
   */
  @Test(expected = IllegalStateException.class)
  public void testGameRemove1InvalidCharacterControllerException() {

    rd = new StringReader("rm1 7 s");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController, modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game quitting in the case of removing two cards.
   */
  @Test
  public void testGameQuitControllerRemove2() {

    rd = new StringReader("rm2 6 q 6 6");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();

    controllerModel.playGame(modelController, modelController.getDeck(), false, 7, 3);
    assertTrue(ap.toString().contains("Game quit"));
  }

  /**
   * Represents the test to test the game when a remove for two cards is called on the model.
   */
  @Test
  public void testGameRemove2Controller() {

    rd = new StringReader("rm2 7 3 7 7 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController, modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    assertEquals("            A♥\n          2♥  3♥\n        4♥  5♥  6♥\n"
            + "      7♥  8♥  9♥  10♥\n    J♥  Q♥  K♥  A♦  2♦\n"
            + "  3♦  4♦  5♦  6♦  7♦  8♦\n9♦  10♦ .   Q♦  K♦  A♠  .\nDraw: 3♠, 4♠, 5♠",
        viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove for two cards is called but any character is
   * inputted in between of the inputs except 'q' or 'Q'.
   */
  @Test
  public void testGameRemove2InvalidCharacterController() {

    rd = new StringReader("rm2 7 3 s 7 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    assertEquals("            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "This is an Invalid input! Please enter again.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "Score: 185", ap.toString());
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove for two cards is called but any character is
   * inputted in between of the inputs except 'q' or 'Q'.
   */
  @Test(expected = IllegalStateException.class)
  public void testGameRemove2InvalidCharacterControllerException() {

    rd = new StringReader("rm2 7 3 w 7");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game quitting in the case of removing using draw.
   */
  @Test
  public void testGameQuitControllerRemoveUsingDraw() {

    rd = new StringReader("rm2 1 q 7 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    assertTrue(ap.toString().contains("Game quit"));
  }

  /**
   * Represents the test to test the game when a remove using draw card is called on the model.
   */
  @Test
  public void testGameRemoveUsingDrawController() {

    rd = new StringReader("rmwd 2 7 1 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    assertEquals("            A♥\n          2♥  3♥\n        4♥  5♥  6♥\n"
            + "      7♥  8♥  9♥  10♥\n    J♥  Q♥  K♥  A♦  2♦\n"
            + "  3♦  4♦  5♦  6♦  7♦  8♦\n.   10♦ J♦  Q♦  K♦  A♠  2♠\nDraw: 3♠, 6♠, 5♠",
        viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove using draw is called but any character is
   * inputted in between of the inputs except 'q' or 'Q'.
   */
  @Test
  public void testGameRemoveUsingDrawInvalidCharacterController() {

    rd = new StringReader("rmwd s 7 1 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    assertEquals("            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "This is an Invalid input! Please enter again.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "Score: 185", ap.toString());
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a remove using draw is called but any character is
   * inputted in between of the inputs except 'q' or 'Q'.
   */
  @Test(expected = IllegalStateException.class)
  public void testGameRemoveUsingDrawInvalidCharacterControllerException() {

    rd = new StringReader("rmwd p 7 1");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game quitting in the case of discarding a draw card.
   */
  @Test
  public void testGameQuitControllerDiscardDraw() {

    rd = new StringReader("dd q q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    assertTrue(ap.toString().contains("Game quit"));
  }

  /**
   * Represents the test to test the game when a discarding a draw card is called on the model.
   */
  @Test
  public void testGameDiscardDrawController() {

    rd = new StringReader("dd 3 q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    assertEquals("            A♥\n          2♥  3♥\n        4♥  5♥  6♥\n"
            + "      7♥  8♥  9♥  10♥\n    J♥  Q♥  K♥  A♦  2♦\n"
            + "  3♦  4♦  5♦  6♦  7♦  8♦\n9♦  10♦ J♦  Q♦  K♦  A♠  2♠\nDraw: 3♠, 4♠, 6♠",
        viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a discardDraw is called but any character is inputted
   * in between of the inputs except 'q' or 'Q'.
   */
  @Test
  public void testGameDiscardDrawInvalidCharacterController() {

    rd = new StringReader("dd e q");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    assertEquals("            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "This is an Invalid input! Please enter again.\n"
        + "Game quit!\n"
        + "State of game when quit:\n"
        + "            A♥\n"
        + "          2♥  3♥\n"
        + "        4♥  5♥  6♥\n"
        + "      7♥  8♥  9♥  10♥\n"
        + "    J♥  Q♥  K♥  A♦  2♦\n"
        + "  3♦  4♦  5♦  6♦  7♦  8♦\n"
        + "9♦  10♦ J♦  Q♦  K♦  A♠  2♠\n"
        + "Draw: 3♠, 4♠, 5♠\n"
        + "Score: 185", ap.toString());
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }

  /**
   * Represents the test to test the game when a discardDraw is called but any character is inputted
   * in between of the inputs except 'q' or 'Q'.
   */
  @Test(expected = IllegalStateException.class)
  public void testGameDiscardDrawInvalidCharacterControllerException() {

    rd = new StringReader("dd t");
    ap = new StringBuilder();
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel<Card> modelController = new BasicPyramidSolitaire();
    PyramidSolitaireTextualView viewModelController = new PyramidSolitaireTextualView(
        modelController);

    controllerModel.playGame(modelController,
        modelController.getDeck(), false, 7, 3);
    // Represents discarding the draw card from the given draw index
    System.out.println(viewModelController.toString());
    System.out.println(ap.toString());
  }


  /**
   * Represents the test case for when a remove for two cards is called in the Readable object and
   * what the mock model should display in that case.
   */
  @Test
  public void testRemove2Command() {

    rd = new StringReader("rm2 1 2 3 4 q");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("row1: 0\ncard1: 1\nrow2: 2\ncard2: 3", mock.log.toString());


  }

  /**
   * Represents the test case for when a remove for two cards is called in the Readable object and
   * what the mock model should display in that case but the game is quit in between of taking the
   * inputs from the Readable object.
   */
  @Test
  public void testRemove2CommandQuit() {

    rd = new StringReader("rm2 1 2 q 4 q");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("", mock.log.toString());


  }

  /**
   * Represents the test case for when a remove for one card is called in the Readable object and
   * what the mock model should display in that case.
   */
  @Test
  public void testRemove1Command() {

    rd = new StringReader("rm1 6 5 q");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("row: 5\ncard: 4", mock.log.toString());

  }

  /**
   * Represents the test case for when a remove for one card is called in the Readable object and
   * what the mock model should display in that case but the game is quit in between of taking the
   * inputs from the Readable object.
   */
  @Test
  public void testRemove1CommandQuit() {

    rd = new StringReader("rm1 2 q  q");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("", mock.log.toString());


  }

  /**
   * Represents the test case for when a remove using draw is called in the Readable object and what
   * the mock model should display in that case.
   */
  @Test
  public void testRemoveUsingDrawCommand() {

    rd = new StringReader("rmwd 2 4 1 q");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("drawIndex: 1\nrow: 3\ncard: 0", mock.log.toString());

  }

  /**
   * Represents the test case for when a remove using draw is called in the Readable object and what
   * the mock model should display in that case but the game is quit in between of taking the inputs
   * from the Readable object.
   */
  @Test
  public void testRemoveUsingDrawCommandQuit() {

    rd = new StringReader("rmwd q 2 3");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("", mock.log.toString());


  }

  /**
   * Represents the test case for when a discard draw is called in the Readable object and what the
   * mock model should display in that case.
   */
  @Test
  public void testRemoveDiscardDrawCommand() {

    rd = new StringReader("dd 6 q");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("drawIndex: 5", mock.log.toString());

  }

  /**
   * Represents the test case for when a discard draw is called in the Readable object and what the
   * mock model should display in that case but the game is quit in between of taking the inputs
   * from the Readable object.
   */
  @Test
  public void testDiscardDrawCommandQuit() {

    rd = new StringReader("dd q");
    ap = new StringBuilder();
    Appendable viewap = new StringBuilder();

    MockPyramidSolitaireModel mock = new MockPyramidSolitaireModel(ap);
    PyramidSolitaireController controllerModel = new PyramidSolitaireTextualController(rd, viewap);
    controllerModel.playGame(mock, mock.getDeck(), false, 0, 0);

    assertEquals("", mock.log.toString());


  }

}

