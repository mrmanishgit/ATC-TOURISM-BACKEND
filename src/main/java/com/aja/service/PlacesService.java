package com.aja.service;

import java.util.List;

import com.aja.entity.Places;

public interface PlacesService {
	public Places addPlace(Places p);
	public List<Places> viewAllPlaces();
	public Places viewPlace(Long placeId);
	public Places updatePlace(Long placeId,Places p);
}
