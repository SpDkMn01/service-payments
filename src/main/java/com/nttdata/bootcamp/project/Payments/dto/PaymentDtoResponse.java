package com.nttdata.bootcamp.project.Payments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDtoResponse {
    private String id;
    private String customerProductActiveUrl;
    private double mount;
}
