package com.musinsa.backend.domain.repository;

import com.musinsa.backend.dto.response.BrandPriceDto;
import com.musinsa.backend.dto.response.CategoryBrandLowestPriceDto;
import com.musinsa.backend.dto.response.MinMaxPriceDto;
import com.querydsl.core.Tuple;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Tuple> getCategoryBrandLowestPrice();
    Long getGroupByCategoryNameCount();

    List<Tuple> getCategoryBrandTotalPriceByCategoryCount(Long categoryCount);

    List<Tuple> getCategoryPriceByBrandId(Long brandId);

    MinMaxPriceDto getMinMaxPrice(String categoryName);

    List<BrandPriceDto> getProductByPrice(String categoryName, Long price);

}