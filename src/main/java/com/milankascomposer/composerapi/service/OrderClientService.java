package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.LineItemDTO;
import com.milankascomposer.composerapi.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderClientService {

    private final WebClient orderClient;

    public OrderClientService(@Value("${order.api.uri}") String baseUrl, WebClient.Builder webClientBuilder) {
        this.orderClient = webClientBuilder
                .baseUrl(baseUrl)
                .filter(ExchangeFilterFunctions.basicAuthentication("orderAdmin", "orderAdmin"))
                .build();
    }

    public List<OrderDTO> getOrdersByUserId(UUID userId) {
        return this.orderClient
                .get()
                .uri("/v1/orders")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<OrderDTO>>() {
                })
                .filter(orderDTOS -> orderDTOS.removeIf(orderDTO -> !orderDTO.getUserId().equals(userId)))
                .block();

    }

    public List<LineItemDTO> getLineItemsFromOrdersByUserId(UUID userId) {
        return this.getOrdersByUserId(userId)
                .stream()
                .flatMap(orderDTO -> orderDTO.getLineItems().stream())
                .collect(Collectors.toList());
    }

}
