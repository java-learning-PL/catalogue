package pl.kubie.catalogue.game;

import java.util.ArrayList;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

class GameRepository {

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
      return gameList.values()
              .stream()
              .filter(g -> g.getDate().equals(date))
              .collect(toList());
  }

  public List<Game> findByRateGreaterThan(double rate) {
    return gameList.values()
            .stream()
            .filter(g -> g.getRate() < rate)
            .collect(toList());
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
