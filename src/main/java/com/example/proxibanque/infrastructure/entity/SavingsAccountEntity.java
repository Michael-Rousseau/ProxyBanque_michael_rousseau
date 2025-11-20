package com.example.proxibanque.infrastructure.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("SAVINGS")
@Data
@EqualsAndHashCode(callSuper = true)
public class SavingsAccountEntity extends AccountEntity {
    private double interestRate;
}
