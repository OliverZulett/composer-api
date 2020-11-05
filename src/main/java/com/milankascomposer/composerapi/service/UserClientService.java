package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.OrderDTO;
import com.milankascomposer.composerapi.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class UserClientService {

    @Autowired
    OrderClientService orderClientService;

    private final WebClient userClient;

    public UserClientService(WebClient.Builder webClientBuilder) {
        this.userClient = webClientBuilder
                .baseUrl("http://localhost:8093")
                .filter(ExchangeFilterFunctions.basicAuthentication("userAdmin", "userAdmin"))
                .build();
    }

    public UserDTO getUserById(UUID id) {
        return this.userClient
                .get()
                .uri("/v1/users/{id}", id)
                .retrieve()
                .bodyToMono(UserDTO.class)
                .block();
    }

//    public Mono<List<OrderDTO>> getUserById(UUID id) {
//        return this.userClient
//                .get()
//                .uri("/v1/users/{id}", id)
//                .retrieve()
//                .bodyToMono(UserDTO.class)
//                .switchIfEmpty(Mono.error(new ServerWebInputException("Request body cannot be empty.")))
//                .flatMap(userDTO -> this.orderClientService.getOrdersByUserId(userDTO.getUserId()));
////                .block();
////                .exchange()
////                .flatMap(clientResponse -> clientResponse.bodyToMono(UserDTO.class))
////                .block();
////                .retrieve()
//////                .onStatus(HttpStatus::isError, GlobalErrorHandler::manageError)
////                .bodyToMono(UserDTO.class)
////                .flatMap(userDTO -> {
////                    if (userDTO == null) {
////                        return Mono.empty();
////                    }
////                    return Mono.just(userDTO);
////                });
//    }

}
