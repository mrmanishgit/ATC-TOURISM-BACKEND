package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Testimonials;

public interface TestimonialsRepo extends JpaRepository<Testimonials, Long>{

}