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
