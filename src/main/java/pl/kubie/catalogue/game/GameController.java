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

  void findByName() {
    String name = gameView.gameId();
    gameView.print(gameRepository.findByName(name));
  }

  void findByDate() {
    LocalDate date = gameView.dateToFind();
    List<Game> games = gameRepository.findByDate(date);
    gameView.print(games);
  }

  void findByRate() {
    double rate = gameView.rateToFind();
    List<Game> games = gameRepository.findByRate(rate);
    gameView.print(games);
  }

  void create() {
    Game game = gameView.game();
    gameRepository.save(game);
  }

  void delete() {
    String name = gameView.gameId();
    gameRepository.delete(name);
  }

  void update() {
    Game old = gameRepository.findByName(gameView.gameId());
    Game updated = gameView.update(old);
    gameRepository.save(updated);
  }
}
