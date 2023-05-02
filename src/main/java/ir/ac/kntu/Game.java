package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private String name;

    private String description;

    private String genres;

    private double price;

    public static HashMap<User, String> comments = new HashMap<>();

    public ArrayList<Double> rates = new ArrayList<>();


    public Game(String name, String description, String genres, double price) {
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.price = price;
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

    public String getName() {
        return name;
    }
}
