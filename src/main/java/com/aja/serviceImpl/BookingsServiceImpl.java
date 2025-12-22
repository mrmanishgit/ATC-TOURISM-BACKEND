package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.BookingDeleteResponseDto;
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
			BeanUtils.copyProperties(book, dto);
			responselist.add(dto);
		}
		return responselist;
	}

	@Override
	public BookingsResponseDto updateBooking(Long bookingId,BookingsRequestDto b) {
		// TODO Auto-generated method stub
		
		Optional<Bookings> UpdateById = bRepo.findById(bookingId);
		if (UpdateById.isEmpty()) {
			return null;
		}
 
		Bookings bookings = UpdateById.get();
 
		BeanUtils.copyProperties(b, bookings, "bookingId");
		// update only required or id fields
		Bookings updated = bRepo.save(bookings);
 
		BookingsResponseDto bres = new BookingsResponseDto();
 
		BeanUtils.copyProperties(updated, bres);
 
		return bres;
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

	public BookingDeleteResponseDto deleteBooking(Long bookingId) {

		Optional<Bookings> byId = bRepo.findById(bookingId);
		 
		BookingDeleteResponseDto bdelRes = new BookingDeleteResponseDto();
 
		if (byId.isPresent()) {
			Bookings b = byId.get();
//			soft delete by flag
			b.setFlag(false);
			bRepo.save(b);
			bdelRes.setDeleted(true);
			bdelRes.setMessage("Place Deleted Successfully");
 
		}
		else {
			bdelRes.setDeleted(false);
			bdelRes.setMessage("Place Not  Deleted Successfully");
		}
		return bdelRes;
	}

}
