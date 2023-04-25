package ir.ac.kntu;

import java.util.Scanner;

public class userMenu {
    public static void accountOptions(User user){
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
                //TODO
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

    public static void userProfile(User user){
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
                //TODO
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
    public static void showInformation(User user){
        System.out.println("Username: "+ user.getUsername());
        System.out.println("Password: "+ user.getPassword());
        System.out.println("Email: "+ user.getEmail());
        System.out.println("Phone number: "+ user.getPhoneNumber());
    }
}
