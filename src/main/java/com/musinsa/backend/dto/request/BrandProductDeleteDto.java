package com.musinsa.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BrandProductDeleteDto {
    private Long brandId;
    private Long productId;
}
