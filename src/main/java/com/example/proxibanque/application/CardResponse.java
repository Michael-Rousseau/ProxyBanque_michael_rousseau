package com.example.proxibanque.application;

import com.example.proxibanque.domain.model.BankCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private String cardNumber;
    private BankCard.CardType type;
    private boolean active;
}
