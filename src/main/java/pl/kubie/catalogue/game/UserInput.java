package pl.kubie.catalogue.game;


import java.time.LocalDate;
import java.util.Scanner;

class UserInput {
  private final Scanner scanner;

  UserInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public Game game() {
    String name = readString("Enter name");
    String type = readString("Enter type");
    String comment = readString("Enter comment");
    Double rate = readDouble("Enter rate");
    return new Game(name, type, comment, rate, LocalDate.now());
  }

  public String gameId() {
    return readString("Enter name:");
  }

  public Game update(Game that) {
    String type = readString("Enter type", that.getType());
    String comment = readString("Enter comment", that.getComment());
    Double rate = readDouble("Enter rate", that.getRate());
    return new Game(that.getName(),type,comment,rate,that.getDate());
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
    return s.isEmpty() ? oldValue : s;
  }

  private double readDouble(String message, double oldValue) {
    System.out.printf("%s (%f)%n", message, oldValue);
    String s = scanner.nextLine();
    return s.isEmpty() ? oldValue : Double.parseDouble(s);
  }
}
