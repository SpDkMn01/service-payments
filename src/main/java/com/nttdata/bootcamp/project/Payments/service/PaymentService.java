package com.nttdata.bootcamp.project.Payments.service;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.infrastructure.IPaymentRepository;
import com.nttdata.bootcamp.project.Payments.utils.IPaymentMapper;
import com.nttdata.bootcamp.project.Payments.utils.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * <h1>Payment Service</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService<PaymentDtoRequest, PaymentDtoResponse>
{
    @Autowired
    private final IPaymentRepository repository;
    @Autowired
    private final IPaymentMapper mapper;
    @Override
    public Flux<PaymentDtoResponse> getAll() {
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> getById(String id)
    {
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> save(Mono<PaymentDtoRequest> object)
    {
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> update(Mono<PaymentDtoRequest> object, String id)
    {
        return repository.findById(id)
                .flatMap(
                        p -> object.map(mapper::toEntity)
                                .doOnNext(e -> e.setId(id))
                )
                .flatMap(repository::save)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<Void> delete(String id)
    {
        return repository.deleteById(id);
    }
}