package service;

import Service.GameService;
import model.Game;
import model.Platform;
import model.Publisher;

import utils.CsvReader;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GameTestService {

    private static List<Game> games;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path path = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        games = CsvReader.readGameCsv(path);
    }

    @Test
    public void PS4GamesQuantity(){
        List<Game> gamesPS4 = GameService.filterPlataform(games, Platform.PS4);

        Assert.assertEquals(5, gamesPS4.size());
    }

    @Test
    public void X360GamesQuantity(){
        List<Game> gamesX360 = GameService.filterPlataform(games, Platform.X360);

        Assert.assertEquals(16, gamesX360.size());
    }

    @Test
    public void PCGamesQuantity(){
        List<Game> gamesPC = GameService.filterPlataform(games, Platform.PC);

        Assert.assertEquals(1, gamesPC.size());
    }

    @Test
    public void GBGamesQuantity(){
        List<Game> gamesGB = GameService.filterPlataform(games, Platform.GB);

        Assert.assertEquals(6, gamesGB.size());
    }

    @Test
    public void TotalGamesQuantity(){
        int totalGames = games.size();

        Assert.assertEquals(100, totalGames);
    }
}
