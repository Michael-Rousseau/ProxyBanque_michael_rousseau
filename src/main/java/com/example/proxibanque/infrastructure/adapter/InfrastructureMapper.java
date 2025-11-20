package com.example.proxibanque.infrastructure.adapter;

import com.example.proxibanque.domain.model.Advisor;
import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.infrastructure.entity.AdvisorEntity;
import com.example.proxibanque.infrastructure.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InfrastructureMapper {

    Advisor toDomain(AdvisorEntity entity);
    AdvisorEntity toEntity(Advisor domain);

    Client toDomain(ClientEntity entity);

    @Mapping(target = "advisor", ignore = true)
    ClientEntity toEntity(Client domain);
}
