package com.kodlamaio.paymentservice.business.abstracts;

import com.kodlamaio.common.utilities.results.DataResult;
import com.kodlamaio.common.utilities.results.Result;
import com.kodlamaio.paymentservice.business.requests.CreatePaymentRequest;
import com.kodlamaio.paymentservice.business.responses.CreatePaymentResponse;

public interface PaymentService {
	DataResult<CreatePaymentResponse> add(CreatePaymentRequest createPaymentRequest);
	void paymentReceived(String cardNumber,String cardName,String cvv,double totalPrice); 
	public Result delete(String id);
}
