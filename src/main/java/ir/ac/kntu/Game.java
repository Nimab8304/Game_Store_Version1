package ir.ac.kntu;

import java.util.ArrayList;

public class Game {
    private String name;

    private String description;

    private String genres;

    private double price;

    private double rate;


    public Game(String name, String description, String genres, double price, double rate) {
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.price = price;
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        return genres;
    }

    public double getPrice() {
        return price;
    }

    public double getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }
}
