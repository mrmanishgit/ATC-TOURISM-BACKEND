package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Enquiries;

public interface EnquiriesRepo extends JpaRepository<Enquiries, Long> {

}
