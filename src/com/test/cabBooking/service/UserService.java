package com.test.cabBooking.service;

import com.test.cabBooking.entity.LocationEntity;
import com.test.cabBooking.entity.UserDetails;
import com.test.cabBooking.model.request.LocationUpdateRequest;
import com.test.cabBooking.model.request.UserDetailsRequest;
import com.test.cabBooking.model.response.LocationUpdateResponse;
import com.test.cabBooking.repository.LocationRepository;
import com.test.cabBooking.repository.UserRepository;
import com.test.cabBooking.repository.impl.LocationRepositoryImpl;
import com.test.cabBooking.repository.impl.UserRepositoryImpl;

import java.time.LocalDateTime;

public class UserService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public UserService() {
        this.userRepository = new UserRepositoryImpl();
        this.locationRepository = new LocationRepositoryImpl();
    }

    public UserDetails addUser(UserDetailsRequest request) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(request.getFirstName());
        userDetails.setLastName(request.getLastName());
        userDetails.setMobileNumber(request.getMobileNumber());
        userDetails.setCreatedAt(LocalDateTime.now());
        userDetails.setUpdatedAt(LocalDateTime.now());
        userDetails.setUserName(request.getUserName());
        return userRepository.saveUserDetails(userDetails);
    }

    public UserDetails updateUser(UserDetailsRequest request) {
        if (request == null) {
            return null;
        }
        UserDetails existingUserDetails = userRepository.getUserDetails(request.getUserName());
        if (existingUserDetails != null) {
            if (request.getMobileNumber() != null) {
                existingUserDetails.setMobileNumber(request.getMobileNumber());
                return userRepository.update(existingUserDetails);
            }
        }
        return existingUserDetails;
    }

    public LocationUpdateResponse updateUserLocation(LocationUpdateRequest request) {
        LocationEntity location = new LocationEntity();
        location.setUserName(request.getUserName());
        location.setUserType(request.getUserType());
        location.setLatitude(request.getLatitude());
        location.setLongitude(request.getLongitude());

        LocationEntity saved = locationRepository.saveOrUpdate(location);

        LocationUpdateResponse response = new LocationUpdateResponse();
        response.setLocationUpdateRequest(request);
        response.setSuccess(saved != null);

        return response;

    }
}
