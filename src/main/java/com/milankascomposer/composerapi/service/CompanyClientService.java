package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.CompanyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class CompanyClientService {

    private final WebClient companyClient;

    public CompanyClientService(WebClient.Builder webClientBuilder) {
        this.companyClient = webClientBuilder
                .baseUrl("http://localhost:8092")
                .filter(ExchangeFilterFunctions.basicAuthentication("companyAdmin", "companyAdmin"))
                .build();
    }

    public CompanyDTO getCompanyById(UUID id) {
        return this.companyClient
                .get()
                .uri("/v1/companies/{id}", id)
                .retrieve()
                .bodyToMono(CompanyDTO.class)
                .block();
    }

}
