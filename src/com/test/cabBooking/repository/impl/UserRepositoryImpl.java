package com.test.cabBooking.repository.impl;

import com.test.cabBooking.entity.UserDetails;
import com.test.cabBooking.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private static final Map<String, UserDetails> userDetailsMap = new HashMap<>();

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
            if (!userDetailsMap.containsKey(userDetails.getUserName())) {
                userDetailsMap.put(userDetails.getUserName(), userDetails);
                return userDetails;
            } else {
                throw new IllegalArgumentException("Username is already exists");
            }
    }

    @Override
    public UserDetails getUserDetails(String userName) {
        return userDetailsMap.getOrDefault(userName, null);
    }

    @Override
    public UserDetails update(UserDetails existingUserDetails) {
        existingUserDetails.setUpdatedAt(LocalDateTime.now());

        userDetailsMap.put(existingUserDetails.getUserName(), existingUserDetails);
        return existingUserDetails;

    }


}
