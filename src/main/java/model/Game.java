package model;

import lombok.Data;

@Data
public class Game {
    private String name;
    private String platform;
    private String publisher;
    private String globalSales;
    private int rank;
    private int year;
}
