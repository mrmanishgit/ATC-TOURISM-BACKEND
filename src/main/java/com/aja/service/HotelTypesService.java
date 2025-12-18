package com.aja.service;

import java.util.List;

import com.aja.entity.HotelTypes;

public interface HotelTypesService {

	public HotelTypes saveHotel(HotelTypes hotelTypes);

	public List<HotelTypes> getAllEnquiries();

	public HotelTypes getEnquiryById(Long Id);

	public HotelTypes updateHoteType(long id, HotelTypes hotelTypes);
}
