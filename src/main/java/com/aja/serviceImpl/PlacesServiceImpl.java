package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.Places;
import com.aja.repository.PlacesRepo;
import com.aja.service.PlacesService;
@Service
public class PlacesServiceImpl implements PlacesService {
	@Autowired
	private PlacesRepo pRepo;
	@Override
	public Places addPlace(Places p) {
		// TODO Auto-generated method stub
		
		Places ps=pRepo.save(p);
		return ps;
	}

	@Override
	public List<Places> viewAllPlaces() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}

	@Override
	public Places updatePlace(Long placeId,Places p) {
		// TODO Auto-generated method stub
		Places ps=pRepo.findById(placeId).orElse(null);
		ps.setPlaceName(p.getPlaceName());
		ps.setDescription(p.getDescription());
		return ps;
	}

	@Override
	public Places viewPlace(Long placeId) {
		// TODO Auto-generated method stub
		Places ps=pRepo.findById(placeId).orElse(null);
		return ps;
	}

}
