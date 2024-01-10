package com.adel.booking;

public interface BookingDao {
    void insertBooking(Booking booking);
    Booking[] getAllBookings();
    Booking[] findBookingsByUserID(String userID);
    Booking findBookingByCarID(String carID);
}
