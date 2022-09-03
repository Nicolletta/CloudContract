package com.example.consumer;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class AccountClient {
    private final WebClient webClient;

    public Flux<Account> getAllAccounts() {
        return webClient.get()
                        .uri("http://localhost:8080/accounts")
                        .retrieve()
                        .bodyToFlux(Account.class);
    }
    
	@PostConstruct
	public void init() {
		getAllAccounts().subscribe(System.out::println);
	}
}
