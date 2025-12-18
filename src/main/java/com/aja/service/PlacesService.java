package com.aja.service;

import java.util.List;

import com.aja.Dto.PlacesRequestDto;
import com.aja.Dto.PlacesResponseDto;
import com.aja.entity.Places;

public interface PlacesService {
	public PlacesResponseDto addPlace(PlacesRequestDto p);

	public List<Places> viewAllPlaces();

	public Places viewPlace(Long placeId);

	public Places updatePlace(Long placeId, Places p);
}
