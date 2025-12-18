package com.aja.controller;

<<<<<<< Updated upstream
public class PaymentsController {
=======
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.Dto.PaymentsRequestDto;
import com.aja.Dto.PaymentsResponseDto;
import com.aja.entity.Payments;
import com.aja.service.PaymentsService;

@RestController

@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentsController {
	@Autowired
	private PaymentsService paymentsService;

	@PostMapping("/add")
	public ResponseEntity<PaymentsResponseDto> createPayment(@RequestBody PaymentsRequestDto dto) {
		return ResponseEntity.ok(paymentsService.createPayment(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Payments> getPaymentById(@PathVariable Long id) {
		return ResponseEntity.ok(paymentsService.getPaymentById(id));
	}

//	@GetMapping("/transaction/{transactionId}")
//	public ResponseEntity<Payments> getByTransactionId(@PathVariable String transactionId) {
//		return ResponseEntity.ok(paymentsService.getByTransactionId(transactionId));
//	}

	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<List<Payments>> getByTransactionId(@PathVariable String transactionId) {
		return ResponseEntity.ok(paymentsService.getByTransactionId(transactionId));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Payments>> getAllPayments() {
		return ResponseEntity.ok(paymentsService.getAllPayments());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Payments> updatePayment(@PathVariable Long id, @RequestBody Payments payment) {
		return ResponseEntity.ok(paymentsService.updatePayment(id, payment));
	}
>>>>>>> Stashed changes

}
