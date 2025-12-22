package com.aja.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PackagesRequestDto {
	 @NotBlank(message = "Package name is mandatory")
	    @Size(min = 3, max = 100)
	    private String packageName;

	    @NotNull(message = "Duration is required")
	    @Min(value = 1, message = "Duration must be at least 1 day")
	    private Integer durationDays;

	    @NotNull
	    @Positive(message = "Adult price must be positive")
	    private Double adultPrice;

	    @PositiveOrZero
	    private Double childPrice;

	    @PositiveOrZero
	    private Double foodPrice;

	    @PositiveOrZero
	    private Double pickupPrice;

	    @Positive
	    private Double gstPercentage;

	    @NotNull(message = "State id is required")
	    private Long stateId;
}
