package com.company.payment.controller;

import com.company.payment.requestDto.CreatePaymentRequest;
import com.company.payment.service.abstraction.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //responseEntity yap
    public void  pay(@RequestBody CreatePaymentRequest createPaymentRequest){
        paymentService.pay(createPaymentRequest);
    }
}
