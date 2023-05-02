package ir.ac.kntu;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("Nima", "123456");
        User user = new User("Ali", "Abasi123456", "zxjcbhj@gmail.com", 15
                , "24525");
        Start.users.add(user);
        Game game = new Game("Snake", "very good", "action", 10, 9.4);
        Game game1 = new Game("walking dead", "khobe", "Drama", 11, 9.6);
        Game game2 = new Game("walker", "khob", "Dram", 8, 7);
        Start.games.add(game);
        Start.games.add(game1);
        Start.games.add(game2);
        Start.adminOrUser();
    }
}