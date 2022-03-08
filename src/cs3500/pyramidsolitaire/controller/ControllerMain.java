package cs3500.pyramidsolitaire.controller;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import java.io.InputStreamReader;

/**
 * Represents the main class to run and play the given game.
 */
public class ControllerMain {

  /**
   * Represents the static method.
   * @param args  Represents args
   */
  public static void main(String[] args) {
    PyramidSolitaireModel playModel = new BasicPyramidSolitaire();
    PyramidSolitaireController controlGame = new
        PyramidSolitaireTextualController(new InputStreamReader(System.in),
        System.out);
    controlGame.playGame(playModel, playModel.getDeck(), false, 4, 3);
  }

}