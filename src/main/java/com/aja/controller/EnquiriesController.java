package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.EnquiriesRequestDto;
import com.aja.Dto.EnquiriesResponseDto;
import com.aja.entity.Enquiries;
import com.aja.service.EnquiriesService;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin("*")
public class EnquiriesController {

	@Autowired
	private EnquiriesService enquiriesService;

	@PostMapping("/register")
	public ResponseEntity<EnquiriesResponseDto> createEnquiry(@RequestBody EnquiriesRequestDto dto) {
		return ResponseEntity.ok(enquiriesService.saveEnquiry(dto));
	}
	
	@GetMapping("/all")
	public List<Enquiries> getAllEnquiries() {
		return enquiriesService.getAllEnquiries();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Enquiries> getEnquiryById(@PathVariable("id") Long enquiryId) {
		Enquiries enquiry = enquiriesService.getEnquiryById(enquiryId);
		return ResponseEntity.ok(enquiry);
	}

}
