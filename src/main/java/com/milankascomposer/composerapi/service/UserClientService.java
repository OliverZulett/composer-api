package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.UserDTO;
import com.milankascomposer.composerapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserClientService {

    @Autowired
    OrderClientService orderClientService;

    @Autowired
    private Environment env;

    private final WebClient userClient;

    @Autowired
    public UserClientService(@Value("${user.api.uri}") String baseUrl, WebClient.Builder webClientBuilder) {
        this.userClient = webClientBuilder
                .baseUrl(baseUrl)
                .filter(ExchangeFilterFunctions.basicAuthentication("userAdmin", "userAdmin"))
                .build();
    }

    public UserDTO getUserById(UUID id) {
        return this.userClient
                .get()
                .uri("/v1/users/{id}", id)
                .retrieve()
                .onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse -> Mono.error(new ResourceNotFoundException("User not found for id: " + id))
                )
                .bodyToMono(UserDTO.class)
                .block();
    }

}
