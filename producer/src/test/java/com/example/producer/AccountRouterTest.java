package com.example.producer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;

@ExtendWith(SpringExtension.class)
@WebFluxTest
@Import(AccountRouter.class)
public class AccountRouterTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private WebTestClient testClient;

    @Test
    public void getAllAccounts() {
        Mockito.when(accountRepository.findAll())
               .thenReturn(Flux.just(new Account(1L, "Me")));

        testClient.get().uri("/accounts").exchange().expectBody()
                  .jsonPath("@.[0].id").isEqualTo("1")
                  .jsonPath("@.[0].name").isEqualTo("Me");
    }
}
