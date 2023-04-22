package ir.ac.kntu;

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
}
