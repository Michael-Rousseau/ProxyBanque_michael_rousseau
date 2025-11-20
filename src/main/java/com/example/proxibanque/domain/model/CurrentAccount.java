package com.example.proxibanque.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class CurrentAccount extends Account {
    @lombok.Builder.Default
    private double overdraftLimit = 1000.0;
}
