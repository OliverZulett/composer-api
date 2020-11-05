package com.milankascomposer.composerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CompanyDTO {

    private UUID companyId;

    private String name;

    private AddressDTO address;

}
