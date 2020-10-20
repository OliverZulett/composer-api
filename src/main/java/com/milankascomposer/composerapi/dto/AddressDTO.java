package com.milankascomposer.composerapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String addressLine1;

    private String addressLine2;

    private String contactName;

    private String contactPhone;

    private String state;

    private String city;

    private String zipCode;

    private String countryCode;

}
