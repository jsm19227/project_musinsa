package com.musinsa.backend.domain.repository;

import com.musinsa.backend.domain.entity.QBrand;
import com.musinsa.backend.domain.entity.QProduct;
import com.musinsa.backend.dto.response.BrandPriceDto;
import com.musinsa.backend.dto.response.MinMaxPriceDto;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Tuple> getCategoryBrandLowestPrice() {
        QProduct product = QProduct.product;
        QBrand brand = QBrand.brand;
        QProduct subProduct = new QProduct("subProduct");

        return queryFactory
                .select(
                        product.categoryName,
                        brand.brandName,
                        product.price
                )
                .from(product)
                .innerJoin(brand).on(product.brand.id.eq(brand.id).and(brand.deletedDate.isNull()))
                .where(
                        product.price.eq(
                                JPAExpressions
                                        .select(subProduct.price.min())
                                        .from(subProduct)
                                        .where(subProduct.categoryName.eq(product.categoryName),
                                                subProduct.deletedDate.isNull()
                                        )
                        )
                )
                .where(product.deletedDate.isNull())
                .orderBy(product.categoryName.asc())
                .fetch();
    }

    @Override
    public Long getGroupByCategoryNameCount(){
        QProduct product = QProduct.product;
        return queryFactory
                .select(product.categoryName.countDistinct())
                .from(product)
                .where(product.deletedDate.isNull())
                .fetchOne();
    }

    @Override
    public List<Tuple> getCategoryBrandTotalPriceByCategoryCount(Long categoryCount){
        QProduct product = QProduct.product;
        QBrand brand = QBrand.brand;

        return queryFactory
                .select(
                        brand.id,
                        brand.brandName,
                        product.price.sum()
                )
                .from(product)
                .innerJoin(brand).on(product.brand.id.eq(brand.id).and(brand.deletedDate.isNull()))
                .where(product.deletedDate.isNull())
                .groupBy(brand.id)
                .having(product.categoryName.countDistinct().eq(categoryCount))
                .fetch();
    }

    @Override
    public List<Tuple> getCategoryPriceByBrandId(Long brandId){
        QProduct product = QProduct.product;
        QBrand brand = QBrand.brand;

        return queryFactory
                .select(
                        brand.brandName,
                        product.categoryName,
                        product.price
                )
                .from(product)
                .innerJoin(brand).on(product.brand.id.eq(brand.id).and(brand.deletedDate.isNull()))
                .where(brand.id.eq(brandId),
                        product.deletedDate.isNull()
                )
                .fetch();
    }

    @Override
    public MinMaxPriceDto getMinMaxPrice(String categoryName){
        QProduct product = QProduct.product;

        return queryFactory
                .select(
                        Projections.constructor(MinMaxPriceDto.class,
                                product.price.min(),
                                product.price.max()
                        )
                )
                .from(product)
                .where(
                        product.categoryName.eq(categoryName),
                        product.deletedDate.isNull())
                .fetchOne();
    }

    @Override
    public List<BrandPriceDto> getProductByPrice(String categoryName, Long price){
        QProduct product = QProduct.product;
        QBrand brand = QBrand.brand;

        return queryFactory
                .select(
                        Projections.constructor(BrandPriceDto.class,
                                brand.brandName,
                                product.price
                        )
                )
                .from(product)
                .innerJoin(brand).on(product.brand.id.eq(brand.id).and(brand.deletedDate.isNull()))
                .where(
                        product.categoryName.eq(categoryName),
                        product.price.eq(price),
                        product.deletedDate.isNull()
                )
                .fetch();
    }
}
