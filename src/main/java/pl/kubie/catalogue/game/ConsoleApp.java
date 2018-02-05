package pl.kubie.catalogue.game;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {

  private static final GameView gameView = new GameView(new Scanner(System.in));
  private static final GameRepository gameRepository = new GameRepository();
  private static final GameController gameController = new GameController(gameRepository, gameView);

  public static void main(String... args) {
    insertSampleData();

    while (true) {
      int choice = gameView.menuChoice();
      switch (choice) {
        case Menu.LIST_ALL:
          gameController.findAll();
          break;

        case Menu.ADD:
          gameController.create();
          break;

        case Menu.DELETE:
          gameController.delete();
          break;

        case Menu.EDIT:
          gameController.update();
          break;

        case Menu.FIND:
          switch (gameView.findChoice()) {
            case Menu.FIND_BY_NAME: {
              gameController.findByName();
              break;
            }
            case Menu.FIND_BY_RATE: {
              gameController.findByRate();
              break;
            }
            case Menu.FIND_BY_DATE: {
              gameController.findByDate();
              break;
            }
          }
          break;
      }

      if (choice == Menu.EXIT) {
        break;
      }
    }
  }

  private static void insertSampleData() {
    Arrays.asList(
        new Game("Wiedźmin", "Przygodowe", "Dobra gra", 10.0),
        new Game("Assassin's Creed", "Przygodowe ", "Dobra gra", 9.4),
        new Game("Gothic", "Przygodowe", "Dobra gra", 9.0),
        new Game("Need for speed", "Wyścigi", "Dobra gra", 8.0),
        new Game("GTA", "Przygodowe", "Dobra gra", 7.0)
    )
        .forEach(gameRepository::save);
  }
}

