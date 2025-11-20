package com.example.proxibanque.domain.model;

import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Client {
    private UUID id;
    private String lastName;
    private String firstName;
    private String address;
    private String zipCode;
    private String city;
    private String phone;

    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    @Builder.Default
    private List<BankCard> bankCards = new ArrayList<>();

    public void deactivateAllCards() {
        if (bankCards != null) {
            bankCards.forEach(card -> card.setActive(false));
        }
    }
}
