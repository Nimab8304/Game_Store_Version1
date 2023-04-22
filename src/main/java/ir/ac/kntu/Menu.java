package ir.ac.kntu;

import java.util.Scanner;

public class Menu {
    public static int userOption(){
        System.out.println("***********************************");
        System.out.println("User Menu:");
        System.out.println("1-Sign in");
        System.out.println("2-Sign up");
        System.out.println("3-Back");
        System.out.println("4-Exit.");
        System.out.println("***********************************");
        int option;
        System.out.print("Please select your choice: ");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        scanner.close();
        return option;
    }
}
