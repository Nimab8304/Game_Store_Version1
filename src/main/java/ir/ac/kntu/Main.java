package ir.ac.kntu;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("Nima", "123456");
        Game game=new Game("Snake","very good","action",10,9.4);
        Game.games.add(game);
        Start.adminOrUser();
    }
}