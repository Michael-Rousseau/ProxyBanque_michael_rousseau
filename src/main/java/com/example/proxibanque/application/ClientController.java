package com.example.proxibanque.application;

import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.domain.port.ClientManagementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientManagementUseCase clientManagementUseCase;
    private final DtoMapper mapper;

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientCreateRequest request) {
        Client clientDomain = mapper.toDomain(request);
        Client createdClient = clientManagementUseCase.createClient(clientDomain, request.getAdvisorId());

        return ResponseEntity.ok(mapper.toResponse(createdClient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        clientManagementUseCase.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}
