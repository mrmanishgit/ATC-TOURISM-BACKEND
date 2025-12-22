package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.TestimonialsDeleteResponseDto;
import com.aja.Dto.TestimonialsRequestDto;
import com.aja.Dto.TestimonialsResponseDto;
import com.aja.entity.Testimonials;
import com.aja.exceptions.InvalidInputException;
import com.aja.exceptions.NoDataFoundException;
import com.aja.exceptions.ResourceNotFoundException;
import com.aja.repository.TestimonialsRepo;
import com.aja.service.TestimonialsService;

@Service
public class TestimonialsServiceImpl implements TestimonialsService {

    @Autowired
    private TestimonialsRepo tRepo;

    // ---------------- ADD ----------------
    @Override
    public TestimonialsResponseDto addTestmonial(TestimonialsRequestDto tm) {

        if (tm == null) {
            throw new InvalidInputException("Testimonial data cannot be null");
        }

        Testimonials t = new Testimonials();
        BeanUtils.copyProperties(tm, t);

        Testimonials saved = tRepo.save(t);

        TestimonialsResponseDto response = new TestimonialsResponseDto();
        BeanUtils.copyProperties(saved, response);

        return response;
    }

    // ---------------- VIEW ALL ----------------
    @Override
    public List<TestimonialsResponseDto> viewAll() {

        List<Testimonials> list = tRepo.findAll();

        if (list.isEmpty()) {
            throw new NoDataFoundException("No testimonials found");
        }

        List<TestimonialsResponseDto> responseList = new ArrayList<>();

        for (Testimonials t : list) {
            TestimonialsResponseDto dto = new TestimonialsResponseDto();
            BeanUtils.copyProperties(t, dto);
            responseList.add(dto);
        }

        return responseList;
    }

    // ---------------- VIEW BY ID ----------------
    @Override
    public TestimonialsResponseDto viewById(Long id) {

        Testimonials testimonial = tRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Testimonial not found with id: " + id));

        TestimonialsResponseDto response = new TestimonialsResponseDto();
        BeanUtils.copyProperties(testimonial, response);

        return response;
    }

    // ---------------- UPDATE ----------------
    @Override
    public TestimonialsResponseDto updateTestimonial(Long id, TestimonialsRequestDto t) {

        if (t == null) {
            throw new InvalidInputException("Update data cannot be null");
        }

        Testimonials testimonial = tRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Testimonial not found with id: " + id));

        BeanUtils.copyProperties(t, testimonial, "testmonialId");

        Testimonials updated = tRepo.save(testimonial);

        TestimonialsResponseDto response = new TestimonialsResponseDto();
        BeanUtils.copyProperties(updated, response);

        return response;
    }

    // ---------------- DELETE (SOFT DELETE) ----------------
    @Override
    public TestimonialsDeleteResponseDto deleteTestnomial(Long id) {

        Testimonials testimonial = tRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Testimonial not found with id: " + id));

        testimonial.setFlag(false); // soft delete
        tRepo.save(testimonial);

        TestimonialsDeleteResponseDto response = new TestimonialsDeleteResponseDto();
        response.setDeleted(true);
        response.setMessage("Testimonial deleted successfully");

        return response;
    }
}
