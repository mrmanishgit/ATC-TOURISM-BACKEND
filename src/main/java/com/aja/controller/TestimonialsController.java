package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.entity.Testimonials;
import com.aja.serviceImpl.TestimonialsServiceImpl;

@RestController
@RequestMapping("/testmonial")
@CrossOrigin("*")
public class TestimonialsController {
	
	@Autowired
	private TestimonialsServiceImpl tServiceImpl;

	@PostMapping("/add")
	public Testimonials addTestimonials(@RequestBody Testimonials t)
	{
		return tServiceImpl.addTestmonial(t);
	}
	@GetMapping("/all")
	public List<Testimonials> viewAll()
	{
		return tServiceImpl.viewAll();
	}
	
	@PutMapping("/update/{id}")
	public Testimonials updateTestimonial(Long id,Testimonials t)
	{
		return tServiceImpl.updateTestimonial(id, t);
	}
}
