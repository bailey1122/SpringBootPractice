package com.sprboot.springboot_practice.services;

import java.io.Serializable;

import static java.lang.String.format;

public class Booking implements Serializable {
    private String bookingCode;

    @Override
    public String toString() {
        return format("Flight confirmed: code '%s'.", bookingCode);
    }

    public Booking(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }
}
