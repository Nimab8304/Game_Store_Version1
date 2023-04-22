package ir.ac.kntu;

import java.util.Scanner;


public class Start {
    public static void adminOrUser() {
        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("Login options:");
        System.out.println("1-Admin");
        System.out.println("2-User");
        System.out.println("3-Exit.");
        System.out.println("***********************************");
        System.out.print("Please select your choice: ");

        option = scanner.nextInt();
        switch (option) {
            case 1:
                Admin.adminLogin();
                break;
            case 2:
                User.userMenu();
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice!");
                break;

        }
        scanner.close();
    }
}
