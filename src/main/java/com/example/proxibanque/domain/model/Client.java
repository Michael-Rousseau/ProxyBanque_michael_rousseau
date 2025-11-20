package com.example.proxibanque.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Client {
    private UUID id;
    private UUID advisorId;
    private String lastName;
    private String firstName;
    private String address;
    private String zipCode;
    private String city;
    private String phone;
    private String email;

    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;

    @Builder.Default
    private List<BankCard> bankCards = new ArrayList<>();

    public void deactivateAllCards() {
        if (bankCards != null) {
            bankCards.forEach(card -> card.setActive(false));
        }
    }

    public void checkAndUpdateCardStatus() {
        if (currentAccount != null && bankCards != null) {
            double balance = currentAccount.getBalance();
            if (balance < -1000) {
                bankCards.forEach(card -> card.setActive(false));
            }
        }
    }

    public BankCard assignCard(BankCard.CardType cardType) {
        BankCard card = BankCard.builder()
                .cardNumber(generateCardNumber())
                .type(cardType)
                .active(true)
                .build();

        if (bankCards == null) {
            bankCards = new ArrayList<>();
        }
        bankCards.add(card);
        return card;
    }

    public void openCurrentAccount(double initialBalance) {
        this.currentAccount = CurrentAccount.builder()
                .accountNumber(generateAccountNumber())
                .balance(initialBalance)
                .openingDate(LocalDate.now())
                .overdraftLimit(1000.0)
                .build();
    }

    public void openSavingsAccount(double initialBalance) {
        this.savingsAccount = SavingsAccount.builder()
                .accountNumber(generateAccountNumber())
                .balance(initialBalance)
                .openingDate(LocalDate.now())
                .interestRate(0.03)
                .build();
    }

    private String generateAccountNumber() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    private String generateCardNumber() {
        return String.format("%04d-%04d-%04d-%04d",
                (int) (Math.random() * 10000),
                (int) (Math.random() * 10000),
                (int) (Math.random() * 10000),
                (int) (Math.random() * 10000));
    }
}
