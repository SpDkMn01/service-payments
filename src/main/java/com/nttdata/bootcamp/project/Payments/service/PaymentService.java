package com.nttdata.bootcamp.project.Payments.service;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.infrastructure.IPaymentRepository;
import com.nttdata.bootcamp.project.Payments.utils.IPaymentMapper;
import com.nttdata.bootcamp.project.Payments.utils.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService<PaymentDtoRequest, PaymentDtoResponse>
{
    @Autowired
    private final IPaymentRepository paymentRepository;
    @Override
    public Flux<PaymentDtoResponse> getAll() {
        IPaymentMapper mapper = new PaymentMapper();
        return paymentRepository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> getById(String id)
    {
        IPaymentMapper mapper = new PaymentMapper();
        return paymentRepository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> save(Mono<PaymentDtoRequest> object)
    {
        IPaymentMapper mapper = new PaymentMapper();
        return object.map(mapper::toEntity)
                .flatMap(paymentRepository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> update(Mono<PaymentDtoRequest> object, String id)
    {
        IPaymentMapper mapper = new PaymentMapper();
        return paymentRepository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(paymentRepository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return paymentRepository.deleteById(id);
    }
}