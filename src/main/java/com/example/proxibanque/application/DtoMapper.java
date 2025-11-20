package com.example.proxibanque.application;

import com.example.proxibanque.domain.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DtoMapper {
    Client toDomain(ClientCreateRequest request);
    ClientResponse toResponse(Client client);
}
