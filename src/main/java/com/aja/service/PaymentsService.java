package com.aja.service;

<<<<<<< Updated upstream
public interface PaymentsService {

=======
import java.util.List;

import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
import com.aja.entity.Payments;

public interface PaymentsService {

	PaymentsResponseDto createPayment(PaymentsRequestDto dto);

	public Payments getPaymentById(Long paymentId);

	//public Payments getByTransactionId(String transactionId);
	public List<Payments> getByTransactionId(String transactionId);

	public List<Payments> getAllPayments();

	public Payments updatePayment(Long paymentId, Payments payment);

>>>>>>> Stashed changes
}
