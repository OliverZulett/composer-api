package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductClientService {

    private final WebClient productClient;

    public ProductClientService(WebClient.Builder webClientBuilder) {
        this.productClient = webClientBuilder
                .baseUrl("http://localhost:8090")
                .filter(ExchangeFilterFunctions.basicAuthentication("productAdmin", "productAdmin"))
                .build();
    }

    public Mono<ProductDTO> getProductById(UUID id) {
        return this.productClient
                .get()
                .uri("/v1/products/{id}", id)
                .retrieve()
                .bodyToMono(ProductDTO.class);
    }

}
