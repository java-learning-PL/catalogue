package pl.kubie.catalogue;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class View {
    static GameRepository gameRepository = new GameRepository();

    static Game game1 = new Game("Wiedźmin", "Przygodowe", "Dobra gra", 10.0);
    static Game game2 = new Game("Assassin's Creed", "Przygodowe ", "Dobra gra", 9.4);
    static Game game3 = new Game("Gothic", "Przygodowe", "Dobra gra", 9.0);
    static Game game4 = new Game("Need for speed", "Wyścigi", "Dobra gra", 8.0);
    static Game game5 = new Game("GTA", "Przygodowe", "Dobra gra", 7.0);

    static Scanner scanner = new Scanner(System.in);

    public static void executeProgramm() {
        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);
        gameRepository.save(game4);
        gameRepository.save(game5);
        int choice = 1;

        printMenu();
        while (choice != 0) {
            System.out.println("Choose option from menu");
            choice = scanner.nextInt();
            switch (choice) {
                case 0: {
                    break;
                }
                case 1: {
                    printGames(gameRepository.getGameList());
                    break;
                }
                case 2: {
                    scanner.nextLine();
                    System.out.println("Type in name:");
                    String name = scanner.nextLine();
                    System.out.println("Type in type:");
                    String type = scanner.nextLine();
                    System.out.println("Type in comment:");
                    String comment = scanner.nextLine();
                    System.out.println("Type in rate");
                    double rate = scanner.nextInt();
                    Game newGame = new Game(name, type, comment, rate);
                    gameRepository.save(newGame);
                    break;
                }
                case 3: {
                    scanner.nextLine();
                    System.out.println("Type in name game to delete");
                    String name = scanner.nextLine();
                    gameRepository.delete(name);
                    break;
                }
                case 4: {
                    scanner.nextLine();
                    System.out.println("Type in name Game to edit");
                    String oldName = scanner.nextLine();
                    System.out.println("Type in new name");
                    String newName = scanner.nextLine();
                    System.out.println("Type in new type");
                    String newType = scanner.nextLine();
                    System.out.println("Type in new comment");
                    String newComment = scanner.nextLine();
                    System.out.println("Type in rate");
                    double newRate = scanner.nextDouble();
                    gameRepository.editGame(oldName,newName,newType,newComment,newRate);
                    break;
                }
                case 5: {
                    scanner.nextLine();
                    System.out.println("Press 1 to find by name");
                    System.out.println("Press 2 to find by rate");
                    System.out.println("Press 3 to find by date");
                    int findingChoice =scanner.nextInt();
                    switch (findingChoice){
                        case 1: {
                            scanner.nextLine();
                            System.out.println("Type in name");
                            String name = scanner.nextLine();
                            System.out.println();
                            printGame(gameRepository.findByName(name));
                            break;
                        }
                        case 2: {
                            scanner.nextLine();
                            System.out.println("Type in rate");
                            double rate = scanner.nextDouble();
                            List<Game> games = gameRepository.findByRate(rate);
                            printGames(games);
                            break;
                        }
                        case 3: {
                            scanner.nextLine();
                            System.out.println("Type in year");
                            int year  = scanner.nextInt();
                            System.out.println("Type in month");
                            int month = scanner.nextInt();
                            System.out.println("Type in day");
                            int day = scanner.nextInt();
                            LocalDate date = LocalDate.of(year,month,day);
                            List<Game> games = gameRepository.findByDate(date);
                            printGames(games);
                            break;
                        }
                    }

                }
            }
        }
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
    public static void printGame(Game game){
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
