package com.example.proxibanque.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private UUID id;
    private String lastName;
    private String firstName;
    private String address;
    private String email;
}
