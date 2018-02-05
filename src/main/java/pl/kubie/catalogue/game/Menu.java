package pl.kubie.catalogue.game;

class Menu {

  public static final int EXIT = 0;
  public static final int LIST_ALL = 1;
  public static final int ADD = 2;
  public static final int DELETE = 3;
  public static final int EDIT = 4;
  public static final int FIND = 5;
  public static final int FIND_BY_NAME = 1;
  public static final int FIND_BY_RATE = 2;
  public static final int FIND_BY_DATE = 3;

  public static String mainMenu() {
    return message(Menu.LIST_ALL, "print all games")
        + message(Menu.ADD, "add game")
        + message(Menu.DELETE, "delete game")
        + message(Menu.EDIT, "edit game")
        + message(Menu.FIND, "find games")
        + message(Menu.EXIT, "exit");
  }

  public static String findMenu() {
    return message(Menu.FIND_BY_NAME, "find by name")
        + message(Menu.FIND_BY_RATE, "find by rate")
        + message(Menu.FIND_BY_DATE, "find by date");

  }

  private static String message(int key, String action) {
    return String.format("Press %d to %s%n", key, action);
  }
}
