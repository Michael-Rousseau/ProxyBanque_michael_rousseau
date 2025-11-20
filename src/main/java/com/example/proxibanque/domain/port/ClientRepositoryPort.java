package com.example.proxibanque.domain.port;

import com.example.proxibanque.domain.model.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepositoryPort {
    Client save(Client client);
    Optional<Client> findById(UUID id);
    void deleteById(UUID id);
}
