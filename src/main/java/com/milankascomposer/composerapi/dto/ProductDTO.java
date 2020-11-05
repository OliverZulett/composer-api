package com.milankascomposer.composerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductDTO {

    private UUID productId;

    private String name;

    private String description;

    private UUID companyId;

    private Boolean blocked;

    private List<String> categories;

}
