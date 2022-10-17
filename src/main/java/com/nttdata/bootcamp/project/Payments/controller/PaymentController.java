package com.nttdata.bootcamp.project.Payments.controller;

import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoRequest;
import com.nttdata.bootcamp.project.Payments.dto.PaymentDtoResponse;
import com.nttdata.bootcamp.project.Payments.service.PaymentService;
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
    private PaymentService paymentService;
    @GetMapping
    public Flux<PaymentDtoResponse> getCustomerProductActives()
    {
        return paymentService.getAll();
    }
    @GetMapping(path="/{id}")
    public Mono<PaymentDtoResponse> getCustomerProductActive(@PathVariable String id)
    {
        return paymentService.getById(id);
    }
    @PostMapping
    public Mono<PaymentDtoResponse> saveCustomerProductActive(@RequestBody Mono<PaymentDtoRequest> paymentDtoRequestMono)
    {
        return paymentService.save(paymentDtoRequestMono);
    }
    @PutMapping("/update/{id}")
    public Mono<PaymentDtoResponse> updateCustomerProductActive(@RequestBody Mono<PaymentDtoRequest> paymentDtoRequestMono, @PathVariable String id)
    {
        return paymentService.update(paymentDtoRequestMono,id);
    }
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteCustomerProductActive(@PathVariable String id)
    {
        return paymentService.delete(id);
    }
}
