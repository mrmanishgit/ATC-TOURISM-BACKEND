package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		States savent=sRepo.save(s);
		StatesResponseDto dto=new StatesResponseDto();
		BeanUtils.copyProperties(savent, dto);	
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
	public States updateState(Long stateId, States s) {
		// TODO Auto-generated method stub
		States st = sRepo.findById(stateId).orElse(null);
		st.setStateName(s.getStateName());
		return st;
	}

	@Override
//	soft delete by is flag
	public String deleteState(Long stateId) {

		Optional<States> delbyId = sRepo.findById(stateId);
		
		States obj = null;
		
		if(delbyId.isPresent())
		{
			obj = delbyId.get();
			
			obj.setFlag(false);
			
			sRepo.save(obj);
		}
		
		if(obj!=null)
		{
			return " State Deleted successfully";
		}
		else {
			return " State not Deleted successfully";
		}
		
	}

	@Override
	public StatesResponseDto viewStateById(Long stateId) {
		// TODO Auto-generated method stub
		
		    Optional<States> optionalState = sRepo.findById(stateId);
		 
		    if (optionalState.isEmpty()) {
		        return null;   // simple approach, no exception
		    }
		 
		    States state = optionalState.get();
		 
		    StatesResponseDto response = new StatesResponseDto();
		    BeanUtils.copyProperties(state, response);
		 
		    return response;
		}
	}


