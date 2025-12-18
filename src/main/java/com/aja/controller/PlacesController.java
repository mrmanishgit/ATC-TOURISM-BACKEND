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

import com.aja.Dto.PlacesRequestDto;
import com.aja.Dto.PlacesResponseDto;
import com.aja.entity.Places;
import com.aja.serviceImpl.PlacesServiceImpl;

@RestController
@RequestMapping("/place")
public class PlacesController {
	@Autowired
	private PlacesServiceImpl placeImpl;
	@PostMapping
	public ResponseEntity<PlacesResponseDto> place(@RequestBody PlacesRequestDto p)
	{
		
		PlacesResponseDto place = placeImpl.addPlace(p);
		return ResponseEntity.ok(place);
	}
	@GetMapping
	public List<Places> getAllPlaces()
	{
		return placeImpl.viewAllPlaces();
	}
	@GetMapping("/{placeId}")
	public ResponseEntity<Places> getplaceById(@PathVariable Long placeId)
	{
		Places ps=placeImpl.viewPlace(placeId);
		return ResponseEntity.ok(ps);
	}
	@PutMapping("/{placeId}")
	public ResponseEntity<Places> update(@PathVariable Long placeId,@RequestBody Places p)
	{
		return ResponseEntity.ok(placeImpl.updatePlace(placeId, p));
	}
}
