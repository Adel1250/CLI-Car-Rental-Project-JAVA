package com.adel.booking;

import java.io.*;
import java.util.Scanner;

public class BookingArrayDataAccessService implements BookingDao {
    private static final Booking[] bookings;
    private static int bookingsCount;

    static {
        bookingsCount = 0;
        bookings = new Booking[50];
        readCSVFile();
    }

    @Override
    public void insertBooking(Booking booking) {
        bookings[bookingsCount] = booking;
        insertIntoCSVFile(booking);
        bookingsCount++;
        if (bookingsCount == 50) {
            bookingsCount = 0;
        }
    }

    @Override
    public Booking[] getAllBookings() {
        return bookings;
    }

    @Override
    public Booking[] findBookingsByUserID(String userID) {
        Booking[] userBookings = new Booking[10];
        int count = 0;
        for (Booking booking : bookings) {
            if (booking != null && booking.getUserUUID().equals(userID)) {
                userBookings[count] = booking;
                count++;
            }
        }
        return userBookings;
    }

    @Override
    public Booking findBookingByCarID(String carID) {
        for (Booking booking : bookings) {
            if (booking != null && booking.getCarID().equals(carID)) {
                return booking;
            }
        }
        return null;
    }

    private static void readCSVFile() {
        File file = new File("src/com/adel/bookings.csv");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Bookings file is created successfully!");
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Can't create the file!");
        }
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNext()) {
            String[] bookingLineValues = scanner.nextLine().split(", ");
            Booking booking = new Booking(bookingLineValues[0], bookingLineValues[1]);
            bookings[bookingsCount] = booking;
            bookingsCount++;
            if (bookingsCount == 50) {
                bookingsCount = 0;
            }
        }
    }

    private static void insertIntoCSVFile(Booking booking) {
        File file = new File("src/com/adel/bookings.csv");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Bookings file is created successfully!");
                }
            }
        } catch (java.io.IOException e) {
            System.out.println("Can't create the file!");
        }
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(booking.getUserUUID() + ", " + booking.getCarID());

        printWriter.flush();
        printWriter.close();
    }
}
