package com.niteshjha.info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Date transactionDate;
    private String product;
    private BigDecimal price;
    private PaymentType paymentType;
    private String name;
    private String city;
    private String state;
    private String country;
    private Date accountCreated;
    private Date lastLogin;
    private String latitude;
    private String longitude;
    private String accountAge;
}
