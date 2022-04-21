package com.test.cabBooking.repository.impl;

import com.test.cabBooking.entity.DriverDetails;
import com.test.cabBooking.repository.DriverRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DriverRepositoryImpl implements DriverRepository {

    private static final Map<String, DriverDetails> driverMap = new HashMap<>();

    @Override
    public DriverDetails save(DriverDetails driverDetails) {
        if (driverMap.containsKey(driverDetails.getUserName())) {
            throw new IllegalArgumentException("Driver username already exists");
        }
        driverMap.put(driverDetails.getUserName(), driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails update(DriverDetails driverDetails) {
        if (driverDetails == null) {
            return null;
        }
        driverDetails.setUpdatedAt(LocalDateTime.now());
        driverMap.put(driverDetails.getUserName(), driverDetails);
        return driverDetails;
    }

    @Override
    public DriverDetails getDriverByUserName(String driverUserName) {
        return driverMap.getOrDefault(driverUserName, null);
    }
}
