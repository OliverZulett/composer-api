package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.OrderDTO;
import com.milankascomposer.composerapi.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Predicate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class OrderClientService {

    @Autowired
    UserClientService userClientService;

    private final WebClient orderClient;

    public OrderClientService(WebClient.Builder webClientBuilder) {
        this.orderClient = webClientBuilder
                .baseUrl("http://localhost:8091")
                .filter(ExchangeFilterFunctions.basicAuthentication("orderAdmin", "orderAdmin"))
                .build();
    }

    public Mono<List<OrderDTO>> getOrdersByUserId(UUID userId) {
        Mono<UserDTO> user = this.userClientService.getUserById(userId);
        return this.orderClient
                .get()
                .uri("/v1/orders")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<OrderDTO>>() {})
                .filter(orderDTOS -> orderDTOS.removeIf(orderDTO -> !orderDTO.getUserId().equals(userId)));

    }

}
