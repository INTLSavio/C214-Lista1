package utils;

import model.Game;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvReader {

    public static List<Game> readGameCsv(Path csvFilePath){

        List<Game> games = new ArrayList<>();

        try {
            Reader rd = Files.newBufferedReader(csvFilePath);
            CsvToBean<Game> csvToBean = new CsvToBeanBuilder(rd)
                    .withType(Game.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            games = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }

}
