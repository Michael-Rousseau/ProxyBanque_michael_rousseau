package com.example.proxibanque.application;

import com.example.proxibanque.domain.model.BankCard;
import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.domain.model.CurrentAccount;
import com.example.proxibanque.domain.model.SavingsAccount;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class, LocalDate.class, CurrentAccount.class, SavingsAccount.class})
public interface DtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currentAccount", ignore = true)
    @Mapping(target = "savingsAccount", ignore = true)
    @Mapping(target = "bankCards", ignore = true)
    @Mapping(target = "advisorId", ignore = true)
    Client toDomain(ClientCreateRequest request);

    @Mapping(target = "currentAccountId", expression = "java(client.getCurrentAccount() != null ? client.getCurrentAccount().getAccountNumber() : null)")
    @Mapping(target = "savingsAccountId", expression = "java(client.getSavingsAccount() != null ? client.getSavingsAccount().getAccountNumber() : null)")
    ClientResponse toResponse(Client client);

    CardResponse toCardResponse(BankCard card);

    default Client toDomainWithAccounts(ClientCreateRequest request) {
        Client client = toDomain(request);

        if (request.isCreateCurrentAccount()) {
            client.openCurrentAccount(request.getCurrentAccountBalance());
        }

        if (request.isCreateSavingsAccount()) {
            client.openSavingsAccount(request.getSavingsAccountBalance());
        }

        return client;
    }
}
