package com.company.payment.service.abstraction;

import com.company.payment.requestDto.CreatePaymentRequest;

public interface PaymentService {
    void pay(CreatePaymentRequest createPaymentRequest);
}
