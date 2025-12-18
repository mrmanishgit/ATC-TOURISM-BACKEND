package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.BookingsRequestDto;
import com.aja.Dto.BookingsResponseDto;
import com.aja.entity.Bookings;
import com.aja.repository.BookingsRepo;
import com.aja.service.BookingsService;
@Service
public class BookingsServiceImpl implements BookingsService {
	@Autowired
	private BookingsRepo bRepo;
	
	@Override
	public BookingsResponseDto addBooking(BookingsRequestDto bres) {
		// TODO Auto-generated method stub
		Bookings b=new Bookings();
		BeanUtils.copyProperties(bres, b);
		Bookings savent=bRepo.save(b);
		BookingsResponseDto bdto=new BookingsResponseDto(); 
		BeanUtils.copyProperties(savent, bdto);
		return bdto;
	}

	@Override
	public List<Bookings> viewBookings() {
		// TODO Auto-generated method stub
		
		return bRepo.findAll();
	}

	@Override
	public Bookings updateBooking(Long bookingId,Bookings b) {
		// TODO Auto-generated method stub
		
		Bookings bs=bRepo.findById(bookingId).orElse(null);
		b.setTravelDate(b.getTravelDate());
		b.setNoOfAdults(b.getNoOfAdults());
		b.setNoOfChildren(b.getNoOfChildren());
		bs.setBookingStatus(b.getBookingStatus());
		bs.setCreatedAt(b.getCreatedAt());
		return bs;
	}

	@Override
	public Bookings viewById(Long bookingId) {
		// TODO Auto-generated method stub
		return bRepo.findById(bookingId).orElse(null);
	}

}
