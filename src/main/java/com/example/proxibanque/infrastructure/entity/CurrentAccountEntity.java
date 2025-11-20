package com.example.proxibanque.infrastructure.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("CURRENT")
@Data
@EqualsAndHashCode(callSuper = true)
public class CurrentAccountEntity extends AccountEntity {
    private double overdraftLimit;
}
