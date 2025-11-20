package com.example.proxibanque.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "advisor")
@Data
public class AdvisorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String lastName;
    private String firstName;

    @OneToMany(mappedBy = "advisor")
    private List<ClientEntity> clients;
}
