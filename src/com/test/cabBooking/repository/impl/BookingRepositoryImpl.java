package com.test.cabBooking.repository.impl;

import com.test.cabBooking.entity.CabBookingDetails;
import com.test.cabBooking.repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingRepositoryImpl implements BookingRepository {
    private static final Map<Long, CabBookingDetails> bookingMap = new HashMap<>();

    @Override
    public CabBookingDetails save(CabBookingDetails cabBookingDetails) {
        bookingMap.put(cabBookingDetails.getBookingId(), cabBookingDetails);
        return cabBookingDetails;
    }

    @Override
    public CabBookingDetails getBooking(Long bookingId) {
        return bookingMap.getOrDefault(bookingId, null);
    }

    @Override
    public List<CabBookingDetails> getAll() {
        return new ArrayList<>(bookingMap.values());
    }

}
