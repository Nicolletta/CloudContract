package com.example.producer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.restassured.RestAssured;
import reactor.core.publisher.Flux;

@ExtendWith(SpringExtension.class)
@Import(AccountRouter.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContractBaseClass {
    @LocalServerPort
    private int port;

    @MockBean
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "http://localhost:" + this.port;
        Mockito.when(this.accountRepository.findAll()).thenReturn(Flux.just(new Account(1L, "Me")));
    }
}
