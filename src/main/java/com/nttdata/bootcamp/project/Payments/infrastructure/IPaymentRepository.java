package com.nttdata.bootcamp.project.Payments.infrastructure;

import com.nttdata.bootcamp.project.Payments.entity.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * <h1>IPayment Repository</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Repository
public interface IPaymentRepository extends ReactiveMongoRepository<Payment, String> {
}
