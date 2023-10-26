package com.example.productinformation.service;

import com.example.productinformation.data.dto.ProductInformationDto;
import com.example.productinformation.entity.ProductInformationEntity;

import java.util.List;

public interface ProductInformationService {
    ProductInformationEntity createProduct(ProductInformationDto productInformationDto);
    List<ProductInformationEntity> getAllProduct();
    ProductInformationEntity getProductById(int productId);
    ProductInformationEntity updateProduct(int productId, ProductInformationDto productInformationDto);
    void deleteProduct(int productId);
    List<ProductInformationEntity> findByProductNameContaining(String keyword);
    List<ProductInformationEntity> findByProductPriceLessThan(int value);
    List<ProductInformationEntity> findByProductPriceGreaterThan(int value);
    List<ProductInformationEntity> findByProductPriceBetween(int value, int value2);
}
