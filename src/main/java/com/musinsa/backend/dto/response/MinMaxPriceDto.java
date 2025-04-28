package com.musinsa.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MinMaxPriceDto {
    private Long minPrice;
    private Long maxPrice;
}
