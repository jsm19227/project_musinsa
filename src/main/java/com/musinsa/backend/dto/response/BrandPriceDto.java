package com.musinsa.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
public class BrandPriceDto {
    private String brandName;
    @JsonIgnore
    private Long price;

    @JsonProperty("price")
    public String getFormattedPrice() {
        if (price == null) {
            return null;
        }
        return new DecimalFormat("#,###").format(price);
    }
}
