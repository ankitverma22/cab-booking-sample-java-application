package com.test.cabBooking.model.response;

import com.test.cabBooking.entity.CabBookingDetails;
import com.test.cabBooking.model.request.ChooseRideRequest;

public class ChooseRideResponse {

    private ChooseRideRequest chooseRideRequest;

    private CabBookingDetails cabBookingDetails;

    private boolean isSuccess;


    public ChooseRideRequest getChooseRideRequest() {
        return chooseRideRequest;
    }

    public void setChooseRideRequest(ChooseRideRequest chooseRideRequest) {
        this.chooseRideRequest = chooseRideRequest;
    }

    public CabBookingDetails getCabBookingDetails() {
        return cabBookingDetails;
    }

    public void setCabBookingDetails(CabBookingDetails cabBookingDetails) {
        this.cabBookingDetails = cabBookingDetails;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "ChooseRideResponse{" +
                "chooseRideRequest=" + chooseRideRequest +
                ", cabBookingDetails=" + cabBookingDetails +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
