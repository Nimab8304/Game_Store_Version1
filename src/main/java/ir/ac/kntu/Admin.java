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
                AdminOptionForUser.handleUserForAdmin();
            case 2:
                AdminOptionsForGame.handleGameForAdmin();
            case 3:
                Start.adminOrUser();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }



}
