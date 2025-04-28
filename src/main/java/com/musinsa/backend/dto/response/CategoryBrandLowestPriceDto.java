package com.musinsa.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
public class CategoryBrandLowestPriceDto {
    private String categoryName;
    private String brandName;
    @JsonIgnore
    private Long lowestPrice;  // 내부 데이터용

    @JsonProperty("lowestPrice")
    public String getFormattedLowestPrice() {
        if (lowestPrice == null) {
            return null;
        }
        return new DecimalFormat("#,###").format(lowestPrice);
    }
}
