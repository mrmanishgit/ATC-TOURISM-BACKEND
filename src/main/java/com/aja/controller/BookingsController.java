package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.entity.Bookings;
import com.aja.serviceImpl.BookingsServiceImpl;

@RestController
@RequestMapping("/book")
public class BookingsController {
	@Autowired
	private BookingsServiceImpl bookImpl;
	
	@PostMapping
	public ResponseEntity<Bookings> Booking(@RequestBody Bookings b)
	{
		return ResponseEntity.ok(bookImpl.addBooking(b));
	}
	
	@GetMapping
	public List<Bookings> getAllBookings()
	{
		return bookImpl.viewBookings();
	}
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<Bookings> getBookingById(@PathVariable Long bookingId)
	{
		Bookings b=bookImpl.viewById(bookingId);
		return ResponseEntity.ok(b);
	}
	
	@PutMapping("/{bookingId}")
	public ResponseEntity<Bookings> updateBooking(@PathVariable Long bookingId,@RequestBody Bookings b)
	{
		return ResponseEntity.ok(bookImpl.updateBooking(bookingId, b));
	}
	
}
