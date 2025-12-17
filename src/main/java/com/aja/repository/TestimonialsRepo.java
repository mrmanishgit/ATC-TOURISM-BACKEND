package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.Testimonials;
@Repository
public interface TestimonialsRepo extends JpaRepository<Testimonials, Long>{

}