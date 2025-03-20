package com.company.payment.service;

import com.company.payment.ResponseDTO.PaymentResponse;
import com.company.payment.entity.PaymentEntity;
import com.company.payment.exception.NotFoundException;
import com.company.payment.mapper.PaymentMapper;
import com.company.payment.repository.PaymentRepository;
import com.company.payment.requestDto.CreatePaymentRequest;
import com.company.payment.service.abstraction.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.company.payment.mapper.PaymentMapper.PAYMENT_MAPPER;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public ResponseEntity<PaymentResponse> pay(CreatePaymentRequest createPaymentRequest) {
        PaymentEntity paymentEntity = PAYMENT_MAPPER.mapToEntity(createPaymentRequest);
     paymentRepository.save(paymentEntity);

     return   ResponseEntity.ok(new PaymentResponse(paymentEntity.getId()));
    }

    @Override
    public PaymentResponse getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId)
                .map(PAYMENT_MAPPER::buildPaymentResponse)
                .orElseThrow(()-> new NotFoundException(
                        "Payment not found with order id" + orderId
                ));
    }
}
