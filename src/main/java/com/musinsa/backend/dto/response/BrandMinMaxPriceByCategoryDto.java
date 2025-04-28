package com.musinsa.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BrandMinMaxPriceByCategoryDto {
    private String categoryName;
    private List<BrandPriceDto> lowestPrices;
    private List<BrandPriceDto> higtestPrices;

}
