package com.kodlamaio.inventoryService.business.requests.create;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
//	@NotNull
//	private String id;
	@Min(0)
	private double dailyPrice;
	@Min(2015)
	private int modelYear;
	@NotNull
	@NotBlank
	private String modelId;
	@Min(1)
	@Max(3)
	private int state;
	@NotNull
	@NotBlank
	private String plate;

}
