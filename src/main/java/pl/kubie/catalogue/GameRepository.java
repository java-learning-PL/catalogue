package pl.kubie.catalogue;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameRepository {

    private Map<String, Game> gameList;

    public void addDatabase(){
        Game game1 = new Game("Wiedźmin", "Przygodowe", "Dobra gra", 10.0);
        Game game2 = new Game("Assassin's Creed", "Przygodowe ", "Dobra gra", 9.4);
        Game game3 = new Game("Gothic", "Przygodowe", "Dobra gra", 9.0);
        Game game4 = new Game("Need for speed", "Wyścigi", "Dobra gra", 8.0);
        Game game5 = new Game("GTA", "Przygodowe", "Dobra gra", 7.0);
        save(game1);
        save(game2);
        save(game3);
        save(game4);
        save(game5);
    }

    public GameRepository() {
        this.gameList = new HashMap<>();
    }

    public Game save(Game game) {
        if (gameList.containsKey(game.getName())) {
            throw new EntityNotFoundException();
        } else {
            gameList.put(game.getName(), game);
            return game;
        }
    }

    public void delete(String name) {
        if (gameList.remove(name) == null) {
            throw new EntityNotFoundException();
        }
    }

    public Game findByName(String name) {
        if (gameList.containsKey(name)) {
            return gameList.get(name);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<Game> findByRate(double rate) {
        List<Game> games = new LinkedList<>();
        for (Game game : gameList.values()) {
            if (game.getRate() == rate) {
                games.add(game);
            }
        }
        if (games.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            return games;
        }
    }

    public List<Game> findByDate(LocalDate date) {
        List<Game> games = new LinkedList<>();
        for (Game game : gameList.values()) {
            if (game.getDate().equals(date)) {
                games.add(game);
            }
        }
        if (games.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            return games;
        }
    }

    public Game editGame(String oldName, String newName, String newType, String newComment, double newRate) {
        if (gameList.containsKey(oldName)) {
            gameList.get(oldName).setType(newType);
            gameList.get(oldName).setRate(newRate);
            gameList.get(oldName).setComment(newComment);
            gameList.get(oldName).setName(newName);
            return gameList.get(newName);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<Game> getGameList() {
        List list = new LinkedList(gameList.values());
        return list;
    }


}
