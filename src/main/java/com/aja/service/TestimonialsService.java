package com.aja.service;

import java.util.List;

import com.aja.entity.Testimonials;

public interface TestimonialsService {
	public Testimonials addTestmonial(Testimonials t);
	public List<Testimonials> viewAll();
	public Testimonials updateTestimonial(Long id,Testimonials t);
	
}
