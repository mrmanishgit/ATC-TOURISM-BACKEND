package com.aja.service;

import java.util.List;

import com.aja.Dto.TestimonialsRequestDto;
import com.aja.Dto.TestimonialsResponseDto;
import com.aja.entity.Testimonials;

public interface TestimonialsService {
	public TestimonialsResponseDto addTestmonial(TestimonialsRequestDto tm);

	public List<Testimonials> viewAll();

	public Testimonials updateTestimonial(Long id, Testimonials t);

}
