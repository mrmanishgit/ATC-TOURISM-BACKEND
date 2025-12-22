package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PaymentDeleteResponseDto;
import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
import com.aja.entity.Bookings;
import com.aja.entity.Payments;
import com.aja.entity.Users;
import com.aja.repository.BookingsRepo;
import com.aja.repository.PaymentsRepo;
import com.aja.repository.UsersRepo;
import com.aja.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsRepo paymentsRepo;

	/* Add payment details */
	@Override
	public PaymentsResponseDto createPayment(PaymentsRequestDto dto) {

		Payments payment = new Payments();
		BeanUtils.copyProperties(dto, payment);

		Payments saved = paymentsRepo.save(payment);

		PaymentsResponseDto res = new PaymentsResponseDto();
		BeanUtils.copyProperties(saved, res);

		return res;
	}

	/* payment details visible by id */
	@Override
	public PaymentsResponseDto getPaymentById(Long paymentId) {

		Optional<Payments> byId = paymentsRepo.findById(paymentId);

		if (byId.isEmpty()) {
			return null;
		}

		PaymentsResponseDto res = new PaymentsResponseDto();
		BeanUtils.copyProperties(byId.get(), res);

		return res;
	}

	/* All payment details */
	@Override
	public List<PaymentsResponseDto> getByTransactionId(String transactionId) {

		List<Payments> payments =paymentsRepo.findByTransactionId(transactionId);

		List<PaymentsResponseDto> resList = new ArrayList<>();

		for (Payments p : payments) {
			PaymentsResponseDto dto = new PaymentsResponseDto();
			BeanUtils.copyProperties(p, dto);
			resList.add(dto);
		}

		return resList;
	}
	
	

	/* updated by id */
	@Override
	public List<PaymentsResponseDto> getAllPayments() {

		List<Payments> payments = paymentsRepo.findAll();
		List<PaymentsResponseDto> resList = new ArrayList<>();

		for (Payments p : payments) {
			PaymentsResponseDto dto = new PaymentsResponseDto();
			BeanUtils.copyProperties(p, dto);
			resList.add(dto);
		}

		return resList;
	}

	/* Delete payment details */
	@Override
	public PaymentsResponseDto updatePayment(
			Long paymentId,
			PaymentsRequestDto dto) {

		Optional<Payments> byId = paymentsRepo.findById(paymentId);

		if (byId.isEmpty()) {
			return null;
		}

		Payments payment = byId.get();
		BeanUtils.copyProperties(dto, payment, "paymentId");

		Payments updated = paymentsRepo.save(payment);

		PaymentsResponseDto res = new PaymentsResponseDto();
		BeanUtils.copyProperties(updated, res);

		return res;
	}

}
