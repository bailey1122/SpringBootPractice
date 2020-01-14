package com.sprboot.springboot_practice.services;

import static java.lang.StrictMath.random;
import static java.util.UUID.randomUUID;

public class FlightBookingServiceImpl implements FlightBookingService {
    @Override
    public Booking bookFlight(String pickUpLocation) throws BookingException {
        if (random() < 0.3) throw new BookingException("Plane unavailable");
        return new Booking(randomUUID().toString());
    }
}
