package pl.kubie.catalogue;

import java.util.Map;

public class View {
    public static void printMenu(){
        System.out.println("Welcome");
        System.out.println("Press 1 to print all Games");
        System.out.println("Press 2 to add new Game");
        System.out.println("Press 3 to delete Game");
        System.out.println("Press 4 to edit a Game");
        System.out.println("Press 5 to find a Game");
    }
    public static void printAllGames(Map<String,Game> games){
        for(Game game: games.values()){
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
}
