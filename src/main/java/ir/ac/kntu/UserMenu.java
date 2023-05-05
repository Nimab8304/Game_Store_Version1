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
                UserProfile.userProfile(user);
            case 2:
                UserStore.handleStore(user);
            case 3:
                UserLibrary.handleLibrary(user);
            case 4:
                UserFriend.handleFriens(user);
            case 5:
                User.userMenu();
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}