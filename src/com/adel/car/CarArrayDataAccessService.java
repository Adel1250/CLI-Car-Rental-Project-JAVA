package com.adel.car;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CarArrayDataAccessService implements CarDao{
    private static final Car[] cars;
    private static int carsCount;

    static {
        carsCount = 0;
        cars = new Car[50];
        readCSVFile();
    }

    @Override
    public Car[] getAllCars() {
        return cars;
    }

    @Override
    public Car findCarByID(String carID) {
        for (Car car : cars) {
            if (car != null && car.getId().equals(carID)) {
                return car;
            }
        }
        return null;
    }

    private static void readCSVFile() {
        File file = new File("src/com/adel/cars.csv");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("Cars file is created successfully!");
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
            String[] carLineValues = scanner.nextLine().split(", ");
            Car car = new Car(carLineValues[0], new BigDecimal(carLineValues[1]), Brand.valueOf(carLineValues[2]), Boolean.parseBoolean(carLineValues[3]));
            cars[carsCount] = car;
            carsCount++;
            if (carsCount == 50) {
                carsCount = 0;
            }
        }
    }
}
