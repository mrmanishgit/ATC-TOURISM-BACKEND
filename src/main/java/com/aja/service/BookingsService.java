package com.aja.service;

import java.util.List;

import com.aja.entity.Bookings;

public interface BookingsService {
	public Bookings addBooking(Bookings b);

	public List<Bookings> viewBookings();

	public Bookings viewById(Long bookingId);

	public Bookings updateBooking(Long bookingId, Bookings b);
}
