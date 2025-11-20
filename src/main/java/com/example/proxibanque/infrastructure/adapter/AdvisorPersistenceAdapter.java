package com.example.proxibanque.infrastructure.adapter;

import com.example.proxibanque.domain.model.Advisor;
import com.example.proxibanque.domain.port.AdvisorRepositoryPort;
import com.example.proxibanque.infrastructure.repository.JpaAdvisorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AdvisorPersistenceAdapter implements AdvisorRepositoryPort {

    private final JpaAdvisorRepository jpaAdvisorRepository;
    private final InfrastructureMapper mapper;

    @Override
    public Optional<Advisor> findById(UUID id) {
        return jpaAdvisorRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Advisor save(Advisor advisor) {
        var entity = mapper.toEntity(advisor);
        var savedEntity = jpaAdvisorRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
}
