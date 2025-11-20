package com.example.proxibanque.application;

import lombok.Data;

@Data
public class ClientUpdateRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String zipCode;
    private String city;
    private String phone;
    private String email;
}
