package com.example.proxibanque.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCreateRequest {
    private UUID advisorId;
    private String lastName;
    private String firstName;
    private String address;
    private String zipCode;
    private String city;
    private String phone;
}
