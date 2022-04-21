package com.test.cabBooking.model.request;

public class DriverDetailsRequest {


    private String userName;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String cabNumber;
    private String cabBrand;

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
}
