package com.test.cabBooking.repository;

import com.test.cabBooking.entity.UserDetails;

public interface UserRepository {

    UserDetails saveUserDetails(UserDetails userDetails);

    UserDetails getUserDetails(String userName);

    UserDetails update(UserDetails existingUserDetails);

}
