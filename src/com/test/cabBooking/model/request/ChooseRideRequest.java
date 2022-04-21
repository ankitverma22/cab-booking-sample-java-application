package com.test.cabBooking.model.request;

import com.test.cabBooking.model.Location;

public class ChooseRideRequest {

    private String userName;
    private Location pickUpLocation;
    private Location dropLocation;
    private String driverUserName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getDriverUserName() {
        return driverUserName;
    }

    public void setDriverUserName(String driverUserName) {
        this.driverUserName = driverUserName;
    }

    @Override
    public String toString() {
        return "ChooseRideRequest{" +
                "userName='" + userName + '\'' +
                ", pickUpLocation=" + pickUpLocation +
                ", dropLocation=" + dropLocation +
                ", driverUserName='" + driverUserName + '\'' +
                '}';
    }
}
