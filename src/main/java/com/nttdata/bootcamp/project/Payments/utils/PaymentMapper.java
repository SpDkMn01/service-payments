package com.nttdata.bootcamp.project.Payments.utils;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.entity.Payment;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
@AllArgsConstructor
public class PaymentMapper implements IPaymentMapper
{
    private String uri;
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
        paymentDtoResponse.setCustomerProductActiveUrl(uri + payment.getCustomerProductActiveId());
        return paymentDtoResponse;
    }
}
