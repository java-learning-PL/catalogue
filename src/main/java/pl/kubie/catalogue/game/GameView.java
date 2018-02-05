package pl.kubie.catalogue.game;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GameView {

  private static final String GAME_FORMAT = "%20s || %-15s || %05.2f || %-15s || %-15s%n";
  private final Scanner scanner;

  GameView(Scanner scanner) {
    this.scanner = scanner;
  }

  public Game game() {
    String name = readString("Enter name");
    String type = readString("Enter type");
    String comment = readString("Enter comment");
    Double rate = readDouble("Enter rate");
    return new Game(name, type, comment, rate);
  }

  public void print(List<Game> games) {
    if (games.isEmpty()) {
      System.out.println("No games found");
    } else {
      games.forEach(this::print);
    }
  }

  public void print(Game game) {
    System.out.printf(GAME_FORMAT,
        game.getName(),
        game.getType(),
        game.getRate(),
        game.getComment(),
        game.getDate()
    );
  }

  public String gameId() {
    return readString("Enter name:");
  }

  public Game update(Game that) {
    String name = readString("Enter name", that.getName());
    String type = readString("Enter type", that.getType());
    String comment = readString("Enter comment", that.getComment());
    Double rate = readDouble("Enter rate", that.getRate());
    return new Game(name, type, comment, rate);
  }

  public int menuChoice() {
    System.out.println(Menu.mainMenu());
    System.out.println("Enter choice");
    return Integer.parseInt(scanner.nextLine());
  }

  public int findChoice() {
    System.out.println(Menu.findMenu());
    return Integer.parseInt(scanner.nextLine());
  }

  public double rateToFind() {
    return readDouble("Enter rate:");
  }

  public LocalDate dateToFind() {
    return LocalDate.parse(readString("Enter date (format: yyyy-MM-dd):"));
  }

  private double readDouble(String message) {
    System.out.println(message);
    return Double.parseDouble(scanner.nextLine());
  }

  private String readString(String message) {
    System.out.println(message);
    return scanner.nextLine();
  }

  private String readString(String message, String oldValue) {
    System.out.printf("%s (%s)%n", message, oldValue);
    String s = scanner.nextLine();
    return s.isEmpty() ? message : s;
  }

  private double readDouble(String message, double oldValue) {
    System.out.printf("%s (%f)%n", message, oldValue);
    String s = scanner.nextLine();
    return s.isEmpty() ? oldValue : Double.parseDouble(s);
  }
}
