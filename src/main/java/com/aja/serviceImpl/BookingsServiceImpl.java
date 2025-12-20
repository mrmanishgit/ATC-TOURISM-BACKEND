package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public List<BookingsResponseDto> viewBookings() {
		// TODO Auto-generated method stub
		List<Bookings> Booking=bRepo.findAll();
		
		List<BookingsResponseDto> responselist=new ArrayList<>();
		
		for(Bookings book:Booking)
		{
			BookingsResponseDto dto=new BookingsResponseDto();
			BeanUtils.copyProperties(book, responselist);
			responselist.add(dto);
		}
		return responselist;
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
	public BookingsResponseDto viewById(Long bookingId) {
		// TODO Auto-generated method stub
		
		Optional<Bookings> optionalBooking=bRepo.findById(bookingId);
		if(optionalBooking.isEmpty()) {
			return null;
		}
		 
		Bookings book=optionalBooking.get();
		BookingsResponseDto response=new BookingsResponseDto();
		BeanUtils.copyProperties(book, response);
		
		return response;
	}

	

	@Override
	public String deleteBooking(Long bookingId) {
		// TODO Auto-generated method stub
		Optional<Bookings> delById=bRepo.findById(bookingId);
		Bookings book=null;
		
		if(delById.isPresent())
		{
			book=delById.get();
			
			book.setFlag(false);
			
			bRepo.save(book);
		}
		if(book!=null)
		{
			return "booking deleted successfully";
		}
		else {
			return "booking not deleted successfully";
		}
	}

}
