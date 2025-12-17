package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aja.entity.Enquiries;

@Repository
public interface EnquiriesRepo extends JpaRepository<Enquiries, Long> {

}
