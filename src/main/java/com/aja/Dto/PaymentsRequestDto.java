package com.aja.Dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentsRequestDto {

	@NotBlank(message = "Transaction id is mandatory")
	private String transactionId;

	@NotBlank(message = "Payment method is required")
	private String paymentMethod;
	// ex: CARD, UPI, NET_BANKING

	@NotBlank(message = "Payment status is required")
	private String paymentStatus;
	// ex: SUCCESS, FAILED, PENDING

	@NotNull(message = "Paid amount is required")
	@Positive(message = "Paid amount must be greater than zero")
	private Double paidAmount;

	@NotNull(message = "Payment time is required")
	private LocalDateTime paidAt;

	@NotNull(message = "User id is required")
	private Long userId;

	@NotNull(message = "Booking id is required")
	private Long bookingId;

}
