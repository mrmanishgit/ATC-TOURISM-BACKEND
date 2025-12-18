package com.aja.service;

import java.util.List;

import com.aja.Dto.BookingsRequestDto;
import com.aja.Dto.BookingsResponseDto;
import com.aja.entity.Bookings;

public interface BookingsService {
	public Bookings addBooking(Bookings b);

	public BookingsResponseDto addBooking(BookingsRequestDto bres);

	public List<Bookings> viewBookings();

	public Bookings viewById(Long bookingId);

	public Bookings updateBooking(Long bookingId, Bookings b);
}
