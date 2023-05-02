package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private String name;

    private String description;

    private String genres;

    private double price;

    private double rate;

    public static HashMap<User,String> comments=new HashMap<>();

    public static HashMap<User,Double> rates= new HashMap<>();

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
