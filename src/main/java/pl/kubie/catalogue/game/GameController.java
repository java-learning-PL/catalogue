package pl.kubie.catalogue.game;

import java.time.LocalDate;
import java.util.List;

class GameController {

  private final GameRepository gameRepository;
  private final GameView gameView;

  GameController(GameRepository gameRepository, GameView gameView) {
    this.gameRepository = gameRepository;
    this.gameView = gameView;
  }

  void findAll() {
    List<Game> games = gameRepository.findAll();
    gameView.print(games);
  }

  void findByName(UserInput userInput) {
    String name = userInput.gameId();
    gameView.print(gameRepository.findByName(name));
  }

  void findByDate(UserInput userInput) {
    LocalDate date = userInput.dateToFind();
    List<Game> games = gameRepository.findByDate(date);
    gameView.print(games);
  }

  void findByRate(UserInput userInput) {
    double rate = userInput.rateToFind();
    List<Game> games = gameRepository.findByRate(rate);
    gameView.print(games);
  }

  void create(UserInput userInput) {
    Game game = userInput.game();
    gameRepository.save(game);
  }

  void delete(UserInput userInput) {
    String name = userInput.gameId();
    gameRepository.delete(name);
  }

  void update(UserInput userInput) {
    Game old = gameRepository.findByName(userInput.gameId());
    Game updated = userInput.update(old);
    gameRepository.save(updated);
  }
}
