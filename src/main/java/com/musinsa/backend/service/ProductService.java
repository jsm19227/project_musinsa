package com.musinsa.backend.service;

import com.musinsa.backend.domain.entity.Brand;
import com.musinsa.backend.domain.entity.Product;
import com.musinsa.backend.domain.entity.QBrand;
import com.musinsa.backend.domain.entity.QProduct;
import com.musinsa.backend.domain.repository.BrandRepository;
import com.musinsa.backend.domain.repository.ProductRepository;
import com.musinsa.backend.dto.request.BrandProductDeleteDto;
import com.musinsa.backend.dto.request.BrandProductDto;
import com.musinsa.backend.dto.response.*;
import com.musinsa.backend.exception.CustomException;
import com.musinsa.backend.exception.ErrorCode;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public CategoryBrandPriceDto getCategoryBrandLowestPrice(){
        QProduct product = QProduct.product;
        QBrand brand = QBrand.brand;
        List<Tuple> results = productRepository.getCategoryBrandLowestPrice();

        List<CategoryBrandLowestPriceDto> priceInfos = results.stream()
                .map(tuple -> new CategoryBrandLowestPriceDto(
                        tuple.get(product.categoryName),
                        tuple.get(brand.brandName),
                        tuple.get(product.price)
                ))
                .collect(Collectors.groupingBy(CategoryBrandLowestPriceDto::getCategoryName))
                .entrySet().stream()
                .map(entry -> {
                    String categoryName = entry.getKey();
                    List<CategoryBrandLowestPriceDto> group = entry.getValue();

                    String brandNames = group.stream()
                            .map(CategoryBrandLowestPriceDto::getBrandName)
                            .distinct()
                            .collect(Collectors.joining(", "));

                    Long lowestPrice = group.get(0).getLowestPrice();

                    return new CategoryBrandLowestPriceDto(categoryName, brandNames, lowestPrice);
                })
                .collect(Collectors.toList());

        Long totalPrice = priceInfos.stream()
                .map(CategoryBrandLowestPriceDto::getLowestPrice)
                .reduce(0L, Long::sum);

        return new CategoryBrandPriceDto(priceInfos, new DecimalFormat("#,###").format(totalPrice));
    }

    public CategoryBrandTotalLowestPriceDto getBrandTotalLowestPrice(){
        QProduct product = QProduct.product;
        QBrand brand = QBrand.brand;

        // 카테고리 갯수를 조회
        Long categoryCount = productRepository.getGroupByCategoryNameCount();
        // 카테고리를 모두 가지고 있는 브랜드의 최저 상품가격 조회
        List<Tuple> categoryBrandTotalPrice = productRepository.getCategoryBrandTotalPriceByCategoryCount(categoryCount);

        // 최저 가격
        Long minTotalPrice = categoryBrandTotalPrice.stream()
                .map(tuple -> tuple.get(product.price.sum()))
                .min(Long::compare)
                .orElse(null);

        // 최저가 가격이 같은 브랜드가 여러개 발생할 수 있지만 response 구조가 달라지기 때문에 하나만 임의로 가져와 response 구성
        Long brandId = categoryBrandTotalPrice.stream()
                .filter(tuple -> tuple.get(product.price.sum()).equals(minTotalPrice))
                .map(tuple -> tuple.get(brand.id))
                .findFirst() // 딱 하나만 고른다
                .orElse(null);

        List<Tuple> CategoryPriceByBrandIds = productRepository.getCategoryPriceByBrandId(brandId);

        String brandName = null;
        List<CategoryPriceDto> categoryPriceList = new ArrayList<>();

        for (Tuple tuple : CategoryPriceByBrandIds) {
            if (brandName == null) {
                brandName = tuple.get(brand.brandName);
            }
            String categoryName = tuple.get(product.categoryName);
            Long price = tuple.get(product.price);
            categoryPriceList.add(new CategoryPriceDto(categoryName, price));
        }

        return new CategoryBrandTotalLowestPriceDto(
                brandName,
                categoryPriceList,
                new DecimalFormat("#,###").format(minTotalPrice)
        );

    }

    public BrandMinMaxPriceByCategoryDto getBrandPriceByCategoryName(String categoryName){
        MinMaxPriceDto minMaxPrice = productRepository.getMinMaxPrice(categoryName);

        if (minMaxPrice == null || minMaxPrice.getMinPrice() == null || minMaxPrice.getMaxPrice() == null) {
            throw new CustomException(ErrorCode.ENTITY_NOT_FOUND);
        }

        List<BrandPriceDto> lowestProducts = productRepository.getProductByPrice(categoryName, minMaxPrice.getMinPrice());
        List<BrandPriceDto> highestProducts = productRepository.getProductByPrice(categoryName, minMaxPrice.getMaxPrice());

        if (CollectionUtils.isEmpty(lowestProducts) || CollectionUtils.isEmpty(highestProducts)) {
            throw new CustomException(ErrorCode.ENTITY_NOT_FOUND);
        }

        return new BrandMinMaxPriceByCategoryDto(
                categoryName,
                lowestProducts,
                highestProducts
        );

    }

    @Transactional
    public BrandProductInfoDto postBrandMange(BrandProductDto param){
        Brand brand = Brand.builder()
                .brandName(param.getBrandName())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        brand = brandRepository.save(brand);

        Product product = Product.builder()
                .categoryName(param.getCategoryName())
                .price(param.getPrice())
                .brand(brand)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
        product = productRepository.save(product);


        return BrandProductInfoDto.builder()
                .brandId(brand.getId())
                .productId(product.getId())
                .brandName(brand.getBrandName())
                .categoryName(product.getCategoryName())
                .price(product.getPrice())
                .build();
    }

    @Transactional
    public BrandProductInfoDto putBrandMange(BrandProductDto param){
        Brand brand = brandRepository.findById(param.getBrandId()).orElse(null);
        if(brand == null){
            throw new CustomException(ErrorCode.INVALID_REQUEST_BRAND_NULL);
        }

        Product product = productRepository.findById(param.getProductId()).orElse(null);
        if(product == null){
            throw new CustomException(ErrorCode.INVALID_REQUEST_CATEGORY_NULL);
        }

        brand.setBrandName(param.getBrandName());
        brand.setUpdatedDate(LocalDateTime.now());

        product.setCategoryName(param.getCategoryName());
        product.setPrice(param.getPrice());
        product.setUpdatedDate(LocalDateTime.now());

        brand = brandRepository.save(brand);
        product = productRepository.save(product);

        return BrandProductInfoDto.builder()
                .brandId(brand.getId())
                .productId(product.getId())
                .brandName(brand.getBrandName())
                .categoryName(product.getCategoryName())
                .price(product.getPrice())
                .build();
    }


    @Transactional
    public Boolean deleteBrandMange(BrandProductDeleteDto param){
        Brand brand = brandRepository.findById(param.getBrandId()).orElse(null);
        if(brand == null){
            throw new CustomException(ErrorCode.INVALID_REQUEST_BRAND_NULL);
        }

        Product product = productRepository.findById(param.getProductId()).orElse(null);
        if(product == null){
            throw new CustomException(ErrorCode.INVALID_REQUEST_CATEGORY_NULL);
        }

        brand.setDeletedDate(LocalDateTime.now());
        product.setDeletedDate(LocalDateTime.now());

        brandRepository.save(brand);
        productRepository.save(product);

        return Boolean.TRUE;
    }

}
