package com.nttdata.bootcamp.project.Payments.utils;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.entity.Payment;
/**
 * <h1>IPayment Mapper</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
public interface IPaymentMapper
{
    PaymentDtoRequest toDtoRequest(Payment payment);
    Payment toEntity(PaymentDtoRequest paymentDtoRequest);
    PaymentDtoResponse toDtoResponse(Payment payment);
}
