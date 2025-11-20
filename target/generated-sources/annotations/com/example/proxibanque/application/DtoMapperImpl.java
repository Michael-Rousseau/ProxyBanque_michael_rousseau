package com.example.proxibanque.application;

import com.example.proxibanque.domain.model.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T15:36:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Homebrew)"
)
@Component
public class DtoMapperImpl implements DtoMapper {

    @Override
    public Client toDomain(ClientCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.lastName( request.getLastName() );
        client.firstName( request.getFirstName() );
        client.address( request.getAddress() );
        client.zipCode( request.getZipCode() );
        client.city( request.getCity() );
        client.phone( request.getPhone() );

        return client.build();
    }

    @Override
    public ClientResponse toResponse(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientResponse clientResponse = new ClientResponse();

        clientResponse.setId( client.getId() );
        clientResponse.setLastName( client.getLastName() );
        clientResponse.setFirstName( client.getFirstName() );
        clientResponse.setAddress( client.getAddress() );

        return clientResponse;
    }
}
