package com.example.proxibanque.infrastructure.repository;

import com.example.proxibanque.infrastructure.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaClientRepository extends JpaRepository<ClientEntity, UUID> {
}
