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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T16:33:27+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.1 (Homebrew)"
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

        client.advisorId( entityAdvisorId( entity ) );
        client.id( entity.getId() );
        client.lastName( entity.getLastName() );
        client.firstName( entity.getFirstName() );
        client.address( entity.getAddress() );
        client.zipCode( entity.getZipCode() );
        client.city( entity.getCity() );
        client.phone( entity.getPhone() );
        client.email( entity.getEmail() );
        client.currentAccount( toDomain( entity.getCurrentAccount() ) );
        client.savingsAccount( toDomain( entity.getSavingsAccount() ) );
        client.bankCards( bankCardEntityListToBankCardList( entity.getBankCards() ) );

        return client.build();
    }

    @Override
    public ClientEntity toEntity(Client domain) {
        if ( domain == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setCurrentAccount( toEntity( domain.getCurrentAccount() ) );
        clientEntity.setSavingsAccount( toEntity( domain.getSavingsAccount() ) );
        clientEntity.setId( domain.getId() );
        clientEntity.setLastName( domain.getLastName() );
        clientEntity.setFirstName( domain.getFirstName() );
        clientEntity.setAddress( domain.getAddress() );
        clientEntity.setZipCode( domain.getZipCode() );
        clientEntity.setCity( domain.getCity() );
        clientEntity.setPhone( domain.getPhone() );
        clientEntity.setEmail( domain.getEmail() );
        clientEntity.setBankCards( bankCardListToBankCardEntityList( domain.getBankCards() ) );

        return clientEntity;
    }

    @Override
    public CurrentAccountEntity toEntity(CurrentAccount domain) {
        if ( domain == null ) {
            return null;
        }

        CurrentAccountEntity currentAccountEntity = new CurrentAccountEntity();

        currentAccountEntity.setAccountNumber( domain.getAccountNumber() );
        currentAccountEntity.setBalance( domain.getBalance() );
        currentAccountEntity.setOpeningDate( domain.getOpeningDate() );
        currentAccountEntity.setOverdraftLimit( domain.getOverdraftLimit() );

        return currentAccountEntity;
    }

    @Override
    public SavingsAccountEntity toEntity(SavingsAccount domain) {
        if ( domain == null ) {
            return null;
        }

        SavingsAccountEntity savingsAccountEntity = new SavingsAccountEntity();

        savingsAccountEntity.setAccountNumber( domain.getAccountNumber() );
        savingsAccountEntity.setBalance( domain.getBalance() );
        savingsAccountEntity.setOpeningDate( domain.getOpeningDate() );
        savingsAccountEntity.setInterestRate( domain.getInterestRate() );

        return savingsAccountEntity;
    }

    @Override
    public BankCardEntity toEntity(BankCard domain) {
        if ( domain == null ) {
            return null;
        }

        BankCardEntity bankCardEntity = new BankCardEntity();

        bankCardEntity.setCardNumber( domain.getCardNumber() );
        bankCardEntity.setActive( domain.isActive() );

        bankCardEntity.setType( domain.getType().name() );

        return bankCardEntity;
    }

    @Override
    public BankCard toDomain(BankCardEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BankCard.BankCardBuilder bankCard = BankCard.builder();

        bankCard.cardNumber( entity.getCardNumber() );
        bankCard.active( entity.isActive() );

        bankCard.type( BankCard.CardType.valueOf(entity.getType()) );

        return bankCard.build();
    }

    @Override
    public CurrentAccount toDomain(CurrentAccountEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CurrentAccount.CurrentAccountBuilder<?, ?> currentAccount = CurrentAccount.builder();

        currentAccount.accountNumber( entity.getAccountNumber() );
        currentAccount.balance( entity.getBalance() );
        currentAccount.openingDate( entity.getOpeningDate() );
        currentAccount.overdraftLimit( entity.getOverdraftLimit() );

        return currentAccount.build();
    }

    @Override
    public SavingsAccount toDomain(SavingsAccountEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SavingsAccount.SavingsAccountBuilder<?, ?> savingsAccount = SavingsAccount.builder();

        savingsAccount.accountNumber( entity.getAccountNumber() );
        savingsAccount.balance( entity.getBalance() );
        savingsAccount.openingDate( entity.getOpeningDate() );
        savingsAccount.interestRate( entity.getInterestRate() );

        return savingsAccount.build();
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

    private UUID entityAdvisorId(ClientEntity clientEntity) {
        if ( clientEntity == null ) {
            return null;
        }
        AdvisorEntity advisor = clientEntity.getAdvisor();
        if ( advisor == null ) {
            return null;
        }
        UUID id = advisor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<BankCard> bankCardEntityListToBankCardList(List<BankCardEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<BankCard> list1 = new ArrayList<BankCard>( list.size() );
        for ( BankCardEntity bankCardEntity : list ) {
            list1.add( toDomain( bankCardEntity ) );
        }

        return list1;
    }

    protected List<BankCardEntity> bankCardListToBankCardEntityList(List<BankCard> list) {
        if ( list == null ) {
            return null;
        }

        List<BankCardEntity> list1 = new ArrayList<BankCardEntity>( list.size() );
        for ( BankCard bankCard : list ) {
            list1.add( toEntity( bankCard ) );
        }

        return list1;
    }
}
