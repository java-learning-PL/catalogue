package pl.kubie.catalogue;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class View {

    static Scanner scanner = new Scanner(System.in);

    public static String typeName(){
        scanner.nextLine();
        System.out.println("Type in name:");
        String name =scanner.nextLine();
        return name;
    }
    public static String typeType(){
        scanner.nextLine();
        System.out.println("Type in type");
        String type = scanner.nextLine();
        return type;
    }
    public static String typeComment(){
        scanner.nextLine();
        System.out.println("Type in comment");
        String comment  = scanner.nextLine();
        return comment;
    }
    public static double typeRate(){
        scanner.nextLine();
        System.out.println("Type in rate");
        double rate = scanner.nextDouble();
        return rate;
    }

    public LocalDate typeDate() {
        scanner.nextLine();
        System.out.println("Type in year");
        int year = scanner.nextInt();
        System.out.println("Type in month");
        int month = scanner.nextInt();
        System.out.println("Type in day");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }
    public static int typeChoice(){
        System.out.println("Type in choice");
        int choice = scanner.nextInt();
        return choice;
    }

    public static void printMenu() {
        System.out.println("Welcome");
        System.out.println("Press 1 to print all Games");
        System.out.println("Press 2 to add new Game");
        System.out.println("Press 3 to delete Game");
        System.out.println("Press 4 to edit a Game");
        System.out.println("Press 5 to find a Game");
    }

    public static void printGames(List<Game> games) {
        for (Game game : games) {
            printGame(game);
            System.out.println();
        }
    }

    public static void printGame(Game game) {
        System.out.print(game.getName());
        System.out.print("||");
        System.out.print(game.getType());
        System.out.print("||");
        System.out.print(game.getRate());
        System.out.print("||");
        System.out.print(game.getComment());
        System.out.print("||");
        System.out.print(game.getDate());
    }
}
