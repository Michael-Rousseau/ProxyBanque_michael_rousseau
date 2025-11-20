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

        return clientRepository.save(client);
    }

    @Override
    public void removeClient(UUID clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new BusinessException("Client not found"));

        client.deactivateAllCards();
        clientRepository.deleteById(clientId);
    }
}
