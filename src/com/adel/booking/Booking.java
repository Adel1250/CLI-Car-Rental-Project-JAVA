package com.adel.booking;

import java.util.Objects;

public class Booking {
    private String userUUID;
    private String carID;

    public Booking(String userUUID, String carID) {
        this.userUUID = userUUID;
        this.carID = carID;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking booking)) return false;
        return Objects.equals(getUserUUID(), booking.getUserUUID()) && Objects.equals(getCarID(), booking.getCarID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserUUID(), getCarID());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userUUID='" + userUUID + '\'' +
                ", carID='" + carID + '\'' +
                '}';
    }
}
