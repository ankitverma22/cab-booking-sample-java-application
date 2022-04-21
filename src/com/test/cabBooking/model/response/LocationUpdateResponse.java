package com.test.cabBooking.model.response;

import com.test.cabBooking.model.request.LocationUpdateRequest;

public class LocationUpdateResponse {
    private LocationUpdateRequest locationUpdateRequest;
    private boolean isSuccess;

    public LocationUpdateRequest getLocationUpdateRequest() {
        return locationUpdateRequest;
    }

    public void setLocationUpdateRequest(LocationUpdateRequest locationUpdateRequest) {
        this.locationUpdateRequest = locationUpdateRequest;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
