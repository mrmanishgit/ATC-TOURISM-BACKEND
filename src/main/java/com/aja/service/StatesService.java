package com.aja.service;

import java.util.List;

import com.aja.entity.States;

public interface StatesService {
	public States addState(States s);
	public List<States> viewAllStates();
	public States updateState(Long stateId,States s);
	
}
