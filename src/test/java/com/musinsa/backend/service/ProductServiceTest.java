package com.musinsa.backend.service;

import com.musinsa.backend.domain.entity.Brand;
import com.musinsa.backend.domain.entity.Product;
import com.musinsa.backend.domain.repository.BrandRepository;
import com.musinsa.backend.domain.repository.ProductRepository;
import com.musinsa.backend.dto.request.BrandProductDeleteDto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.musinsa.backend.dto.request.BrandProductDto;
import com.musinsa.backend.dto.response.BrandProductInfoDto;
import com.musinsa.backend.exception.CustomException;
import com.musinsa.backend.exception.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.util.Optional;

public class ProductServiceTest {
    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("Insert Success Case")
    void postBrandMangeSuccess() {
        // given
        BrandProductDto param = new BrandProductDto(
                null,
                null,
                "Z",
                "반지",
                1000L
        );

        Brand savedBrand = Brand.builder()
                .id(1L)
                .brandName(param.getBrandName())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Product savedProduct = Product.builder()
                .id(10L)
                .categoryName(param.getCategoryName())
                .price(param.getPrice())
                .brand(savedBrand)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        when(brandRepository.save(any(Brand.class))).thenReturn(savedBrand);
        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        // when
        BrandProductInfoDto result = productService.postBrandMange(param);

        // then
        then(brandRepository).should().save(any(Brand.class));
        then(productRepository).should().save(any(Product.class));

        assertThat(result).isNotNull();
        assertThat(result.getBrandId()).isEqualTo(savedBrand.getId());
        assertThat(result.getProductId()).isEqualTo(savedProduct.getId());
        assertThat(result.getBrandName()).isEqualTo(savedBrand.getBrandName());
        assertThat(result.getCategoryName()).isEqualTo(savedProduct.getCategoryName());
        assertThat(result.getPrice()).isEqualTo(savedProduct.getPrice());
    }



    @Test
    @DisplayName("Update Success Case")
    void putBrandMangeSuccess() {
        // given
        BrandProductDto param = new BrandProductDto(
                1L,
                1L,
                "B",
                "상의",
                1000L
        );

        Brand existingBrand = Brand.builder()
                .id(param.getBrandId())
                .brandName("A")
                .createdDate(LocalDateTime.now().minusDays(10))
                .updatedDate(LocalDateTime.now().minusDays(10))
                .build();

        Product existingProduct = Product.builder()
                .id(param.getProductId())
                .categoryName("상의")
                .price(2000L)
                .brand(existingBrand)
                .createdDate(LocalDateTime.now().minusDays(10))
                .updatedDate(LocalDateTime.now().minusDays(10))
                .build();

        when(brandRepository.findById(param.getBrandId())).thenReturn(Optional.of(existingBrand));
        when(productRepository.findById(param.getProductId())).thenReturn(Optional.of(existingProduct));
        when(brandRepository.save(any(Brand.class))).thenReturn(existingBrand);
        when(productRepository.save(any(Product.class))).thenReturn(existingProduct);

        // when
        BrandProductInfoDto result = productService.putBrandMange(param);

        // then
        then(brandRepository).should().save(existingBrand);
        then(productRepository).should().save(existingProduct);

        assertThat(result).isNotNull();
        assertThat(result.getBrandId()).isEqualTo(existingBrand.getId());
        assertThat(result.getProductId()).isEqualTo(existingProduct.getId());
        assertThat(result.getBrandName()).isEqualTo(param.getBrandName());
        assertThat(result.getCategoryName()).isEqualTo(param.getCategoryName());
        assertThat(result.getPrice()).isEqualTo(param.getPrice());
    }

    @Test
    @DisplayName("Update Brand Not Found Case")
    void putBrandMangeBrandNotFound() {
        // given
        BrandProductDto param = new BrandProductDto(999L, 1L, "A", "상의", 10L);

        given(brandRepository.findById(param.getBrandId())).willReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> productService.putBrandMange(param))
                .isInstanceOf(CustomException.class)
                .extracting("errorCode")
                .isEqualTo(ErrorCode.INVALID_REQUEST_BRAND_NULL);
    }

    @Test
    @DisplayName("Update Product Not Found Case")
    void putBrandMangeProductNotFound() {
        // given
        BrandProductDto param = new BrandProductDto(1L, 999L, "A", "상의", 10L);

        Brand existingBrand = Brand.builder()
                .id(param.getBrandId())
                .brandName("A")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        given(brandRepository.findById(param.getBrandId())).willReturn(Optional.of(existingBrand));
        given(productRepository.findById(param.getProductId())).willReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> productService.putBrandMange(param))
                .isInstanceOf(CustomException.class)
                .extracting("errorCode")
                .isEqualTo(ErrorCode.INVALID_REQUEST_CATEGORY_NULL);
    }


    @Test
    @DisplayName("Delete Success Case")
    void deleteBrandMangeSuccess() {
        Long brandId = 1L;
        Long productId = 1L;
        Brand brand = new Brand();
        Product product = new Product();
        BrandProductDeleteDto param = new BrandProductDeleteDto(brandId, productId);

        when(brandRepository.findById(brandId)).thenReturn(Optional.of(brand));
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // when
        Boolean result = productService.deleteBrandMange(param);

        // then
        then(brandRepository).should().save(brand);
        then(productRepository).should().save(product);
        assertThat(result).isTrue();
        assertThat(brand.getDeletedDate()).isNotNull();
        assertThat(product.getDeletedDate()).isNotNull();
    }

    @Test
    @DisplayName("Delete Brand Not Found Case")
    void deleteBrandMangeBrandNotFound() {
        // given
        Long brandId = 9999L;
        Long productId = 9999L;
        BrandProductDeleteDto param = new BrandProductDeleteDto(brandId, productId);

        given(brandRepository.findById(brandId)).willReturn(Optional.empty());

        // when & then
        assertThatThrownBy(() -> productService.deleteBrandMange(param))
                .isInstanceOf(CustomException.class)
                .extracting("errorCode")
                .isEqualTo(ErrorCode.INVALID_REQUEST_BRAND_NULL);
    }

    @Test
    @DisplayName("Delete Product Not Found Case")
    void deleteBrandMangeProductNotFound() {
        Long brandId = 999L;
        Long productId = 999L;
        Brand brand = new Brand();
        BrandProductDeleteDto param = new BrandProductDeleteDto(brandId, productId);

        given(brandRepository.findById(brandId)).willReturn(Optional.of(brand));
        given(productRepository.findById(productId)).willReturn(Optional.empty());

        assertThatThrownBy(() -> productService.deleteBrandMange(param))
                .isInstanceOf(CustomException.class)
                .extracting("errorCode")
                .isEqualTo(ErrorCode.INVALID_REQUEST_CATEGORY_NULL);
    }
}
