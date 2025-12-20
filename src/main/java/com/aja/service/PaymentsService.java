package com.aja.service;

import java.util.List;

import com.aja.Dto.PaymentDeleteResponseDto;
import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;

public interface PaymentsService {

	public PaymentsResponseDto createPayment(PaymentsRequestDto dto);

	public PaymentsResponseDto getPaymentById(Long paymentId);

	public List<PaymentsResponseDto> getByTransactionId(String transactionId);

	public List<PaymentsResponseDto> getAllPayments();

	public PaymentsResponseDto updatePayment(Long paymentId, PaymentsRequestDto dto);
}
