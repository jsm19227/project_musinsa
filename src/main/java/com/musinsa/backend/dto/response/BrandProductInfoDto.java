package com.musinsa.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BrandProductInfoDto {
    private Long brandId;
    private Long productId;
    private String brandName;
    private String categoryName;
    private Long price;
}
