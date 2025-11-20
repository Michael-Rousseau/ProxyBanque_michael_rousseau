package com.example.proxibanque.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankCard {
    private String cardNumber;
    private CardType type;
    private boolean active;

    public enum CardType {
        ELECTRON, PREMIER
    }
}
