package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.TestimonialsRequestDto;
import com.aja.Dto.TestimonialsResponseDto;
import com.aja.entity.Testimonials;
import com.aja.serviceImpl.TestimonialsServiceImpl;

@RestController
@RequestMapping("/api/testmonial")
public class TestimonialsController {
	
	@Autowired
	private TestimonialsServiceImpl tServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<TestimonialsResponseDto> addTestimonials(@RequestBody TestimonialsRequestDto t)
	{
		TestimonialsResponseDto tdto=tServiceImpl.addTestmonial(t);
		return ResponseEntity.ok(tdto);
	}
	@GetMapping("/all")
	public List<Testimonials> viewAll()
	{
		return tServiceImpl.viewAll();
	}
	@PutMapping("/update")
	public Testimonials updateTestimonial(Long id,Testimonials t)
	{
		return tServiceImpl.updateTestimonial(id, t);
	}
}
