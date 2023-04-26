package ir.ac.kntu;

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
                //TODO
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
    }

    public static void handleStore(User user){
        System.out.println("***********************************");
        System.out.println("Store options:");
        System.out.println("1-Show all games");
        System.out.println("2-Exit");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option= scanner.nextInt();
        switch (option) {
            case 1:
                showGamesInformations(user);
                break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void showGamesInformations(User user){
        boolean hasGame=false;
        int i=1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        for (Game game:Start.games) {
            System.out.println(i+"-"+game.getName());
            i++;
        }
        System.out.println("***********************************");
        System.out.print("Please select the game you want: ");
        int option= scanner.nextInt();
        System.out.println("Name: "+Start.games.get(option-1).getName());
        System.out.println("Description: "+ Start.games.get(option-1).getDescription());
        System.out.println("genres: "+Start.games.get(option-1).getGenres());
        System.out.println("Price: "+Start.games.get(option-1).getPrice());
        System.out.println("Rate: "+Start.games.get(option-1).getRate());
        if (!user.usergames.contains(Start.games.get(option-1))) {
            System.out.println("you can buy this game");
            addGameToUserAccount(user,Start.games.get(option-1));
        }else {
            System.out.println("you already have this game");
        }
    }

    public static void addGameToUserAccount(User user,Game game) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to add this game to your account:(y/n) ");
        String answer;
        answer = scanner.next();
        if (answer.trim().equals("y")) {
            if (user.getWallet()<game.getPrice()){
                System.out.println("The account balance is not enough");
                userProfile(user);
            }else {
                user.setWallet(user.getWallet()-game.getPrice());
                user.usergames.add(game);
                System.out.println("The game has been added successfully :)");
            }
        } else if (answer.trim().equals("n")) {
            accountOptions(user);
        }
    }

}
