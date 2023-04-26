package ir.ac.kntu;

import java.util.ArrayList;

public class Game {
    private String name;

    private String description;

    private String genres;

    private double price;

    private double rate;

    public static ArrayList<Game> games=new ArrayList<>();

    public Game(String name, String description, String genres, double price, double rate) {
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.price = price;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }
}
