package com.example.proxibanque.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "client")
@Data
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String lastName;
    private String firstName;
    private String address;
    private String zipCode;
    private String city;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private AdvisorEntity advisor;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private CurrentAccountEntity currentAccount;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private SavingsAccountEntity savingsAccount;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "client_id")
    private List<BankCardEntity> bankCards = new ArrayList<>();
}
