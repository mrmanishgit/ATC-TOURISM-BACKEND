package com.aja.serviceImpl;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.aja.Dto.PlacesDeleteResponseDto;
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
 
		Places entity = pRepo.save(place);
 
		PlacesResponseDto pRes = new PlacesResponseDto();
 
		BeanUtils.copyProperties(entity, pRes);
 
		return pRes;
	}
 
	@Override
	public List<PlacesResponseDto> viewAllPlaces() {
		// TODO Auto-generated method stub
 
		List<Places> viewAllPlaces = pRepo.findAll();
 
		List<PlacesResponseDto> resList = new ArrayList<>();
 
		for (Places place : viewAllPlaces) {
 
			PlacesResponseDto dtoRes = new PlacesResponseDto();
 
			BeanUtils.copyProperties(place, dtoRes);
 
			resList.add(dtoRes);
		}
		return resList;
 
	}
 
	@Override
	public PlacesResponseDto updatePlace(Long placeId, PlacesRequestDto p) {
 
		Optional<Places> UpdateById = pRepo.findById(placeId);
		if (UpdateById.isEmpty()) {
			return null;
		}
 
		Places places = UpdateById.get();
 
		BeanUtils.copyProperties(p, places, "placeId");
		// update only required or id fields
		Places updated = pRepo.save(places);
 
		PlacesResponseDto pres = new PlacesResponseDto();
 
		BeanUtils.copyProperties(updated, pres);
 
		return pres;
 
	}
 
	@Override
	public PlacesResponseDto viewPlace(Long placeId) {
 
		Optional<Places> viewById = pRepo.findById(placeId);
 
		Places places = null;
		if (viewById.isEmpty()) {
			return null;
		}
		places = viewById.get();
 
		PlacesResponseDto pres = new PlacesResponseDto();
 
		BeanUtils.copyProperties(places, pres);
 
		return pres;
	}
 
	@Override
	public PlacesDeleteResponseDto deletePlace(Long id) {
 
		Optional<Places> byId = pRepo.findById(id);
 
		PlacesDeleteResponseDto pdelRes = new PlacesDeleteResponseDto();
 
		if (byId.isPresent()) {
			Places p = byId.get();
//			soft delete by flag
			p.setIsFlag(false);
			pRepo.save(p);
			pdelRes.setDeleted(true);
			pdelRes.setMessage("Place Deleted Successfully");
 
		}
		else {
			pdelRes.setDeleted(false);
			pdelRes.setMessage("Place Not  Deleted Successfully");
		}
		return pdelRes;
	}
 
}