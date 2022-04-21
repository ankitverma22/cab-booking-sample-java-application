package com.test.cabBooking;

import com.test.cabBooking.entity.DriverDetails;
import com.test.cabBooking.entity.UserDetails;
import com.test.cabBooking.enums.DriverStatus;
import com.test.cabBooking.model.Location;
import com.test.cabBooking.model.request.*;
import com.test.cabBooking.model.response.CalculateBillResponse;
import com.test.cabBooking.model.response.ChooseRideResponse;
import com.test.cabBooking.model.response.FindRideResponse;
import com.test.cabBooking.model.response.TotalEarningResponse;
import com.test.cabBooking.service.CabBookingService;
import com.test.cabBooking.service.DriverService;
import com.test.cabBooking.service.UserService;

public class Driver {
    public static void main(String[] args) {

        UserService userService = new UserService();
        DriverService driverService = new DriverService();
        CabBookingService cabBookingService = new CabBookingService();


        UserDetails user1 = userService.addUser(addUserRequest("Abhishek", "+91xxxxxxxxx"));
        userService.updateUserLocation(updateLocationRequest(user1.getUserName(), "RIDER", 0d,0d));
        System.out.println(user1);

        UserDetails user2 = userService.addUser(addUserRequest("Rahul", "+91xxxxxxxxx"));
        userService.updateUserLocation(updateLocationRequest(user2.getUserName(), "RIDER", 0d,0d));
        System.out.println(user2);

        UserDetails user3 = userService.addUser(addUserRequest("Nandini", "+91xxxxxxxxx"));
        userService.updateUserLocation(updateLocationRequest(user3.getUserName(), "RIDER", 0d,0d));
        System.out.println(user3);

        DriverDetails driver1 = driverService.addDriver(addDriverRequest("Driver1", "Swift", "KA-01-12345"));
        driverService.updateDriverLocation(updateLocationRequest(driver1.getUserName(), "DRIVER", 10d,1d));
        System.out.println(driver1);

        DriverDetails driver2 = driverService.addDriver(addDriverRequest("Driver2", "Swift", "KA-01-12345"));
        driverService.updateDriverLocation(updateLocationRequest(driver2.getUserName(), "DRIVER", 11d,10d));
        System.out.println(driver2);

        DriverDetails driver3 = driverService.addDriver(addDriverRequest("Driver3", "Swift", "KA-01-12345"));
        driverService.updateDriverLocation(updateLocationRequest(driver3.getUserName(), "DRIVER", 5d,3d));
        System.out.println(driver3);

        FindRideResponse findRideResponse1 = cabBookingService.findRide(findRideRequest(user1.getUserName(), 0d,0d, 20d,1d));
        System.out.println(findRideResponse1);
        FindRideResponse findRideResponse2 = cabBookingService.findRide(findRideRequest(user2.getUserName(), 10d,0d, 15d,3d));
        System.out.println(findRideResponse2);

        ChooseRideResponse chooseRideResponse = cabBookingService.chooseRide(chooseRideRequest(user2.getUserName(),driver1.getUserName(), 10d,0d, 15d,3d));
        System.out.println(chooseRideResponse);
        CalculateBillResponse calculateBillResponse = cabBookingService.calculateBill(calculateBillRequest(chooseRideResponse.getCabBookingDetails().getBookingId()));
        System.out.println(calculateBillResponse);

        userService.updateUserLocation(updateLocationRequest(user2.getUserName(), "RIDER", 15d,3d));
        driverService.updateDriverLocation(updateLocationRequest(driver1.getUserName(), "DRIVER", 15d,3d));

        DriverDetails driverDetails = driverService.updateDriverStatus(driver1.getUserName(), DriverStatus.OFF_DUTY);
        System.out.println(driverDetails);
        FindRideResponse findRideResponse3 = cabBookingService.findRide(findRideRequest(user3.getUserName(), 15d,6d,20d,4d));
        System.out.println(findRideResponse3);

        TotalEarningResponse totalEarningResponse = cabBookingService.totalEarning();
        System.out.println(totalEarningResponse);
    }


    public static UserDetailsRequest addUserRequest(String name, String mobile) {
        UserDetailsRequest userDetailsRequest = new UserDetailsRequest();
        userDetailsRequest.setUserName(name);

        return userDetailsRequest;
    }

    public static LocationUpdateRequest updateLocationRequest(String username, String userType, Double latitude, Double longitude) {
        LocationUpdateRequest request = new LocationUpdateRequest();
        request.setUserName(username);
        request.setUserType(userType);
        request.setLatitude(latitude);
        request.setLongitude(longitude);

        return request;
    }

    public static DriverDetailsRequest addDriverRequest(String name, String carBrand, String carNumber) {
        DriverDetailsRequest driverDetailsRequest = new DriverDetailsRequest();
        driverDetailsRequest.setUserName(name);
        driverDetailsRequest.setCabBrand(carBrand);
        driverDetailsRequest.setCabNumber(carNumber);

        return driverDetailsRequest;
    }

    public static FindRideRequest findRideRequest(String userName, Double pickupLat, Double pickUpLong, Double dropLat, Double dropLong) {
        FindRideRequest request = new FindRideRequest();
        Location pickUp = new Location();
        pickUp.setLatitude(pickupLat);
        pickUp.setLongitude(pickUpLong);

        Location drop = new Location();
        drop.setLatitude(dropLat);
        drop.setLongitude(dropLong);

        request.setUserName(userName);
        request.setPickUpLocation(pickUp);
        request.setDropLocation(drop);
        return request;

    }

    public static ChooseRideRequest chooseRideRequest(String userName, String driverName, Double pickupLat, Double pickUpLong, Double dropLat, Double dropLong) {
        ChooseRideRequest request = new ChooseRideRequest();
        Location pickUp = new Location();
        pickUp.setLatitude(pickupLat);
        pickUp.setLongitude(pickUpLong);

        Location drop = new Location();
        drop.setLatitude(dropLat);
        drop.setLongitude(dropLong);

        request.setUserName(userName);
        request.setPickUpLocation(pickUp);
        request.setDropLocation(drop);
        request.setDriverUserName(driverName);

        return request;
    }

    public static CalculateBillRequest calculateBillRequest(Long bookingId) {
        CalculateBillRequest request =new CalculateBillRequest();
        request.setBookingId(bookingId);
        return request;
    }
}
