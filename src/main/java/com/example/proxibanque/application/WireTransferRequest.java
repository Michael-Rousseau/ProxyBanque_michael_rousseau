package com.example.proxibanque.application;

import lombok.Data;

import java.util.UUID;

@Data
public class WireTransferRequest {
    private UUID fromClientId;
    private UUID toClientId;
    private double amount;
}
