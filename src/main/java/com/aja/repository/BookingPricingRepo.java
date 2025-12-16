package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.BookingPricing;

public interface BookingPricingRepo extends JpaRepository<BookingPricing, Long> {

}
