package com.aja.service;

import java.util.List;

import com.aja.entity.Payments;

public interface PaymentsService {

	public Payments createPayment(Payments payment);

	public Payments getPaymentById(Long paymentId);

	public Payments getByTransactionId(String transactionId);

	public List<Payments> getAllPayments();

	public Payments updatePayment(Long paymentId, Payments payment);

}
