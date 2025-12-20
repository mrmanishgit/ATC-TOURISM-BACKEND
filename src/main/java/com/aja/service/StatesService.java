package com.aja.service;

import java.util.List;

import com.aja.Dto.StatesRequestDto;
import com.aja.Dto.StatesResponseDto;
import com.aja.entity.States;

public interface StatesService {
	public StatesResponseDto addState(StatesRequestDto sr);
	public List<States> viewAllStates();
	public States updateState(Long stateId,States s);
	
}
