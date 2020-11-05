package com.milankascomposer.composerapi.service;

import com.milankascomposer.composerapi.dto.CompanyDTO;
import com.milankascomposer.composerapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CompanyClientService {

    private final WebClient companyClient;

    public CompanyClientService(@Value("${company.api.uri}") String baseUrl, WebClient.Builder webClientBuilder) {
        this.companyClient = webClientBuilder
                .baseUrl(baseUrl)
                .filter(ExchangeFilterFunctions.basicAuthentication("companyAdmin", "companyAdmin"))
                .build();
    }

    public CompanyDTO getCompanyById(UUID id) {
        return this.companyClient
                .get()
                .uri("/v1/companies/{id}", id)
                .retrieve()
                .onStatus(
                        HttpStatus::is4xxClientError,
                        clientResponse -> Mono.error(new ResourceNotFoundException("Company not found for id: " + id))
                )
                .bodyToMono(CompanyDTO.class)
                .block();
    }

}
