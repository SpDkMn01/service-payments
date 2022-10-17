package com.nttdata.bootcamp.project.Payments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDtoRequest {
    private String id;
    private String customerProductActiveId;
    private double mount;
}
