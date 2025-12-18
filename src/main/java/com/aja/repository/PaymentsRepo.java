package com.aja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Payments;

public interface PaymentsRepo extends JpaRepository<Payments, Long> {
	
	List<Payments> findByTransactionId(String transactionId);

}
