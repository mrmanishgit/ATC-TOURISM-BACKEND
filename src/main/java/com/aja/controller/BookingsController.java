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

import com.aja.Dto.BookingsRequestDto;
import com.aja.Dto.BookingsResponseDto;
import com.aja.entity.Bookings;
import com.aja.serviceImpl.BookingsServiceImpl;

@RestController
@RequestMapping("/api/book")
public class BookingsController {
	@Autowired
	private BookingsServiceImpl bookImpl;
	
	@PostMapping("/create")
	public ResponseEntity<BookingsResponseDto> Booking(@RequestBody BookingsRequestDto b)
	{
		BookingsResponseDto bdto=bookImpl.addBooking(b);
		return ResponseEntity.ok(bdto);
	}
	
	@GetMapping("/all")
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
	
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<Bookings> updateBooking(@PathVariable Long bookingId,@RequestBody Bookings b)
	{
		return ResponseEntity.ok(bookImpl.updateBooking(bookingId, b));
	}
	
}
