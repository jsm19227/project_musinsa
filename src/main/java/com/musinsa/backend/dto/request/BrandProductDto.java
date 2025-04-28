package com.musinsa.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrandProductDto {
    private Long brandId;
    private Long productId;
    private String brandName;
    private String categoryName;
    private Long price;
}
