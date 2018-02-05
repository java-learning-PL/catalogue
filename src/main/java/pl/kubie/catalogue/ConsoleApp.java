package pl.kubie.catalogue;

import java.time.LocalDate;
import java.util.List;

public class ConsoleApp {
    private static View view = new View();
    private static GameRepository gameRepository = new GameRepository();

    public static void main(String... args) {
        gameRepository.addDatabase();
        view.printMenu();
        int choice = 1;
        while (choice != 0) {
            choice = view.typeChoice();
            switch (choice) {
                case 0: {
                    break;
                }
                case 1: {
                    view.printGames(gameRepository.getGameList());
                    break;
                }
                case 2: {
                    String name = view.typeName();
                    String type = view.typeType();
                    String comment = view.typeComment();
                    Double rate = view.typeRate();
                    Game newGame = new Game(name, type, comment, rate);
                    gameRepository.save(newGame);
                    break;
                }
                case 3: {
                    String name = view.typeName();
                    gameRepository.delete(name);
                    break;
                }
                case 4: {
                    String oldName = view.typeName();
                    String newName = view.typeName();
                    String newType = view.typeType();
                    String newComment = view.typeComment();
                    double newRate = view.typeRate();
                    gameRepository.editGame(oldName,newName,newType,newComment,newRate);
                    break;
                }
                case 5: {
                    System.out.println("Press 1 to find by name");
                    System.out.println("Press 2 to find by rate");
                    System.out.println("Press 3 to find by date");
                    int findingChoice =view.typeChoice();
                    switch (findingChoice){
                        case 1: {
                            String name = view.typeName();
                            System.out.println();
                            view.printGame(gameRepository.findByName(name));
                            break;
                        }
                        case 2: {
                            double rate = view.typeRate();
                            List<Game> games = gameRepository.findByRate(rate);
                            view.printGames(games);
                            break;
                        }
                        case 3: {
                            LocalDate date = view.typeDate();
                            List<Game> games = gameRepository.findByDate(date);
                            view.printGames(games);
                            break;
                        }
                    }

                }
            }
        }
    }

}

