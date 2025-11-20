package com.example.proxibanque.infrastructure.adapter;

import com.example.proxibanque.domain.model.Advisor;
import com.example.proxibanque.domain.model.BankCard;
import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.domain.model.CurrentAccount;
import com.example.proxibanque.domain.model.SavingsAccount;
import com.example.proxibanque.infrastructure.entity.AdvisorEntity;
import com.example.proxibanque.infrastructure.entity.BankCardEntity;
import com.example.proxibanque.infrastructure.entity.ClientEntity;
import com.example.proxibanque.infrastructure.entity.CurrentAccountEntity;
import com.example.proxibanque.infrastructure.entity.SavingsAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InfrastructureMapper {

    Advisor toDomain(AdvisorEntity entity);
    AdvisorEntity toEntity(Advisor domain);

    @Mapping(target = "advisorId", source = "advisor.id")
    Client toDomain(ClientEntity entity);

    @Mapping(target = "advisor", ignore = true)
    @Mapping(target = "currentAccount", source = "currentAccount")
    @Mapping(target = "savingsAccount", source = "savingsAccount")
    ClientEntity toEntity(Client domain);

    @Mapping(target = "id", ignore = true)
    CurrentAccountEntity toEntity(CurrentAccount domain);

    @Mapping(target = "id", ignore = true)
    SavingsAccountEntity toEntity(SavingsAccount domain);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "type", expression = "java(domain.getType().name())")
    BankCardEntity toEntity(BankCard domain);

    @Mapping(target = "type", expression = "java(BankCard.CardType.valueOf(entity.getType()))")
    BankCard toDomain(BankCardEntity entity);

    CurrentAccount toDomain(CurrentAccountEntity entity);
    SavingsAccount toDomain(SavingsAccountEntity entity);
}
