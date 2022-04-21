package com.test.cabBooking.repository;

import com.test.cabBooking.entity.CabBookingDetails;

import java.math.BigDecimal;
import java.util.List;

public interface BookingRepository {

    CabBookingDetails save(CabBookingDetails cabBookingDetails);

    CabBookingDetails getBooking(Long bookingId);

    List<CabBookingDetails> getAll();

}
