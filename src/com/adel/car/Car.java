package com.adel.car;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private String id;
    private BigDecimal rentalPricePerDay;
    private Brand brand;
    private boolean isElectric;

    public Car(String id, BigDecimal rentalPricePerDay, Brand brand, boolean isElectric) {
        this.id = id;
        this.rentalPricePerDay = rentalPricePerDay;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return isElectric() == car.isElectric() && Objects.equals(getId(), car.getId()) && Objects.equals(getRentalPricePerDay(), car.getRentalPricePerDay()) && getBrand() == car.getBrand();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRentalPricePerDay(), getBrand(), isElectric());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", brand=" + brand +
                ", isElectric=" + isElectric +
                '}';
    }
}
