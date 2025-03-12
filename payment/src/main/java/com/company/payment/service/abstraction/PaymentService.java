package com.company.payment.service.abstraction;

import com.company.payment.ResponseDTO.PaymentResponse;
import com.company.payment.requestDto.CreatePaymentRequest;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    ResponseEntity<PaymentResponse> pay(CreatePaymentRequest createPaymentRequest);
}
