package com.adel.booking;

import com.adel.car.Car;
import com.adel.car.CarArrayDataAccessService;

public class BookingService {
    private static final BookingArrayDataAccessService BOOKING_ARRAY_DATA_ACCESS_SERVICE = new BookingArrayDataAccessService();
    private static final CarArrayDataAccessService CAR_ARRAY_DATA_ACCESS_SERVICE = new CarArrayDataAccessService();

    public Booking[] getAllBookings() {
        return BOOKING_ARRAY_DATA_ACCESS_SERVICE.getAllBookings();
    }

    public void addNewBooking(Booking booking) {
        if (BOOKING_ARRAY_DATA_ACCESS_SERVICE.findBookingByCarID(booking.getCarID()) != null) {
            System.out.println("Car is already booked. Try again later!");
            return;
        }
        BOOKING_ARRAY_DATA_ACCESS_SERVICE.insertBooking(booking);
    }

    public Car[] findUserBookedCars(String userID) {
        Booking[] bookings = BOOKING_ARRAY_DATA_ACCESS_SERVICE.findBookingsByUserID(userID);
        Car[] bookedCars = new Car[10];
        int count = 0;
        for (Booking booking : bookings) {
            if (booking != null) {
                Car car = CAR_ARRAY_DATA_ACCESS_SERVICE.findCarByID(booking.getCarID());
                if (car != null) {
                    bookedCars[count] = car;
                }
            }
        }
        return bookedCars;
    }

    public Car[] findUnbookedCars() {
        Car[] unbookedCars = new Car[10];
        Car[] cars = CAR_ARRAY_DATA_ACCESS_SERVICE.getAllCars();
        int count = 0;
        for (Car car : cars) {
            if (car != null && BOOKING_ARRAY_DATA_ACCESS_SERVICE.findBookingByCarID(car.getId()) == null) {
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
