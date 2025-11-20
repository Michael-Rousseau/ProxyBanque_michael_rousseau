package com.example.proxibanque.domain.port;

import com.example.proxibanque.domain.model.Client;

import java.util.UUID;

public interface ClientManagementUseCase {
    Client createClient(Client client, UUID advisorId);
    void removeClient(UUID clientId);
    void wireTransfer(UUID fromClientId, UUID toClientId, double amount);
}
