package com.test.cabBooking.service;

import com.test.cabBooking.entity.DriverDetails;
import com.test.cabBooking.entity.LocationEntity;
import com.test.cabBooking.enums.DriverStatus;
import com.test.cabBooking.model.request.DriverDetailsRequest;
import com.test.cabBooking.model.request.LocationUpdateRequest;
import com.test.cabBooking.model.response.LocationUpdateResponse;
import com.test.cabBooking.repository.DriverRepository;
import com.test.cabBooking.repository.LocationRepository;
import com.test.cabBooking.repository.impl.DriverRepositoryImpl;
import com.test.cabBooking.repository.impl.LocationRepositoryImpl;

public class DriverService {

    private final DriverRepository driverRepository;
    private final LocationRepository locationRepository;

    public DriverService() {
        this.driverRepository = new DriverRepositoryImpl();
        this.locationRepository = new LocationRepositoryImpl();

    }

    public DriverDetails addDriver(DriverDetailsRequest request) {
        if (request == null) {
            return null;
        }

        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setUserName(request.getUserName());
        driverDetails.setFirstName(request.getFirstName());
        driverDetails.setLastName(request.getLastName());
        driverDetails.setMobileNumber(request.getMobileNumber());
        driverDetails.setCabNumber(request.getCabNumber());
        driverDetails.setCabBrand(request.getCabBrand());
        driverDetails.setDriverStatus(DriverStatus.ON_DUTY);

        return driverRepository.save(driverDetails);

    }

    public LocationUpdateResponse updateDriverLocation(LocationUpdateRequest request) {

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

    public DriverDetails updateDriverStatus(String driverUserName, DriverStatus driverStatus) {

        DriverDetails driverDetails = driverRepository.getDriverByUserName(driverUserName);

        if (driverDetails == null) {
            return null;
        }

        driverDetails.setDriverStatus(driverStatus);
        driverRepository.update(driverDetails);

        return driverDetails;
    }




}
