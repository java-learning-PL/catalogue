package pl.kubie.catalogue;

public class ConsoleApp {
  public static void main(String... args) {
    View view = new View();
    GameRepository gameRepository = new GameRepository();
     Game game1 = new Game("Wiedźmin", "Przygodowe", "Dobra gra", 10.0);
     Game game2 = new Game("Assassin's Creed", "Przygodowe ", "Dobra gra", 9.4);
     Game game3 = new Game("Gothic", "Przygodowe", "Dobra gra", 9.0);
     Game game4 = new Game("Need for speed", "Wyścigi", "Dobra gra", 8.0);
     Game game5 = new Game("GTA", "Przygodowe", "Dobra gra", 7.0);
     gameRepository.save(game1);
     gameRepository.save(game2);
     gameRepository.save(game3);
     gameRepository.save(game4);
     gameRepository.save(game5);
  }
}
