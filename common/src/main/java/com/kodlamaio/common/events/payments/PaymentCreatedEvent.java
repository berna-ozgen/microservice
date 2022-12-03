package com.kodlamaio.common.events.payments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreatedEvent {
	private String messages;
	private String rentalId;

}
