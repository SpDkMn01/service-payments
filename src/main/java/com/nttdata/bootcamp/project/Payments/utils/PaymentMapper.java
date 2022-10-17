package com.nttdata.bootcamp.project.Payments.utils;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.entity.Payment;
import org.springframework.beans.BeanUtils;

public class PaymentMapper implements IPaymentMapper
{
    @Override
    public PaymentDtoRequest toDtoRequest(Payment payment)
    {
        PaymentDtoRequest paymentDtoRequest = new PaymentDtoRequest();
        BeanUtils.copyProperties(payment, paymentDtoRequest);
        return paymentDtoRequest;
    }
    @Override
    public Payment toEntity(PaymentDtoRequest paymentDtoRequest) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(paymentDtoRequest, payment);
        return payment;
    }
    @Override
    public PaymentDtoResponse toDtoResponse(Payment payment)
    {
        PaymentDtoResponse paymentDtoResponse = new PaymentDtoResponse();
        BeanUtils.copyProperties(payment, paymentDtoResponse);
        paymentDtoResponse.setCustomerProductActiveUrl("/api/v1/customerProductsActive/" + payment.getCustomerProductActiveId());
        return paymentDtoResponse;
    }
}
