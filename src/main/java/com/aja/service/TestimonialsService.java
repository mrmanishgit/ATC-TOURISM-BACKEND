package com.aja.service;

import java.util.List;

import com.aja.Dto.TestimonialsDeleteResponseDto;
import com.aja.Dto.TestimonialsRequestDto;
import com.aja.Dto.TestimonialsResponseDto;

public interface TestimonialsService {

	public TestimonialsResponseDto addTestmonial(TestimonialsRequestDto tm);

	public List<TestimonialsResponseDto> viewAll();
	
	public TestimonialsResponseDto viewById(Long id);

	public TestimonialsResponseDto updateTestimonial(Long id, TestimonialsRequestDto t);

	public TestimonialsDeleteResponseDto deleteTestnomial(Long id);
}
