package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserClientService {

    private final WebClient userClient;

    public UserClientService(WebClient.Builder webClientBuilder) {
        this.userClient = webClientBuilder
                .baseUrl("http://localhost:8093")
                .filter(ExchangeFilterFunctions.basicAuthentication("userAdmin", "userAdmin"))
                .build();
    }

    public Mono<UserDTO> getUserById(UUID id) {
        return this.userClient
                .get()
                .uri("/v1/users/{id}", id)
                .retrieve()
                .bodyToMono(UserDTO.class);
    }

}