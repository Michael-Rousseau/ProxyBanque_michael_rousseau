package com.example.proxibanque.domain.model;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Advisor {
    private UUID id;
    private String lastName;
    private String firstName;

    @Builder.Default
    private List<Client> clients = new ArrayList<>();

    public boolean hasCapacity() {
        return this.clients.size() < 10;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }
}
