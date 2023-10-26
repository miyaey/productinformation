package com.example.productinformation.data.service;

import com.example.productinformation.data.dto.ProductInformationDto;
import com.example.productinformation.data.entity.ProductInformationEntity;

import java.util.List;

public interface ProductInformationService {
    ProductInformationEntity createProduct(ProductInformationDto productInformationDto);
    List<ProductInformationEntity> getAllProduct();
    ProductInformationEntity getProductById(int productId);
    ProductInformationEntity updateProduct(int productId, ProductInformationDto productInformationDto);
    void deleteProduct(int productId);
    List<ProductInformationEntity> findByNameContaining(String keyword);
    List<ProductInformationEntity> findByPriceLessThan(int value);
    List<ProductInformationEntity> findByPriceGreaterThan(int value);
    List<ProductInformationEntity> findByPriceBetween(int value, int value2);
}
