package com.test.cabBooking.repository.impl;

import com.test.cabBooking.entity.LocationEntity;
import com.test.cabBooking.model.Location;
import com.test.cabBooking.repository.LocationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocationRepositoryImpl implements LocationRepository {

    private static final Map<String, LocationEntity> locationMap = new HashMap<>();

    @Override
    public LocationEntity saveOrUpdate(LocationEntity location) {
        locationMap.put(location.getUserType() + ":" + location.getUserName(), location);
        return location;
    }

    @Override
    public LocationEntity find(String userName, String userType) {
        return locationMap.getOrDefault(userType + ":" + userName, null);
    }

    @Override
    public List<LocationEntity> findAllDrivers(Location location, Double range) {
        return locationMap.values().stream()
                .filter(l -> "DRIVER".equalsIgnoreCase(l.getUserType()))
                .filter(l -> Math.pow(location.getLatitude()-l.getLatitude(), 2.0d) +  Math.pow(location.getLongitude()-l.getLongitude(), 2.0d) <= Math.pow(range, 2.0d))
                .collect(Collectors.toList());
    }
}
