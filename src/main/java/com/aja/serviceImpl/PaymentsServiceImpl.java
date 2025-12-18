package com.aja.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.entity.Payments;
import com.aja.repository.PaymentsRepo;
import com.aja.service.PaymentsService;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsRepo paymentsRepository; 

    @Override
    public Payments createPayment(Payments payment) {
        return paymentsRepository.save(payment);
    }

    @Override
    public Payments getPaymentById(Long paymentId) {
        return paymentsRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public Payments getByTransactionId(String transactionId) {
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
}
