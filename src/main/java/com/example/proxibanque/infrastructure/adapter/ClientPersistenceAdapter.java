package com.example.proxibanque.infrastructure.adapter;

import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.domain.port.ClientRepositoryPort;
import com.example.proxibanque.infrastructure.repository.JpaAdvisorRepository;
import com.example.proxibanque.infrastructure.repository.JpaClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientRepositoryPort {

    private final JpaClientRepository jpaClientRepository;
    private final JpaAdvisorRepository jpaAdvisorRepository;
    private final InfrastructureMapper mapper;

    @Override
    public Client save(Client client) {
        var entity = mapper.toEntity(client);

        if (client.getAdvisorId() != null) {
            var advisorEntity = jpaAdvisorRepository.findById(client.getAdvisorId())
                    .orElse(null);
            entity.setAdvisor(advisorEntity);
        }

        var saved = jpaClientRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return jpaClientRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaClientRepository.deleteById(id);
    }
}
