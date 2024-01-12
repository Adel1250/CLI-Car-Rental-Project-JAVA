package com.adel;

import com.adel.booking.Booking;
import com.adel.booking.BookingArrayDataAccessService;
import com.adel.booking.BookingService;
import com.adel.car.CarArrayDataAccessService;
import com.adel.user.UserArrayDataAccessService;
import com.adel.user.UserService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final UserService userService = new UserService(new UserArrayDataAccessService());
    private static final BookingService bookingService = new BookingService(new BookingArrayDataAccessService(), new CarArrayDataAccessService());

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
            String userUUID;
            String choice = sc.next();
            switch (choice) {
                case "1":
                    userUUID = sc.next();
                    String carID = sc.next();
                    Booking booking = new Booking(userUUID, carID);
                    bookingService.addNewBooking(booking);
                    break;
                case "2":
                    userUUID = sc.next();
                    System.out.println(Arrays.toString(bookingService.findUserBookedCars(userUUID)));
                    break;
                case "3":
                    System.out.println(Arrays.toString(bookingService.getAllBookings()));
                    break;
                case "4":
                    System.out.println(Arrays.toString(bookingService.findUnbookedCars()));
                    break;
                case "5":
                    System.out.println(Arrays.toString(bookingService.getAvailableElectricCars()));
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