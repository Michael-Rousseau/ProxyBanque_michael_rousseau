package com.example.proxibanque.domain.port;

import com.example.proxibanque.domain.model.Advisor;

import java.util.Optional;
import java.util.UUID;

public interface AdvisorRepositoryPort {
    Optional<Advisor> findById(UUID id);
    Advisor save(Advisor advisor);
}
