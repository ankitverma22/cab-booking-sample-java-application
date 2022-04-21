package com.test.cabBooking.repository;

import com.test.cabBooking.entity.DriverDetails;

public interface DriverRepository {

    DriverDetails save(DriverDetails driverDetails);

    DriverDetails update(DriverDetails driverDetails);

    DriverDetails getDriverByUserName(String driverUserName);
}
