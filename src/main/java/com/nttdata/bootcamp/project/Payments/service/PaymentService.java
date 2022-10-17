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

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService<PaymentDtoRequest, PaymentDtoResponse>
{
    @Value("${message.uri}")
    String uri;
    @Autowired
    private final IPaymentRepository repository;
    @Override
    public Flux<PaymentDtoResponse> getAll() {
        IPaymentMapper mapper = new PaymentMapper(uri);
        return repository.findAll()
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> getById(String id)
    {
        IPaymentMapper mapper = new PaymentMapper(uri);
        return repository.findById(id)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> save(Mono<PaymentDtoRequest> object)
    {
        IPaymentMapper mapper = new PaymentMapper(uri);
        return object.map(mapper::toEntity)
                .flatMap(repository::insert)
                .map(mapper::toDtoResponse);
    }
    @Override
    public Mono<PaymentDtoResponse> update(Mono<PaymentDtoRequest> object, String id)
    {
        IPaymentMapper mapper = new PaymentMapper(uri);
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