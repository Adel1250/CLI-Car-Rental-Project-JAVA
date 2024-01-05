package com.adel.car;

import java.math.BigDecimal;

public class CarDao {
    private static final Car[] cars;

    static {
        cars = new Car[] {
                new Car("1234", new BigDecimal("250.75"), Brand.TESLA, true),
                new Car("2345", new BigDecimal("125"), Brand.KIA, false),
                new Car("3456", new BigDecimal("300.25"), Brand.MERCEDES, false),
                new Car("4567", new BigDecimal("175"), Brand.TOYOTA, false)
        };
    }

    public Car[] getAllCars() {
        return cars;
    }

    public Car findCarByID(String carID) {
        for (Car car : cars) {
            if (car != null && car.getId().equals(carID)) {
                return car;
            }
        }
        return null;
    }
}
