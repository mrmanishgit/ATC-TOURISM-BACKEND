package com.aja.serviceImpl;

<<<<<<< Updated upstream
=======
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
import com.aja.entity.Payments;
import com.aja.repository.PaymentsRepo;
>>>>>>> Stashed changes
import com.aja.service.PaymentsService;

public class PaymentsServiceImpl implements PaymentsService {

<<<<<<< Updated upstream
=======
	@Autowired
	private PaymentsRepo paymentsRepository;

	@Override
	public PaymentsResponseDto createPayment(PaymentsRequestDto pdto) {

		Payments py = new Payments();
		BeanUtils.copyProperties(pdto, py);
		Payments saveEnt = paymentsRepository.save(py);
		PaymentsResponseDto pyrd = new PaymentsResponseDto();
		BeanUtils.copyProperties(saveEnt, pyrd);
		return pyrd;

	}

	@Override
	public Payments getPaymentById(Long paymentId) {
		return paymentsRepository.findById(paymentId).orElse(null);
	}

	@Override
// Transition details
	public List<Payments> getByTransactionId(String transactionId) {
		return paymentsRepository.findByTransactionId(transactionId);
	}

	@Override
	public List<Payments> getAllPayments() {
		return paymentsRepository.findAll();
	}

	@Override
	public Payments updatePayment(Long paymentId, Payments payment) {
		Payments existing = getPaymentById(paymentId);

		existing.setPaymentStatus(payment.getPaymentStatus());
		existing.setPaymentMethod(payment.getPaymentMethod());
		existing.setPaidAmount(payment.getPaidAmount());

		return paymentsRepository.save(existing);
	}

>>>>>>> Stashed changes
}
