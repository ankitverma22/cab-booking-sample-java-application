package com.test.cabBooking.service;

import com.test.cabBooking.entity.CabBookingDetails;
import com.test.cabBooking.entity.DriverDetails;
import com.test.cabBooking.entity.LocationEntity;
import com.test.cabBooking.entity.UserDetails;
import com.test.cabBooking.enums.BookingStatusEnum;
import com.test.cabBooking.enums.DriverStatus;
import com.test.cabBooking.model.Location;
import com.test.cabBooking.model.request.CalculateBillRequest;
import com.test.cabBooking.model.request.ChooseRideRequest;
import com.test.cabBooking.model.request.FindRideRequest;
import com.test.cabBooking.model.response.CalculateBillResponse;
import com.test.cabBooking.model.response.ChooseRideResponse;
import com.test.cabBooking.model.response.FindRideResponse;
import com.test.cabBooking.model.response.TotalEarningResponse;
import com.test.cabBooking.repository.BookingRepository;
import com.test.cabBooking.repository.DriverRepository;
import com.test.cabBooking.repository.LocationRepository;
import com.test.cabBooking.repository.UserRepository;
import com.test.cabBooking.repository.impl.BookingRepositoryImpl;
import com.test.cabBooking.repository.impl.DriverRepositoryImpl;
import com.test.cabBooking.repository.impl.LocationRepositoryImpl;
import com.test.cabBooking.repository.impl.UserRepositoryImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CabBookingService {
    public static final BigDecimal FIX_CHARGES = BigDecimal.valueOf(100);
    private static long bookingIdCounter = 1;
    private final LocationRepository locationRepository;
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    public CabBookingService() {
        this.locationRepository = new LocationRepositoryImpl();
        this.driverRepository = new DriverRepositoryImpl();
        this.userRepository = new UserRepositoryImpl();
        this.bookingRepository = new BookingRepositoryImpl();
    }

    public static long getBookingIdCounter() {
        long currentBookingId = bookingIdCounter;
        bookingIdCounter += bookingIdCounter;
        return currentBookingId;
    }

    public FindRideResponse findRide(FindRideRequest request) {

        List<LocationEntity> driversWithInRange = locationRepository.findAllDrivers(request.getPickUpLocation(), 5.0d);
        List<DriverDetails> drivers = driversWithInRange.stream()
                .map(x -> driverRepository.getDriverByUserName(x.getUserName()))
                .filter(x -> DriverStatus.ON_DUTY.equals(x.getDriverStatus()))
                .collect(Collectors.toList());

        FindRideResponse response =  new FindRideResponse();
        response.setDriverDetails(drivers);
        return response;
    }

    public ChooseRideResponse chooseRide(ChooseRideRequest request) {
        DriverDetails driver = driverRepository.getDriverByUserName(request.getDriverUserName());
        UserDetails user = userRepository.getUserDetails(request.getUserName());

        CabBookingDetails cabBookingDetails = new CabBookingDetails();
        cabBookingDetails.setUserId(user.getUserName());
        cabBookingDetails.setDriverId(driver.getUserName());
        cabBookingDetails.setCabNumber(driver.getCabNumber());
        cabBookingDetails.setPickUpLocation(request.getPickUpLocation());
        cabBookingDetails.setDropLocation(request.getDropLocation());
        cabBookingDetails.setBookingStatusEnum(BookingStatusEnum.CREATED);
        cabBookingDetails.setPaymentStatus("PENDING");
        cabBookingDetails.setBookingId(getBookingIdCounter());
        cabBookingDetails = bookingRepository.save(cabBookingDetails);

        ChooseRideResponse response = new ChooseRideResponse();
        response.setChooseRideRequest(request);
        response.setCabBookingDetails(cabBookingDetails);
        response.setSuccess(true);
        return response;
    }

    public CalculateBillResponse calculateBill(CalculateBillRequest request) {
        CabBookingDetails cabBookingDetails = bookingRepository.getBooking(request.getBookingId());
        cabBookingDetails.setPaymentStatus("SUCCESS");
        cabBookingDetails.setBookingStatusEnum(BookingStatusEnum.TRIP_COMPLETED);
        Double distance = distance(cabBookingDetails.getPickUpLocation(), cabBookingDetails.getDropLocation());

        BigDecimal bill = FIX_CHARGES.add(BigDecimal.valueOf(5).multiply(BigDecimal.valueOf(distance)));

        cabBookingDetails.setPaymentAmount(bill);

        CalculateBillResponse calculateBillResponse = new CalculateBillResponse();
        calculateBillResponse.setCabBookingDetails(cabBookingDetails);
        calculateBillResponse.setBillAmount(bill);

        bookingRepository.save(cabBookingDetails);
        return calculateBillResponse;

    }

    private Double distance(Location a, Location b) {
        return Math.sqrt(Math.pow(a.getLatitude()-b.getLatitude(),2) + Math.pow(a.getLongitude()-b.getLongitude(),2));
    }

    public TotalEarningResponse totalEarning() {
        Map<String, BigDecimal> earnings = bookingRepository.getAll()
                .stream()
                .collect(Collectors.toMap(CabBookingDetails::getDriverId, CabBookingDetails::getPaymentAmount, BigDecimal::add));
        TotalEarningResponse totalEarningResponse = new TotalEarningResponse();
        totalEarningResponse.setDriverVsEarning(earnings);
        return totalEarningResponse;
    }


}
