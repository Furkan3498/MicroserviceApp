package com.company.payment.ResponseDTO;

public class PaymentResponse {

    private Long id;

    public PaymentResponse() {
    }

    public PaymentResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
