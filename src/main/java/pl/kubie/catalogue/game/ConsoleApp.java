package pl.kubie.catalogue.game;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {

  private static final GameView gameView = new GameView();
  private static final UserInput userInput = new UserInput(new Scanner(System.in));
  private static final GameRepository gameRepository = new GameRepository();
  private static final GameController gameController = new GameController(gameRepository, gameView);


  public static void main(String... args) {
    insertSampleData();

    while (true) {
      int choice = userInput.menuChoice();
      switch (choice) {
        case Menu.LIST_ALL:
          gameController.findAll();
          break;

        case Menu.ADD:
          gameController.create(userInput);
          break;

        case Menu.DELETE:
          gameController.delete(userInput);
          break;

        case Menu.EDIT:
          gameController.update(userInput);
          break;

        case Menu.FIND:
          switch (userInput.findChoice()) {
            case Menu.FIND_BY_NAME: {
              gameController.findByName(userInput);
              break;
            }
            case Menu.FIND_BY_RATE: {
              gameController.findByRate(userInput);
              break;
            }
            case Menu.FIND_BY_DATE: {
              gameController.findByDate(userInput);
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
        new Game("Wiedźmin", "Przygodowe", "Dobra gra", 10.0, LocalDate.now()),
        new Game("Assassin's Creed", "Przygodowe ", "Dobra gra", 9.4, LocalDate.now()),
        new Game("Gothic", "Przygodowe", "Dobra gra", 9.0, LocalDate.now()),
        new Game("Need for speed", "Wyścigi", "Dobra gra", 8.0, LocalDate.now()),
        new Game("GTA", "Przygodowe", "Dobra gra", 7.0, LocalDate.now())
    )
        .forEach(gameRepository::save);
  }
}

