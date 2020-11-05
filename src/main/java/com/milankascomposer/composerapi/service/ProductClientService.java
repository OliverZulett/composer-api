package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.LineItemDTO;
import com.milankascomposer.composerapi.dto.ProductDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductClientService {

    private final WebClient productClient;

    public ProductClientService(WebClient.Builder webClientBuilder) {
        this.productClient = webClientBuilder
                .baseUrl("http://localhost:8090")
                .filter(ExchangeFilterFunctions.basicAuthentication("productAdmin", "productAdmin"))
                .build();
    }

    public ProductDTO getProductById(UUID id) {
        return this.productClient
                .get()
                .uri("/v1/products/{id}", id)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .block();
    }

    public List<ProductDTO> getProductsFromLineItemsList(List<LineItemDTO> lineItems) {
        return lineItems
                .stream()
                .map(lineItemDTO -> this.getProductById(lineItemDTO.getProductId()))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByCompanyId(UUID companyId) {
        return this.productClient
                .get()
                .uri("/v1/products")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<ProductDTO>>() {
                })
                .filter(productDTOS -> productDTOS.removeIf(productDTO -> !productDTO.getCompanyId().equals(companyId)))
                .block();
    }

}
