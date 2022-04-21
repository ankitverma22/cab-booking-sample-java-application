package com.test.cabBooking.model.response;

import com.test.cabBooking.entity.DriverDetails;

import java.util.List;

public class FindRideResponse {

    private List<DriverDetails> driverDetails;

    public List<DriverDetails> getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(List<DriverDetails> driverDetails) {
        this.driverDetails = driverDetails;
    }

    @Override
    public String toString() {
        return "FindRideResponse{" +
                "driverDetails=" + driverDetails +
                '}';
    }
}
