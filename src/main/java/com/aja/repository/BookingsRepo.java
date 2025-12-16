package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Bookings;

public interface BookingsRepo extends JpaRepository<Bookings, Long> {

}
