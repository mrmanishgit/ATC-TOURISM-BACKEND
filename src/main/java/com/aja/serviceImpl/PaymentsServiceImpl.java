package com.aja.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
import com.aja.entity.Payments;
import com.aja.repository.PaymentsRepo;
import com.aja.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsRepo paymentsRepo;

	@Override
	public PaymentsResponseDto createPayment(PaymentsRequestDto dto) {

		Payments payment = new Payments();
		BeanUtils.copyProperties(dto, payment);

		Payments saved = paymentsRepo.save(payment);

		PaymentsResponseDto res = new PaymentsResponseDto();
		BeanUtils.copyProperties(saved, res);

		return res;
	}

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

	@Override
	public List<PaymentsResponseDto> getByTransactionId(String transactionId) {

		List<Payments> payments =
				paymentsRepo.findByTransactionId(transactionId);

		List<PaymentsResponseDto> resList = new ArrayList<>();

		for (Payments p : payments) {
			PaymentsResponseDto dto = new PaymentsResponseDto();
			BeanUtils.copyProperties(p, dto);
			resList.add(dto);
		}

		return resList;
	}

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
