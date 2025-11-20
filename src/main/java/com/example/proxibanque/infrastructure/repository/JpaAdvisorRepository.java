package com.example.proxibanque.infrastructure.repository;

import com.example.proxibanque.infrastructure.entity.AdvisorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaAdvisorRepository extends JpaRepository<AdvisorEntity, UUID> {
}
