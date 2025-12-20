package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.StatesDeleteResponseDto;
import com.aja.Dto.StatesRequestDto;
import com.aja.Dto.StatesResponseDto;
import com.aja.entity.States;
import com.aja.repository.StatesRepo;
import com.aja.service.StatesService;

@Service
public class StatesServiceImpl implements StatesService {
	@Autowired
	private StatesRepo sRepo;

	@Override
	public StatesResponseDto addState(StatesRequestDto sr) {
		// TODO Auto-generated method stub
		States s = new States();
		BeanUtils.copyProperties(sr, s);
		States savent = sRepo.save(s);
		StatesResponseDto dto = new StatesResponseDto();
		BeanUtils.copyProperties(s, dto);
		return dto;
	}

	@Override
	public List<StatesResponseDto> viewAllStates() {

		List<States> statesList = sRepo.findAll();

		List<StatesResponseDto> responseList = new ArrayList<>();

		for (States state : statesList) {

			StatesResponseDto dto = new StatesResponseDto();
			BeanUtils.copyProperties(state, dto);
			responseList.add(dto);
		}

		return responseList;
	}

	@Override
	public StatesResponseDto updateState(Long stateId,StatesRequestDto dto)
	{
		Optional<States> optionalState = sRepo.findById(stateId);

		if (optionalState.isEmpty()) {
			return null; // no exception
		}
		
		States state = optionalState.get();
		
//update only required fields
		
		BeanUtils.copyProperties(dto, state);

		States updated = sRepo.save(state);

		StatesResponseDto response = new StatesResponseDto();
		
		BeanUtils.copyProperties(updated, response);
		
		return response;
	}

	@Override
//	soft delete by is flag
	public StatesDeleteResponseDto deleteState(Long stateId) {

		Optional<States> byId = sRepo.findById(stateId);
		 
		StatesDeleteResponseDto sdelRes = new StatesDeleteResponseDto();
 
		if (byId.isPresent()) {
			States s = byId.get();
//			soft delete by flag
			s.setFlag(false);
			sRepo.save(s);
			sdelRes.setDeleted(true);
			sdelRes.setMessage("Place Deleted Successfully");
 
		}
		else {
			sdelRes.setDeleted(false);
			sdelRes.setMessage("Place Not  Deleted Successfully");
		}
		return sdelRes;
	}

	

	@Override
	public StatesResponseDto viewStateById(Long stateId) {
		// TODO Auto-generated method stub

		Optional<States> optionalState = sRepo.findById(stateId);

		if (optionalState.isEmpty()) {
			return null; // simple approach, no exception
		}

		States state = optionalState.get();

		StatesResponseDto response = new StatesResponseDto();
		
		BeanUtils.copyProperties(state, response);

		return response;
	}
}
