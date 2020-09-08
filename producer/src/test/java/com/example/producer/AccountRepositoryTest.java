package com.example.producer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataR2dbcTest
@ExtendWith(SpringExtension.class)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void findAll() throws Exception {

        Flux<Account> preparedAccounts = this.accountRepository.deleteAll()
                .thenMany(this.accountRepository.save(new Account(null, "Me")))
                .thenMany(this.accountRepository.findAll());

        StepVerifier.create(preparedAccounts)
                .expectNextMatches(account -> account.getName().equalsIgnoreCase("Me") && account.getId() != null)
                .verifyComplete();
    }
}