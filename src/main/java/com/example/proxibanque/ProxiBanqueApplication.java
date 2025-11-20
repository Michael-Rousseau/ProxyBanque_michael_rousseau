package com.example.proxibanque;

import com.example.proxibanque.domain.port.AdvisorRepositoryPort;
import com.example.proxibanque.domain.port.ClientManagementUseCase;
import com.example.proxibanque.domain.port.ClientRepositoryPort;
import com.example.proxibanque.domain.service.ClientDomainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProxiBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxiBanqueApplication.class, args);
    }

    @Bean
    public ClientManagementUseCase clientManagementUseCase(
            AdvisorRepositoryPort advisorRepository,
            ClientRepositoryPort clientRepository) {
        return new ClientDomainService(advisorRepository, clientRepository);
    }
}
