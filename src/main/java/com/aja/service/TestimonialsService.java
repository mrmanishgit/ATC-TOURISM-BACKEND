package com.aja.service;

import java.util.List;

import com.aja.Dto.TestimonialsRequestDto;
import com.aja.Dto.TestimonialsResponseDto;
import com.aja.entity.Testimonials;

public interface TestimonialsService {

	public TestimonialsResponseDto addTestmonial(TestimonialsRequestDto tm);

	public List<TestimonialsResponseDto> viewAll();
	
	public TestimonialsResponseDto viewById(Long id);

	public Testimonials updateTestimonial(Long id, Testimonials t);

	public String deleteTestnomial(Long id);
}
