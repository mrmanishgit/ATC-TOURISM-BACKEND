package com.aja.service;

import java.util.List;

import com.aja.Dto.HotelTypesRequestDto;
import com.aja.Dto.HotelTypesResponseDto;
import com.aja.entity.HotelTypes;

public interface HotelTypesService {

	HotelTypesResponseDto saveHotel(HotelTypesRequestDto hotelTypes);

	List<HotelTypes> getAllEnquiries();

	HotelTypes getEnquiryById(Long Id);

	HotelTypes updateHoteType(long id, HotelTypes hotelTypes);
}
