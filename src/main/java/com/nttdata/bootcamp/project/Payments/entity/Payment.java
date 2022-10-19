package com.nttdata.bootcamp.project.Payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * <h1>Payment Entity</h1>
 * @Author Grupo06
 * @version 1.0
 * @since 2022-10-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payments")
public class Payment
{
    @Id
    private String id;
    private String customerProductActiveId;
    private double amount;
}
