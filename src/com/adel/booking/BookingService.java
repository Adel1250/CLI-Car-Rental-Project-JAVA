package com.adel.booking;

import com.adel.car.Car;
import com.adel.car.CarDao;

public class BookingService {
    private static final BookingDao bookingDao = new BookingDao();
    private static final CarDao carDao = new CarDao();

    public Booking[] getAllBookings() {
        return bookingDao.getAllBookings();
    }

    public void addNewBooking(Booking booking) {
        if (bookingDao.findBookingByCarID(booking.getCarID()) != null) {
            System.out.println("Car is already booked. Try again later!");
            return;
        }
        bookingDao.insertBooking(booking);
    }

    public Car[] findUserBookedCars(String userID) {
        Booking[] bookings = bookingDao.findBookingsByUserID(userID);
        Car[] bookedCars = new Car[10];
        int count = 0;
        for (Booking booking : bookings) {
            if (booking != null) {
                Car car = carDao.findCarByID(booking.getCarID());
                if (car != null) {
                    bookedCars[count] = car;
                }
            }
        }
        return bookedCars;
    }

    public Car[] findUnbookedCars() {
        Car[] unbookedCars = new Car[10];
        Car[] cars = carDao.getAllCars();
        int count = 0;
        for (Car car : cars) {
            if (bookingDao.findBookingByCarID(car.getId()) == null) {
                unbookedCars[count] = car;
                count++;
            }
        }
        return unbookedCars;
    }

    public Car[] getAvailableElectricCars() {
        Car[] availableCars = findUnbookedCars();
        Car[] availableElectricCars = new Car[10];
        int count = 0;

        for (Car car : availableCars) {
            if (car != null && car.isElectric()) {
                availableElectricCars[count] = car;
                count++;
            }
        }

        return availableElectricCars;
    }
}
