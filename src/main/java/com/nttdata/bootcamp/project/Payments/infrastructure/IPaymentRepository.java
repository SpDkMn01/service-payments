package com.nttdata.bootcamp.project.Payments.infrastructure;

import com.nttdata.bootcamp.project.Payments.entity.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends ReactiveMongoRepository<Payment, String> {
}
