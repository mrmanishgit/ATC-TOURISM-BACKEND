package com.aja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aja.entity.Payments;

public interface PaymentsRepo extends JpaRepository<Payments, Long> {
	
	Payments findByTransactionId(String transactionId);

}
