package com.example.producer;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
class AccountRouter {

    @Bean
    RouterFunction<ServerResponse> getAccounts(AccountRepository repository) {
        return route().GET("/accounts", r -> ok()
                      .body(repository.findAll(), Account.class)).build();
    }
}