package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserStore {
    public static void handleStore(User user) {
        System.out.println("***********************************");
        System.out.println("Store options:");
        System.out.println("1-Show all games");
        System.out.println("2-Search with words");
        System.out.println("3-Search by price");
        System.out.println("4-Back");
        System.out.println("5-Exit");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                showAllGames(user);
                break;
            case 2:
                searchWithWord(user, Start.games);
                break;
            case 3:
                searchWithPrice(user, Start.games);
            case 4:
                UserMenu.accountOptions(user);
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void showAllGames(User user) {
        if (Start.games.isEmpty()) {
            System.out.println("Ask Admin to modify a game");
            UserMenu.accountOptions(user);
        } else {
            int i = 1;
            System.out.println("***********************************");
            for (Game game : Start.games) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            showGamesInformation(user, Start.games);
        }
    }

    public static void addGameToUserAccount(User user, Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to add this game to your account:(y/n) ");
        String answer;
        answer = scanner.next();
        if (answer.trim().equals("y")) {
            if (user.getWallet() < game.getPrice()) {
                System.out.println("The account balance is not enough");
                UserProfile.userProfile(user);
            } else {
                user.setWallet(user.getWallet() - game.getPrice());
                user.usergames.add(game);
                System.out.println("The game has been added successfully :)");
            }
        } else if (answer.trim().equals("n")) {
            UserMenu.accountOptions(user);
        }
    }

    public static void searchWithWord(User user, ArrayList<Game> games) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i = 1;
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : games) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
            handleStore(user);
        } else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            showGamesInformation(user, sorted);
        }

    }

    public static void showGamesInformation(User user, ArrayList<Game> game) {
        int option = UserLibrary.showSpecificGameInformation(user, game);
        if (!user.usergames.contains(game.get(option - 1))) {
            System.out.println("you can buy this game");
            addGameToUserAccount(user, game.get(option - 1));
        } else {
            UserLibrary.rateAndComment(user, game.get(option - 1));
            UserMenu.accountOptions(user);
        }
        UserMenu.accountOptions(user);
    }

    public static void searchWithPrice(User user, ArrayList<Game> games) {
        int ceiling, floor;
        ArrayList<Game> sorted = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert the floor price: ");
        floor = scanner.nextInt();
        System.out.print("Insert the ceiling price: ");
        ceiling = scanner.nextInt();
        for (Game game : games) {
            if (floor <= game.getPrice() && game.getPrice() <= ceiling) {
                sorted.add(game);
            }
        }
        int i = 1;
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
            handleStore(user);
        } else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            showGamesInformation(user, sorted);
        }
    }
}
