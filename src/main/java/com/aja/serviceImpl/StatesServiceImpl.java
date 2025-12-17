package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.States;
import com.aja.repository.StatesRepo;
import com.aja.service.StatesService;
@Service
public class StatesServiceImpl implements StatesService {
	@Autowired
	private StatesRepo sRepo;
	@Override
	public States addState(States s) {
		// TODO Auto-generated method stub
		States st=sRepo.save(s);
		return st;
	}

	@Override
	public List<States> viewAllStates() {
		// TODO Auto-generated method stub
		return sRepo.findAll();
	}

	@Override
	public States updateState(Long stateId, States s) {
		// TODO Auto-generated method stub
		States st=sRepo.findById(stateId).orElse(null);
		
		
		st.setStateName(s.getStateName());
		return st;
	}

}
