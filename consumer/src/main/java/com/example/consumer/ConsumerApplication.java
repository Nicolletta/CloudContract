package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ConsumerApplication.class, args);
		System.exit(SpringApplication.exit(context, () -> 0));
	}

	@Bean
	WebClient webClient(WebClient.Builder builder) {
		return builder.build();
	}
}
