package com.nttdata.bootcamp.project.Payments.utils;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.entity.Payment;

public interface IPaymentMapper
{
    PaymentDtoRequest toDtoRequest(Payment payment);
    Payment toEntity(PaymentDtoRequest paymentDtoRequest);
    PaymentDtoResponse toDtoResponse(Payment payment);
}
