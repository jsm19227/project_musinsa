package com.musinsa.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryBrandTotalLowestPriceDto {
    private String brandName;
    List<CategoryPriceDto> categoryPrices;
    private String totalPrice;
}
