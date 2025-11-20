package com.example.proxibanque.domain.service;

import com.example.proxibanque.domain.model.Advisor;
import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.domain.port.AdvisorRepositoryPort;
import com.example.proxibanque.domain.port.ClientManagementUseCase;
import com.example.proxibanque.domain.port.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.ErrorResponseException;

import java.util.UUID;

@RequiredArgsConstructor
public class ClientDomainService implements ClientManagementUseCase {

    private final AdvisorRepositoryPort advisorRepository;
    private final ClientRepositoryPort clientRepository;

    @Override
    public Client createClient(Client client, UUID advisorId) {
        Advisor advisor = advisorRepository.findById(advisorId)
                .orElseThrow(() -> new BusinessException("Advisor not found"));

        if (!advisor.hasCapacity()) {
            throw new BusinessException("Advisor is full (max 10 clients)");
        }

        advisor.addClient(client);
        client.setAdvisorId(advisorId);
        return clientRepository.save(client);
    }

    @Override
    public void removeClient(UUID clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new BusinessException("Client not found"));

        // Deactivate all cards before deletion
        client.deactivateAllCards();

        // Delete client - this will cascade delete all associated accounts (current & savings) and cards
        clientRepository.deleteById(clientId);
    }

    @Override
    public void wireTransfer(UUID fromClientId, UUID toClientId, double amount) {
        if (amount <= 0) {
            throw new BusinessException("Transfer amount must be positive");
        }

        Client fromClient = clientRepository.findById(fromClientId)
                .orElseThrow(() -> new BusinessException("Source client not found"));

        Client toClient = clientRepository.findById(toClientId)
                .orElseThrow(() -> new BusinessException("Destination client not found"));

        if (fromClient.getCurrentAccount() == null) {
            throw new BusinessException("Source client has no current account");
        }

        if (toClient.getCurrentAccount() == null) {
            throw new BusinessException("Destination client has no current account");
        }

        // Perform the transfer
        fromClient.getCurrentAccount().withdraw(amount);
        toClient.getCurrentAccount().deposit(amount);

        // Check and update card status for the sender
        fromClient.checkAndUpdateCardStatus();

        // Save both clients
        clientRepository.save(fromClient);
        clientRepository.save(toClient);
    }
}
