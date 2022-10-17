package com.nttdata.bootcamp.project.Payments.controller;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${message.path-payment}")
@RefreshScope
public class PaymentController {
    @Autowired
    private IPaymentService service;
    @GetMapping
    public Flux<PaymentDtoResponse> getAll()
    {
        return service.getAll();
    }
    @GetMapping(path="/{id}")
    public Mono<PaymentDtoResponse> getById(@PathVariable String id)
    {
        return service.getById(id);
    }
    @PostMapping
    public Mono<PaymentDtoResponse> save(@RequestBody Mono<PaymentDtoRequest> requestMono)
    {
        return service.save(requestMono);
    }
    @PutMapping("/update/{id}")
    public Mono<PaymentDtoResponse> update(@RequestBody Mono<PaymentDtoRequest> requestMono, @PathVariable String id)
    {
        return service.update(requestMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id)
    {
        return service.delete(id);
    }
}
