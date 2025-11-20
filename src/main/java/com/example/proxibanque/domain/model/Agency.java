package com.example.proxibanque.domain.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Agency {
    private String numeroIdentification;
    private LocalDate dateCreation;
    private String nomGerant;

    public Agency(String numeroIdentification, LocalDate dateCreation) {
        if (numeroIdentification == null || numeroIdentification.length() != 5) {
            throw new IllegalArgumentException("L'ID de l'agence doit contenir 5 caractères");
        }
        this.numeroIdentification = numeroIdentification;
        this.dateCreation = dateCreation;
    }
}
