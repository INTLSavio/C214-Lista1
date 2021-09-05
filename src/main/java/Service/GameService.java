package Service;

import model.Game;
import model.Platform;
import model.Publisher;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public static List<Game> filterPlataform(List<Game> games, Platform platform) {
        List<Game> gamesFiltered = new ArrayList<>();

        games.stream().filter((game ->
                game.getPlatform().equals(platform.name()))).
                forEach(game -> gamesFiltered.add(game));

        return gamesFiltered;
    }

    public static List<Game> filterPublisher(List<Game> games, Publisher publisher){
        List<Game> gamesFiltered = new ArrayList<>();

        games.stream().filter((game ->
                game.getPublisher().replaceAll("\\s+", "").equals(publisher.name()))).
                forEach(game -> gamesFiltered.add(game));

        return gamesFiltered;
    }
}
