package com.musinsa.backend.controller;

import com.musinsa.backend.dto.request.BrandProductDeleteDto;
import com.musinsa.backend.dto.request.BrandProductDto;
import com.musinsa.backend.dto.response.BrandMinMaxPriceByCategoryDto;
import com.musinsa.backend.dto.response.CategoryBrandPriceDto;
import com.musinsa.backend.dto.response.CategoryBrandTotalLowestPriceDto;
import com.musinsa.backend.dto.response.BrandProductInfoDto;
import com.musinsa.backend.exception.CustomException;
import com.musinsa.backend.exception.ErrorCode;
import com.musinsa.backend.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product", description = "카테고리/상품 API")
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "구현1)상품별 최저 가격 브랜드 정보 조회")
    @GetMapping("/category/brand/lowest-price")
    public ResponseEntity<CategoryBrandPriceDto> getCategoryBrandLowestPrice() {
        CategoryBrandPriceDto result = productService.getCategoryBrandLowestPrice();
        return ResponseEntity.ok(result);
    }
    
    @Operation(summary = "구현2)모든 상품 구매시 최저 브랜드 정보 조회")
    @GetMapping("/brand/total-lowest-price")
    public ResponseEntity<CategoryBrandTotalLowestPriceDto> getBrandTotalLowestPrice() {
        CategoryBrandTotalLowestPriceDto result = productService.getBrandTotalLowestPrice();
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "구현3)카테고리별 최저/최고 가격 브랜드 정보 조회")
    @Parameters({
            @Parameter(name = "categoryName", description = "카테고리명", required = true, example = "상의")
    })
    @GetMapping("/brand/price")
    public ResponseEntity<BrandMinMaxPriceByCategoryDto> getBrandPriceByCategoryName(String categoryName) {
        if(StringUtils.isEmpty(categoryName)){
            throw new CustomException(ErrorCode.INVALID_REQUEST);
        }
        BrandMinMaxPriceByCategoryDto result = productService.getBrandPriceByCategoryName(categoryName);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "구현4)상품 및 브랜드 추가")
    @PostMapping("/brand/manage")
    public ResponseEntity<BrandProductInfoDto> postBrandMange(@RequestBody BrandProductDto param) {
        if (StringUtils.isEmpty(param.getBrandName())) {
            throw new CustomException(ErrorCode.INVALID_REQUEST_BRAND);
        }

        if (StringUtils.isEmpty(param.getCategoryName())) {
            throw new CustomException(ErrorCode.INVALID_REQUEST_CATEGORY);
        }

        BrandProductInfoDto result = productService.postBrandMange(param);

        return ResponseEntity.ok(result);
    }

    @Operation(summary = "구현4)상품 및 브랜드 수정")
    @PutMapping("/brand/manage")
    public ResponseEntity<BrandProductInfoDto> putBrandMange(@RequestBody BrandProductDto param) {
        if (StringUtils.isEmpty(param.getBrandName()) || param.getBrandId() < 1L) {
            throw new CustomException(ErrorCode.INVALID_REQUEST_BRAND);
        }

        if (StringUtils.isEmpty(param.getCategoryName()) || param.getProductId() < 1L) {
            throw new CustomException(ErrorCode.INVALID_REQUEST_CATEGORY);
        }

        BrandProductInfoDto result = productService.putBrandMange(param);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "구현4)상품 및 브랜드 삭제")
    @DeleteMapping("/brand/manage")
    public ResponseEntity<Boolean> deleteBrandMange(@RequestBody BrandProductDeleteDto param) {
        if (param.getBrandId() < 1L) {
            throw new CustomException(ErrorCode.INVALID_REQUEST_BRAND);
        }

        if (param.getProductId() < 1L) {
            throw new CustomException(ErrorCode.INVALID_REQUEST_CATEGORY);
        }

        Boolean result = productService.deleteBrandMange(param);
        return ResponseEntity.ok(result);
    }
}
