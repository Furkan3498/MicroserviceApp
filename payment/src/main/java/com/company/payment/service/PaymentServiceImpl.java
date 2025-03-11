package com.company.payment.service;

import com.company.payment.entity.PaymentEntity;
import com.company.payment.mapper.PaymentMapper;
import com.company.payment.repository.PaymentRepository;
import com.company.payment.requestDto.CreatePaymentRequest;
import com.company.payment.service.abstraction.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void pay(CreatePaymentRequest createPaymentRequest) {
        PaymentEntity paymentEntity = PaymentMapper.PAYMENT_MAPPER.mapToEntity(createPaymentRequest);
        paymentRepository.save(paymentEntity);
    }
}
