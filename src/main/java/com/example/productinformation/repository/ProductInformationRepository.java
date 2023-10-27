package com.example.productinformation.repository;

import com.example.productinformation.entity.ProductInformationEntity;
import com.example.productinformation.service.ProductInformationService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInformationRepository extends JpaRepository<ProductInformationEntity, Integer> {
    List<ProductInformationEntity> findByProductNameContaining(String keyword);
    List<ProductInformationEntity> findByProductPriceLessThan(int value);
    List<ProductInformationEntity> findByProductPriceGreaterThan(int value);
    List<ProductInformationEntity> findByProductPriceBetween(int value1, int value2);
    List<ProductInformationEntity> findByCategory(String category);
}
