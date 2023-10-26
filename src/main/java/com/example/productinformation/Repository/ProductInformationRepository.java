package com.example.productinformation.Repository;

import com.example.productinformation.entity.ProductInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInformationRepository extends JpaRepository<ProductInformationEntity, Integer> {
    List<ProductInformationEntity> findByProductNameContaining(String keyword);
    List<ProductInformationEntity> findByProductPriceLessThan(int value);
    List<ProductInformationEntity> findByProductPriceGreaterThan(int value);
    List<ProductInformationEntity> findByProductPriceBetween(int value1, int value2);
}
