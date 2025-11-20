package com.example.proxibanque.application;

import com.example.proxibanque.domain.model.BankCard;
import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.domain.port.ClientManagementUseCase;
import com.example.proxibanque.domain.port.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientManagementUseCase clientManagementUseCase;
    private final ClientRepositoryPort clientRepository;
    private final DtoMapper mapper;

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientCreateRequest request) {
        Client clientDomain = mapper.toDomainWithAccounts(request);
        Client createdClient = clientManagementUseCase.createClient(clientDomain, request.getAdvisorId());

        return ResponseEntity.ok(mapper.toResponse(createdClient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable UUID id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return ResponseEntity.ok(mapper.toResponse(client));
    }

    @GetMapping
    public ResponseEntity<java.util.List<ClientResponse>> getAllClients() {
        java.util.List<Client> clients = clientRepository.findAll();
        java.util.List<ClientResponse> responses = clients.stream()
                .map(mapper::toResponse)
                .collect(java.util.stream.Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(
            @PathVariable UUID id,
            @RequestBody ClientUpdateRequest request) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        if (request.getFirstName() != null) {
            client.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            client.setLastName(request.getLastName());
        }
        if (request.getAddress() != null) {
            client.setAddress(request.getAddress());
        }
        if (request.getZipCode() != null) {
            client.setZipCode(request.getZipCode());
        }
        if (request.getCity() != null) {
            client.setCity(request.getCity());
        }
        if (request.getPhone() != null) {
            client.setPhone(request.getPhone());
        }
        if (request.getEmail() != null) {
            client.setEmail(request.getEmail());
        }

        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(mapper.toResponse(updatedClient));
    }

    @PostMapping("/{clientId}/cards")
    public ResponseEntity<CardResponse> assignCard(
            @PathVariable UUID clientId,
            @RequestBody CardAssignRequest request) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        BankCard card = client.assignCard(request.getCardType());
        Client updatedClient = clientRepository.save(client);

        return ResponseEntity.ok(mapper.toCardResponse(card));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        clientManagementUseCase.removeClient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/wire-transfer")
    public ResponseEntity<Void> wireTransfer(@RequestBody WireTransferRequest request) {
        clientManagementUseCase.wireTransfer(
                request.getFromClientId(),
                request.getToClientId(),
                request.getAmount()
        );
        return ResponseEntity.ok().build();
    }
}
