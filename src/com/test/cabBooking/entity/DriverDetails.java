package com.test.cabBooking.entity;

import com.test.cabBooking.enums.DriverStatus;

import java.time.LocalDateTime;

public class DriverDetails {

    private String userName;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String cabNumber;
    private String cabBrand;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DriverStatus driverStatus;


    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }

    public String getCabBrand() {
        return cabBrand;
    }

    public void setCabBrand(String cabBrand) {
        this.cabBrand = cabBrand;
    }

    @Override
    public String toString() {
        return "DriverDetails{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", cabNumber='" + cabNumber + '\'' +
                ", cabBrand='" + cabBrand + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", driverStatus=" + driverStatus +
                '}';
    }
}
