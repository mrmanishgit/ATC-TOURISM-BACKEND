package com.aja.Dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentsResponseDto {

	private String transactionId;

	private String paymentMethod;

	private String paymentStatus;

	private Double paidAmount;

	private LocalDateTime paidAt;
}
