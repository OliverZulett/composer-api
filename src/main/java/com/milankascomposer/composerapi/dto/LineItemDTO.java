package com.milankascomposer.composerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LineItemDTO {

    private UUID productId;

    private Integer qty;

}
