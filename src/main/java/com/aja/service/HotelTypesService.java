package com.aja.service;

import java.util.List;

import com.aja.entity.HotelTypes;

public interface HotelTypesService {

	HotelTypes saveHotel(HotelTypes hotelTypes);

	List<HotelTypes> getAllEnquiries();

	HotelTypes getEnquiryById(Long Id);

	HotelTypes updateHoteType(long id, HotelTypes hotelTypes);
}
