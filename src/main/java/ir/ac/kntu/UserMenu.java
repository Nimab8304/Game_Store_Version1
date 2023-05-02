package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu {
    public static void accountOptions(User user) {
        System.out.println("***********************************");
        System.out.println("account options:");
        System.out.println("1-Profile");
        System.out.println("2-Store");
        System.out.println("3-Library");
        System.out.println("4-Friends");
        System.out.println("5-Sign out");
        System.out.println("***********************************");
        int option;
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        switch (option) {
            case 1:
                userProfile(user);
            case 2:
                handleStore(user);
            case 3:
                handleLibrary(user);
            case 4:
                //TODO
            case 5:
                User.userMenu();
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void userProfile(User user) {
        System.out.println("***********************************");
        System.out.println("account options:");
        System.out.println("1-My information");
        System.out.println("2-Edit information");
        System.out.println("3-Charge wallet");
        System.out.println("4-Sign out");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int userprofile = scanner.nextInt();
        switch (userprofile) {
            case 1:
                showInformation(user);
                accountOptions(user);
                break;
            case 2:
                editInformation(user);
                break;
            case 3:
                chargeWallet(user);
            case 4:
                User.userMenu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void showInformation(User user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone number: " + user.getPhoneNumber());
    }

    public static void editInformation(User user) {
        String usernameAsk, passwordAsk, phoneAsk, emailAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        System.out.print("email: ");
        emailAsk = scanner.next();
        System.out.print("phonenumber: ");
        phoneAsk = scanner.next();
        System.out.println("***********************************");
        if (User.checkForSignUp(passwordAsk, emailAsk, phoneAsk)) {
            user.setUsername(usernameAsk);
            user.setPassword(passwordAsk);
            user.setEmail(emailAsk);
            user.setPhoneNumber(phoneAsk);
            System.out.println("Information has changed successfully :)");
        }
        userProfile(user);
    }

    public static void chargeWallet(User user) {
        System.out.print("How much do you want charge up your account? ");
        Scanner scanner = new Scanner(System.in);
        double charge = scanner.nextInt();
        user.setWallet(charge);
        accountOptions(user);
    }

    public static void handleStore(User user) {
        System.out.println("***********************************");
        System.out.println("Store options:");
        System.out.println("1-Show all games");
        System.out.println("2-Search with words");
        System.out.println("3-Search by price");
        System.out.println("4-Exit");
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
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void showAllGames(User user) {
        if (Start.games.isEmpty()) {
            System.out.println("Ask Admin to modify a game");
            accountOptions(user);
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
                userProfile(user);
            } else {
                user.setWallet(user.getWallet() - game.getPrice());
                user.usergames.add(game);
                System.out.println("The game has been added successfully :)");
            }
        } else if (answer.trim().equals("n")) {
            accountOptions(user);
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
        int option = showSpecificGameInformation(user, game);
        if (!user.usergames.contains(game.get(option - 1))) {
            System.out.println("you can buy this game");
            addGameToUserAccount(user, game.get(option - 1));
        } else {
            rateAndComment(user, game.get(option - 1));
            accountOptions(user);
        }
        accountOptions(user);
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

    public static void handleLibrary(User user) {
        System.out.println("***********************************");
        System.out.println("Store options:");
        System.out.println("1-My games");
        System.out.println("2-Search by word");
        System.out.println("3-Search by price");
        System.out.println("4-Exit");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                showUserGames(user);
                break;
            case 2:
                searchWithWord(user, user.usergames);
                break;
            case 3:
                searchWithPrice(user, user.usergames);
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void showUserGames(User user) {
        int i = 1;
        for (Game game : user.usergames) {
            System.out.println(i + "-" + game.getName());
            i++;
        }
        showUserGamesInformation(user, user.usergames);
    }

    public static void showUserGamesInformation(User user, ArrayList<Game> game) {
        int option = showSpecificGameInformation(user, game);
        rateAndComment(user, game.get(option - 1));
        accountOptions(user);
    }

    public static int showSpecificGameInformation(User user, ArrayList<Game> game) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select the game you want: ");
        int option = scanner.nextInt();
        System.out.println("Name: " + game.get(option - 1).getName());
        System.out.println("Description: " + game.get(option - 1).getDescription());
        System.out.println("genres: " + game.get(option - 1).getGenres());
        System.out.println("Price: " + game.get(option - 1).getPrice());
        System.out.println("Rate: " + countRates(game.get(option - 1)));
        return option;
    }

    public static double countRates(Game game) {
        double sum = 0;
        if (!game.rates.isEmpty()) {
            for (double rate : game.rates.values()) {
                sum += rate;
            }
            return sum / game.rates.size();
        }
        return sum;
    }

    public static void addRates(User user,double rate, Game game) {
        game.rates.put(user.getUsername(),rate);
    }

    public static void rateAndComment(User user, Game game) {
        System.out.println("1-Rate");
        System.out.println("2-Community");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                handdleRate(user, game);
                break;
            case 2:
                showComment(user,game);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void handdleRate(User user, Game game) {
        double rate;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rate: ");
        rate = scanner.nextDouble();
        addRates(user,rate, game);
        accountOptions(user);
    }

    public static void showComment(User user,Game game){
        Scanner scanner = new Scanner(System.in);
        int i=1;
        if (game.comments.isEmpty()){
            System.out.println("No comments have been registered");
            System.out.println("***********************************");
        }else {
            for (String writer:game.comments.keySet()){
                System.out.println(i+"-"+writer+": "+game.comments.get(writer));
                i++;
            }
        }
        System.out.print("Do you want to add a comment?(y/n) ");
        String answer= scanner.next();
        if (answer.trim().equals("y")){
            addComments(user,game);
        }else {
            accountOptions(user);
        }
    }

    public static void addComments(User user,Game game){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your comment: ");
        String comment=scanner.nextLine();
        game.comments.put(user.getUsername(), comment);
        accountOptions(user);
    }
}

