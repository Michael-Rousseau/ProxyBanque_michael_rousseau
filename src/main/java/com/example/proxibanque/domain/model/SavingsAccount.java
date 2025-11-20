package com.example.proxibanque.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class SavingsAccount extends Account {
    @lombok.Builder.Default
    private double interestRate = 0.03;
}
