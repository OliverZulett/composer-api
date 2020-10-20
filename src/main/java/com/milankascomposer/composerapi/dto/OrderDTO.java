package com.milankascomposer.composerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO {

    private UUID orderId;

    private UUID userId;

    private List<LineItemDTO> lineItems;

    private String emailAddress;

    private AddressDTO shippingAddress;

}
