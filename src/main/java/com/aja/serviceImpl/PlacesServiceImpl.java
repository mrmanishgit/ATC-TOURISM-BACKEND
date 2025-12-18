package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PlacesRequestDto;
import com.aja.Dto.PlacesResponseDto;
import com.aja.entity.Places;
import com.aja.repository.PlacesRepo;
import com.aja.service.PlacesService;
@Service
public class PlacesServiceImpl implements PlacesService {
	@Autowired
	private PlacesRepo pRepo;
	@Override
	public PlacesResponseDto addPlace(PlacesRequestDto p) {
		// TODO Auto-generated method stub
		
		Places place = new Places();
		
		BeanUtils.copyProperties(p, place);
		
		Places entity =pRepo.save(place);
		
		PlacesResponseDto pRes = new PlacesResponseDto();
		
		BeanUtils.copyProperties(entity, pRes);
		
		return pRes;
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
