package com.example.proxibanque.infrastructure.adapter;

import com.example.proxibanque.domain.model.Advisor;
import com.example.proxibanque.domain.model.Client;
import com.example.proxibanque.domain.model.CurrentAccount;
import com.example.proxibanque.domain.model.SavingsAccount;
import com.example.proxibanque.infrastructure.entity.AdvisorEntity;
import com.example.proxibanque.infrastructure.entity.ClientEntity;
import com.example.proxibanque.infrastructure.entity.CurrentAccountEntity;
import com.example.proxibanque.infrastructure.entity.SavingsAccountEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T15:36:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.9 (Homebrew)"
)
@Component
public class InfrastructureMapperImpl implements InfrastructureMapper {

    @Override
    public Advisor toDomain(AdvisorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Advisor.AdvisorBuilder advisor = Advisor.builder();

        advisor.id( entity.getId() );
        advisor.lastName( entity.getLastName() );
        advisor.firstName( entity.getFirstName() );
        advisor.clients( clientEntityListToClientList( entity.getClients() ) );

        return advisor.build();
    }

    @Override
    public AdvisorEntity toEntity(Advisor domain) {
        if ( domain == null ) {
            return null;
        }

        AdvisorEntity advisorEntity = new AdvisorEntity();

        advisorEntity.setId( domain.getId() );
        advisorEntity.setLastName( domain.getLastName() );
        advisorEntity.setFirstName( domain.getFirstName() );
        advisorEntity.setClients( clientListToClientEntityList( domain.getClients() ) );

        return advisorEntity;
    }

    @Override
    public Client toDomain(ClientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( entity.getId() );
        client.lastName( entity.getLastName() );
        client.firstName( entity.getFirstName() );
        client.address( entity.getAddress() );
        client.zipCode( entity.getZipCode() );
        client.city( entity.getCity() );
        client.phone( entity.getPhone() );
        client.currentAccount( currentAccountEntityToCurrentAccount( entity.getCurrentAccount() ) );
        client.savingsAccount( savingsAccountEntityToSavingsAccount( entity.getSavingsAccount() ) );

        return client.build();
    }

    @Override
    public ClientEntity toEntity(Client domain) {
        if ( domain == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setId( domain.getId() );
        clientEntity.setLastName( domain.getLastName() );
        clientEntity.setFirstName( domain.getFirstName() );
        clientEntity.setAddress( domain.getAddress() );
        clientEntity.setZipCode( domain.getZipCode() );
        clientEntity.setCity( domain.getCity() );
        clientEntity.setPhone( domain.getPhone() );
        clientEntity.setCurrentAccount( currentAccountToCurrentAccountEntity( domain.getCurrentAccount() ) );
        clientEntity.setSavingsAccount( savingsAccountToSavingsAccountEntity( domain.getSavingsAccount() ) );

        return clientEntity;
    }

    protected List<Client> clientEntityListToClientList(List<ClientEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Client> list1 = new ArrayList<Client>( list.size() );
        for ( ClientEntity clientEntity : list ) {
            list1.add( toDomain( clientEntity ) );
        }

        return list1;
    }

    protected List<ClientEntity> clientListToClientEntityList(List<Client> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientEntity> list1 = new ArrayList<ClientEntity>( list.size() );
        for ( Client client : list ) {
            list1.add( toEntity( client ) );
        }

        return list1;
    }

    protected CurrentAccount currentAccountEntityToCurrentAccount(CurrentAccountEntity currentAccountEntity) {
        if ( currentAccountEntity == null ) {
            return null;
        }

        CurrentAccount.CurrentAccountBuilder<?, ?> currentAccount = CurrentAccount.builder();

        currentAccount.accountNumber( currentAccountEntity.getAccountNumber() );
        currentAccount.balance( currentAccountEntity.getBalance() );
        currentAccount.openingDate( currentAccountEntity.getOpeningDate() );
        currentAccount.overdraftLimit( currentAccountEntity.getOverdraftLimit() );

        return currentAccount.build();
    }

    protected SavingsAccount savingsAccountEntityToSavingsAccount(SavingsAccountEntity savingsAccountEntity) {
        if ( savingsAccountEntity == null ) {
            return null;
        }

        SavingsAccount.SavingsAccountBuilder<?, ?> savingsAccount = SavingsAccount.builder();

        savingsAccount.accountNumber( savingsAccountEntity.getAccountNumber() );
        savingsAccount.balance( savingsAccountEntity.getBalance() );
        savingsAccount.openingDate( savingsAccountEntity.getOpeningDate() );
        savingsAccount.interestRate( savingsAccountEntity.getInterestRate() );

        return savingsAccount.build();
    }

    protected CurrentAccountEntity currentAccountToCurrentAccountEntity(CurrentAccount currentAccount) {
        if ( currentAccount == null ) {
            return null;
        }

        CurrentAccountEntity currentAccountEntity = new CurrentAccountEntity();

        currentAccountEntity.setAccountNumber( currentAccount.getAccountNumber() );
        currentAccountEntity.setBalance( currentAccount.getBalance() );
        currentAccountEntity.setOpeningDate( currentAccount.getOpeningDate() );
        currentAccountEntity.setOverdraftLimit( currentAccount.getOverdraftLimit() );

        return currentAccountEntity;
    }

    protected SavingsAccountEntity savingsAccountToSavingsAccountEntity(SavingsAccount savingsAccount) {
        if ( savingsAccount == null ) {
            return null;
        }

        SavingsAccountEntity savingsAccountEntity = new SavingsAccountEntity();

        savingsAccountEntity.setAccountNumber( savingsAccount.getAccountNumber() );
        savingsAccountEntity.setBalance( savingsAccount.getBalance() );
        savingsAccountEntity.setOpeningDate( savingsAccount.getOpeningDate() );
        savingsAccountEntity.setInterestRate( savingsAccount.getInterestRate() );

        return savingsAccountEntity;
    }
}
