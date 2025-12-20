package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin("*")
@RequestMapping("/api/testmonial")

public class TestimonialsController {
	
	@Autowired
	private TestimonialsServiceImpl tServiceImpl;

	@PostMapping("/create")
	public ResponseEntity<TestimonialsResponseDto> getTestimonials(@RequestBody TestimonialsRequestDto t)

	{
		TestimonialsResponseDto tdto=tServiceImpl.addTestmonial(t);
		return ResponseEntity.ok(tdto);
	}
	@GetMapping("/all")
	public List<Testimonials> viewAll()
	{
		return tServiceImpl.viewAll();
	}

	@PutMapping("/update/{id}")
	public Testimonials updateTestimonial(@PathVariable Long id,@RequestBody Testimonials t)

	{
		return tServiceImpl.updateTestimonial(id, t);
	}
}
