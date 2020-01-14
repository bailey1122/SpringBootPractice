package com.sprboot.springboot_practice.services;

public interface FlightBookingService {
    Booking bookFlight(String pickUpLocation) throws BookingException;
}
