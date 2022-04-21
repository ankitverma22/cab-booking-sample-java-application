package com.test.cabBooking.repository;

import com.test.cabBooking.entity.LocationEntity;
import com.test.cabBooking.model.Location;

import java.util.List;

public interface LocationRepository {

    LocationEntity saveOrUpdate(LocationEntity location);

    LocationEntity find(String userName, String userType);

    List<LocationEntity> findAllDrivers(Location location, Double range);

}
