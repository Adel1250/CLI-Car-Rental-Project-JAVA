package com.adel.booking;

import com.adel.car.Car;

import java.awt.print.Book;

public class BookingDao {
    private static final Booking[] bookings;
    private static int bookingsCount;

    static {
        bookingsCount = 0;
        bookings = new Booking[50];
    }

    public void insertBooking(Booking booking) {
        bookings[bookingsCount] = booking;
        bookingsCount++;
        if (bookingsCount == 50) {
            bookingsCount = 0;
        }
    }

    public Booking[] getAllBookings() {
        return bookings;
    }

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

    public Booking findBookingByCarID(String carID) {
        for (Booking booking : bookings) {
            if (booking != null && booking.getCarID().equals(carID)) {
                return booking;
            }
        }
        return null;
    }
}
