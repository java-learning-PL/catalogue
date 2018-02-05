package pl.kubie.catalogue;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    private Map<String,Game> gameList;

    public GameRepository() {
        this.gameList = new HashMap<>();
    }

    public Game addGame(Game game){
        gameList.put(game.getName(),game);
        return game;
    }

    public void deleteGame(String name){
        if(gameList.remove(name) ==null) {
            throw new EntityNotFoundException();
        }
    }

    public Game findGamebyName(String name){
        if(gameList.containsKey(name)){
            return gameList.get(name);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    public Game findGamebyRate(int rate){
        for(Game game : gameList.values()){
            if(game.getRate()==rate){
                return game;
            }
        }
        throw new EntityNotFoundException();
    }

    public Game findGamebyDate(int year,int month,int dayOfMonth){
        for(Game game :gameList.values()){
            if(game.getDate().equals(LocalDate.of(year,month,dayOfMonth))){
                return game;
            }
        }
        throw new EntityNotFoundException();
    }
    public Game editGame(String oldName, String newName,String newType,String newComment, double newRate){
        if(gameList.containsKey(oldName)) {
            gameList.get(oldName).setType(newType);
            gameList.get(oldName).setRate(newRate);
            gameList.get(oldName).setComment(newComment);
            gameList.get(oldName).setName(newName);
            return gameList.get(newName);
        }
        else{
            throw new EntityNotFoundException();
        }
    }
    public Map<String,Game> getGameList(){
        return gameList;
    }


}
