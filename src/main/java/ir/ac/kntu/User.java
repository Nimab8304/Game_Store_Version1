package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private static ArrayList<User> users = new ArrayList<>();

    public String getPassword() {
        return password;
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
        int option=Menu.userOption();
        switch (option) {
            case 1:
                handleSignIn();
                break;
            case 2:
                handleSignUp();
                break;
            case 3:
                Start.adminOrUser();
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }


    public static void handleSignIn() {
        String usernameAsk, passwordAsk;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        usernameAsk = scanner.next();
        System.out.print("password: ");
        passwordAsk = scanner.next();
        if (checkForSignIN(usernameAsk, passwordAsk)) {
            System.out.println("go to menu");
            //TODO
            System.exit(0);
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
        if (checkForSignUp(usernameAsk, passwordAsk, emailAsk, phoneAsk)) {
            User userask = new User(usernameAsk, passwordAsk, emailAsk, phoneAsk);
            users.add(userask);
            System.out.println("user added successfully");
            Admin.goBack();
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

    public static boolean checkForSignUp(String username, String password, String email, String phoneNumber) {
        if (users != null) {
            for (User user : users) {
                if (user.getUsername().equals(username.trim())) {
                    System.out.println("Username already exist");
                    return false;
                }
            }
        }
        if (!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$")) {
            if (!password.matches("(.*)[1-9](.*)")) {
                System.out.println("Password must have at least one number");
                return false;
            }
            if (!password.matches("(.*)[A-Z](.*)")) {
                System.out.println("Password must have at least one upper case");
                return false;
            }
            if (!password.matches("(.*)[a-z](.*)")) {
                System.out.println("Password must have at least one lower case");
                return false;
            }
            if (password.length() < 8) {
                System.out.println("Password must have at least 8 character");
                return false;
            }
        }
        if (!email.matches(".+@gmail[.]{1}com")) {
            System.out.println("Email form is not acceptable");
            return false;
        }
        if (!phoneNumber.matches("[0-9]+")) {
            System.out.println("Phonenumber is not acceptable");
            return false;
        }
        return true;
    }

    public static boolean checkForSignIN(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username.trim()) && user.getPassword().equals(password.trim())) {
                return true;
            }
        }
        return false;
    }

}
