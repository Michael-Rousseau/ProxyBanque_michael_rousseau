package com.example.proxibanque.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
public abstract class Account {
    private String accountNumber;
    private double balance;
    private LocalDate openingDate;
}
