package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.StatesRequestDto;
import com.aja.Dto.StatesResponseDto;
import com.aja.entity.States;
import com.aja.serviceImpl.StatesServiceImpl;

@RestController
@RequestMapping("/api/state")
public class StatesController {
	@Autowired
	private StatesServiceImpl sImpl;
	@PostMapping("/create")
	public StatesResponseDto addState(@RequestBody StatesRequestDto s)
	{
		return sImpl.addState(s);
	}
	@GetMapping("/all")
	public List<States> viewAllStates()
	{
		return sImpl.viewAllStates();
	}
	@PutMapping("/update/{stateId}")
	public States upadteStates(@PathVariable Long stateId,@RequestBody States s)
	{
		return sImpl.updateState(stateId, s);
	}
}
