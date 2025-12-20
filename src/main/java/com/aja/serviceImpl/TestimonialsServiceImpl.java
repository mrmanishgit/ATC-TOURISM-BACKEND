package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.TestimonialsRequestDto;
import com.aja.Dto.TestimonialsResponseDto;
import com.aja.entity.Testimonials;
import com.aja.repository.TestimonialsRepo;
import com.aja.service.TestimonialsService;

@Service
public class TestimonialsServiceImpl implements TestimonialsService {

	@Autowired
	private TestimonialsRepo tRepo;

	@Override

	public TestimonialsResponseDto addTestmonial(TestimonialsRequestDto  tm) {
		// TODO Auto-generated method stub
		Testimonials t=new Testimonials();
		BeanUtils.copyProperties(tm, t);
		
		Testimonials saveEnt=tRepo.save(t);
		TestimonialsResponseDto tdto =new TestimonialsResponseDto();

		
		BeanUtils.copyProperties(saveEnt,tdto);
		return tdto;
	}

	@Override
	public List<Testimonials> viewAll() {
		// TODO Auto-generated method stub
		return tRepo.findAll();
	}

	@Override
	public Testimonials updateTestimonial(Long id, Testimonials t) {

		Testimonials existing = tRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Testimonial not found with id: " + id));

		if (t.getName() != null) {
			existing.setName(t.getName());
		}

		if (t.getRating() != null) {
			existing.setRating(t.getRating());
		}

		if (t.getReview() != null) {
			existing.setReview(t.getReview());
		}

		if (t.getImage() != null) {
			existing.setImage(t.getImage());
		}

		return tRepo.save(existing);
		// TODO Auto-generated method stub

		}
		
	}
