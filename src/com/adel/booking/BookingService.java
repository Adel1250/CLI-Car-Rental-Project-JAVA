package com.adel.booking;

import com.adel.car.Car;
import com.adel.car.CarArrayDataAccessService;

public class BookingService {
    private final BookingArrayDataAccessService bookingArrayDataAccessService;
    private final CarArrayDataAccessService carArrayDataAccessService;

    public BookingService(BookingArrayDataAccessService bookingArrayDataAccessService, CarArrayDataAccessService carArrayDataAccessService) {
        this.bookingArrayDataAccessService = bookingArrayDataAccessService;
        this.carArrayDataAccessService = carArrayDataAccessService;
    }

    public Booking[] getAllBookings() {
        return bookingArrayDataAccessService.getAllBookings();
    }

    public void addNewBooking(Booking booking) {
        if (bookingArrayDataAccessService.findBookingByCarID(booking.getCarID()) != null) {
            System.out.println("Car is already booked. Try again later!");
            return;
        }
        bookingArrayDataAccessService.insertBooking(booking);
    }

    public Car[] findUserBookedCars(String userID) {
        Booking[] bookings = bookingArrayDataAccessService.findBookingsByUserID(userID);
        Car[] bookedCars = new Car[10];
        int count = 0;
        for (Booking booking : bookings) {
            if (booking != null) {
                Car car = carArrayDataAccessService.findCarByID(booking.getCarID());
                if (car != null) {
                    bookedCars[count] = car;
                }
            }
        }
        return bookedCars;
    }

    public Car[] findUnbookedCars() {
        Car[] unbookedCars = new Car[10];
        Car[] cars = carArrayDataAccessService.getAllCars();
        int count = 0;
        for (Car car : cars) {
            if (car != null && bookingArrayDataAccessService.findBookingByCarID(car.getId()) == null) {
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
