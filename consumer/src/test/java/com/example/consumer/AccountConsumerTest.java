package com.example.consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@AutoConfigureStubRunner(ids = "com.example:producer:+:stubs:8080",
                         stubsMode = StubRunnerProperties.StubsMode.LOCAL)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AccountConsumerTest {

    @Autowired
    private AccountClient client;

    @Test
    public void getAllAccounts() {
        Flux<Account> allReservations = client.getAllAccounts();
        StepVerifier.create(allReservations)
                    .expectNextMatches(r -> r.getName().equalsIgnoreCase("Me") && r.getId() != null)
                    .verifyComplete();
    }
}
