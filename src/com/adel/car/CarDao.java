package com.adel.car;

public interface CarDao {
    Car[] getAllCars();
    Car findCarByID(String carID);
}
