package pl.kubie.catalogue.game;

import java.util.ArrayList;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameRepository {

  private Map<String, Game> gameList;

  GameRepository() {
    this.gameList = new HashMap<>();
  }

  public List<Game> findAll() {
    return new ArrayList<>(gameList.values());
  }

  public Game findByName(String name) {
    if (gameList.containsKey(name)) {
      return gameList.get(name);
    } else {
      throw new EntityNotFoundException();
    }
  }

  public List<Game> findByDate(LocalDate date) {
    List<Game> games = new LinkedList<>();
    for (Game game : gameList.values()) {
      if (game.getDate().equals(date)) {
        games.add(game);
      }
    }
    return games;
  }

  public List<Game> findByRate(double rate) {
    List<Game> games = new LinkedList<>();
    for (Game game : gameList.values()) {
      if (game.getRate() == rate) {
        games.add(game);
      }
    }
    return games;
  }

  public Game save(Game game) {
    gameList.put(game.getName(), game);
    return game;
  }

  public void delete(String name) {
    if (gameList.remove(name) == null) {
      throw new EntityNotFoundException();
    }
  }
}
