package com.nttdata.bootcamp.project.Payments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <h1>PaymentDtoRequest</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDtoRequest {
    private String customerProductActiveId;
    private double amount;
}
