package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private static ArrayList<User> users;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public static void userMenu() {
        System.out.println("***********************************");
        System.out.println("User Menu:");
        System.out.println("1-sign in");
        System.out.println("2-sign up");
        System.out.println("3-Exit.");
        System.out.println("***********************************");
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        switch (option) {
            case 1:
                handleSignIn();
                break;
            case 2:
                handleSignUp();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        scanner.close();
    }


    public static void handleSignIn() {
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        User userask = new User(usernameAsk, passwordAsk);
        if (users.contains(userask)) {
            System.out.println("go to menu");
        } else {
            System.out.println("user does not exist");
        }
    }

    public static void handleSignUp() {
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
        if (checkForSignUp(usernameAsk, passwordAsk)) {
            User userask = new User(usernameAsk, passwordAsk, emailAsk, phoneAsk);
        } else {
            System.out.println("Sign up was not successful");
            int option;
            System.out.println("1-Try again");
            System.out.println("2-Go back");
            System.out.println("3-Exit.");
            System.out.print("Please select your choice: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    handleSignUp();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
        scanner.close();
    }

    public static boolean checkForSignUp(String username, String password) {
        for (User user : users) {
            if (user.getUsername() == username) {
                return false;
            }
        }
        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$")) {
            if (!password.matches("(.*)[1-9](.*)")) {
                System.out.println("At least one number is needed");
                return false;
            }
            if (!password.matches("(.*)[A-Z](.*)")) {
                System.out.println("At least one upper case is needed");
                return false;
            }
            if (!password.matches("(.*)[a-z](.*)")) {
                System.out.println("At least one lower case is needed");
                return false;
            }
        }
        return true;
    }

}
