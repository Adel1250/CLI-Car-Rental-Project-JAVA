import user.UserService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final UserService userService = new UserService();
    public static void main(String[] args) {
        String[] options = {
                "1- Book Car",
                "2- View All User Booked Cars",
                "3- View All Bookings",
                "4- View Available Cars",
                "5- View Available Electric Cars",
                "6- View all users",
                "7- Exit"
        };

        Scanner sc = new Scanner(System.in);

        while (true) {
            for (String option : options) {
                System.out.println(option);
            }
            String choice = sc.next();
            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    System.out.println(Arrays.toString(userService.getAllUsers()));
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}