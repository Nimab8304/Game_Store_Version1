package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private static String username;

    private static String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void adminLogin() {
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        if (!usernameAsk.equals(username)) {
            System.out.println("Username is wrong");
            goBack();

        } else if (!passwordAsk.equals(password)) {
            System.out.println("Password is wrong");
            goBack();
        }
        adminMenu();
    }

    public static void goBack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to try again:(y/n) ");
        String answer;
        answer = scanner.next();
        if (answer.trim().equals("y")) {
            Start.adminOrUser();
        } else if (answer.trim().equals("n")) {
            System.exit(0);
        }
    }

    public static void adminMenu() {
        System.out.println("***********************************");
        System.out.println("1-Users");
        System.out.println("2-Games");
        System.out.println("3-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                handleUserForAdmin();
            case 2:
                handleGameForAdmin();
            case 3:
                Start.adminOrUser();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void handleGameForAdmin() {
        System.out.println("***********************************");
        System.out.println("1-Add Game");
        System.out.println("2-Edit Game");
        System.out.println("3-Remove Game");
        System.out.println("4-Back");
        System.out.println("***********************************");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                addGame();
                break;
            case 2:
                findGameToEdit();
                break;
            case 3:
                findGameToRemove();
                break;
            case 4:
                adminMenu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void addGame() {
        String name, description, genre;
        double price;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.print("Name: ");
        name = scanner.next();
        System.out.print("Description: ");
        description = scanner.next();
        genre = chooseGenre();
        System.out.print("Price: ");
        price = scanner.nextDouble();
        System.out.println("***********************************");
        Game newGame=new Game(name,description,genre,price);
        Start.games.add(newGame);
        System.out.println("Game "+name+" was added successfully :)");
    }

    public static String chooseGenre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************Genre***************");
        System.out.println("1-Action     2-Strategy    3-Racing");
        System.out.println("4-Shooter    5-Sport       6-Simulation");
        System.out.println("7-Adventure  8-Survival       9-Others");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                return "Action";
            case 2:
                return "Strategy";
            case 3:
                return "Racing";
            case 4:
                return "Shooter";
            case 5:
                return "Sport";
            case 6:
                return "Simulation";
            case 7:
                return "Adventure";
            case 8:
                return "Survival";
            case 9:
                return "Others";
            default:
                System.out.println("Invalid choice!");
                break;
        }
        return null;
    }

    public static void findGameToEdit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i=1;
        ArrayList<Integer> index=new ArrayList<>();
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : Start.games) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
                index.add(Start.games.indexOf(game));
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
        }else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            System.out.print("Please select the game you want: ");
            int option = scanner.nextInt();
            Game editNeeded=Start.games.get(index.get(option-1));
            editGame(editNeeded);
        }
    }

    public static void editGame(Game game) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-Edit name");
        System.out.println("2-Edit description");
        System.out.println("3-Edit genres");
        System.out.println("4-Edit price");
        System.out.println("5-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                changeName(game);
                break;
            case 2:
                changeDescription(game);
                break;
            case 3:
                changeGenre(game);
                break;
            case 4:
                changePrice(game);
                break;
            case 5:
                adminMenu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void changeName(Game game){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new name: ");
        String newname=scanner.nextLine();
        game.setName(newname);
        adminMenu();
    }

    public static void changeDescription(Game game){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new Description: ");
        String newDescription=scanner.nextLine();
        game.setDescription(newDescription);
        adminMenu();
    }

    public static void changePrice(Game game){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new Price: ");
        double newPrice=scanner.nextDouble();
        game.setPrice(newPrice);
        adminMenu();
    }

    public static void changeGenre(Game game){
        String newGenre=chooseGenre();
        game.setGenres(newGenre);
        adminMenu();
    }

    public static void findGameToRemove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the text you want to search with: ");
        String answer;
        int i = 1;
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<Game> sorted = new ArrayList<>();
        answer = scanner.next();
        for (Game game : Start.games) {
            if (game.getName().startsWith(answer)) {
                sorted.add(game);
                index.add(Start.games.indexOf(game));
            }
        }
        if (sorted.isEmpty()) {
            System.out.println("No item found :(");
        } else {
            for (Game game : sorted) {
                System.out.println(i + "-" + game.getName());
                i++;
            }
            System.out.println("***********************************");
            System.out.print("Please select the game you want: ");
            int option = scanner.nextInt();
            System.out.println(Start.games.get(index.get(option-1)).getName());
            int indexOfGame=index.get(option - 1);
            Start.games.remove(indexOfGame);
            System.out.println("The game was successfully removed");
        }
    }

    public static void handleUserForAdmin(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-Search with username");
        System.out.println("2-Search with phone-number");
        System.out.println("3-Search with email");
        System.out.println("4-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                findUserWithUsername();
                break;
            case 2:
                findUserWithPhoneNumber();
                break;
            case 3:
                findUserWithEmail();
                break;
            case 4:
                adminMenu();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void findUserWithUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the username you want to search with: ");
        String answer;
        int index=-1;
        answer = scanner.next();
        User editneeded = null;
        for (User user : Start.users) {
            if (user.getUsername().equals(answer)) {
                editneeded=user;
                index=Start.users.indexOf(user);
            }
        }
        if (index==-1) {
            System.out.println("No item found :(");
        }else {
            if (editneeded!=null) {
                userOptions(editneeded);
            }
        }
    }

    public static void userOptions(User user){
        Scanner scanner=new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("1-User's informations");
        System.out.println("2-Ban User");
        System.out.println("3-Edit information");
        System.out.println("4-Back");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                UserMenu.showInformation(user);
                break;
            case 2:
                Start.users.remove(user);
                break;
            case 3:
                UserMenu.editInformation(user);
                break;
            case 4:
                handleUserForAdmin();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static void findUserWithPhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the phone-number you want to search with: ");
        String answer;
        int index=-1;
        answer = scanner.next();
        User editneeded = null;
        for (User user : Start.users) {
            if (user.getPhoneNumber().equals(answer)) {
                editneeded=user;
                index=Start.users.indexOf(user);
            }
        }
        if (index==-1) {
            System.out.println("No item found :(");
        }else {
            if (editneeded!=null) {
                userOptions(editneeded);
            }
        }
    }

    public static void findUserWithEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the Email you want to search with: ");
        String answer;
        int index=-1;
        answer = scanner.next();
        User editneeded = null;
        for (User user : Start.users) {
            if (user.getEmail().equals(answer)) {
                editneeded=user;
                index=Start.users.indexOf(user);
            }
        }
        if (index==-1) {
            System.out.println("No item found :(");
        }else {
            if (editneeded!=null) {
                userOptions(editneeded);
            }
        }
    }

}
